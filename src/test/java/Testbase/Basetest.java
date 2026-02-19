package Testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Basetest 
{ 
    public static WebDriver driver;
    public  Logger logger;
    public Properties pa;
	@BeforeClass(groups = {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void Setup(String os,String br) throws IOException
	{
		FileReader file = new FileReader(
			    System.getProperty("user.dir") + "/src/test/resources/config.properties"
			);
		pa=new Properties();
		pa.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		if(pa.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities Descap=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				Descap.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				Descap.setPlatform(Platform.MAC);
			}
			else if (os.equalsIgnoreCase("linux"))
			{
				Descap.setPlatform(Platform.LINUX);
			}
			else 
			{
				System.out.println(" Os is not matching");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome": Descap.setBrowserName("chrome"); break;
			case "edge": Descap.setBrowserName("MicrosoftEdge");break;
			case "firefox": Descap.setBrowserName("firefox");break;
			default: System.out.println("no matching browser"); return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),Descap);
		}
		if(pa.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge"   : driver=new EdgeDriver();break;
		case "firefox" : driver=new FirefoxDriver();break;
		default : System.out.println("invalid browser"); return;
		}}
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(pa.getProperty("appurl"));
	    driver.get(pa.getProperty("appurl"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups = {"sanity","regression","master"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomnumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomalphanumeric()
	{
		String generatealpha=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return(generatealpha+generatednumber);
	}
	
	public String Screenshot(String sc) throws IOException
	{
		String timestamp =new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		TakesScreenshot tc= (TakesScreenshot)driver;
		File sourcefile=tc.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath=System.getProperty("user.dir")+"\\Screenshots\\"+sc+"_"+timestamp;
		File targetfile=new File(targetfilepath);
		sourcefile.renameTo(targetfile);
		
		return targetfilepath;
	}

}
