package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Testbase.Basetest;
import Utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccountpage;

public class TC003TestdrivenLogin extends Basetest
{
	@Test(dataProvider="logindata",dataProviderClass = DataProviders.class,groups = {"master"})
	public void verify_login_DDT(String emailll,String pwdd, String exp )
	{
		logger.info("******** starting TC003TestdrivenLogin ************");
		logger.info("Executing test with Email={}, Expected={}", emailll, exp);
		try {
		HomePage hp=new HomePage(driver);
		hp.MyAccount();
		hp.login();
		
		LoginPage lp=new LoginPage(driver);
		lp.email_Address(emailll);
		lp.Pwd(pwdd);
		lp.login_btn();
		
		Myaccountpage mp=new Myaccountpage(driver);
		boolean myacc=mp.Is_Myaccountpage_exists();
		if(exp.equalsIgnoreCase("valid"))
		{
			if(myacc==true)
			{
				mp.Logout();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(myacc==true)
			{
				mp.Logout();
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("******** Finished TC003TestdrivenLogin ************");
	}

}
