package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testbase.Basetest;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repname;
	
	public void onStart(ITestContext testContext)
	{
		String time =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname="Test_Report-"+time+".html";
		
		sparkreporter= new ExtentSparkReporter(".\\Reports\\"+ repname);
		sparkreporter.config().setDocumentTitle("Opencart automation report");
		sparkreporter.config().setReportName("Opencart regression testing");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Application", "Opencart");
		extent.setSystemInfo("Module", "admin");
		extent.setSystemInfo("sub-module", "customer");
		extent.setSystemInfo("user name", System.getProperty("user.name"));
		
		String os=testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("os", os);
		
		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("browser", browser);
		
		List<String>includedgroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedgroups.isEmpty())
		{
			extent.setSystemInfo("groups", includedgroups.toString());
		}

	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+" successfully executed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+" test failed" );
		test.log(Status.INFO, result.getThrowable().getMessage());
		try 
		{
		String path=new Basetest().Screenshot(result.getName());
		test.addScreenCaptureFromPath(path);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" test skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testContext)	
	{
			extent.flush();
			String pathofextentreport=System.getProperty("user.dir")+"\\Reports\\"+repname;
			File extentreport=new File(pathofextentreport);
			try 
			{
				Desktop.getDesktop().browse(extentreport.toURI());
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}

}
