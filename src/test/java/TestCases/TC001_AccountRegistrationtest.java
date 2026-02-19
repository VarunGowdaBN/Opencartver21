package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Testbase.Basetest;
import pageObjects.HomePage;
import pageObjects.Registrationpage;

public class TC001_AccountRegistrationtest extends Basetest
{
	
	@Test(groups = {"sanity","master","regression"})
	public void Account_registration()
	{
		logger.info("====================Test execution started====================");
		HomePage hp=new HomePage(driver);
		hp.MyAccount();
		logger.info("clicking on myaccount link");
		hp.Register();
		logger.info("clicking on register link");
		
		Registrationpage Rp=new Registrationpage(driver);
		logger.info("entering values");
		Rp.first_name(randomstring().toUpperCase());
		Rp.last_name(randomstring().toUpperCase());
		Rp.E_mail(randomstring()+"@gmail.com");
		Rp.telephone(randomnumber());
		String pwd=randomalphanumeric();
		Rp.password(pwd);
		Rp.confirm_pwd(pwd);
		Rp.privacy_policy();
		logger.info("clicked on continue button");
		Rp.continuee();
		String conmess=Rp.confirmation_mess();
		logger.info("validating confirm message");
		//Assert.assertEquals(conmess, "Your Account Has Been Created!");
		if(conmess.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		
		logger.info("==========================test execution ends========================");
	}

}
