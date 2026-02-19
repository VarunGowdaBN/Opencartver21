package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Testbase.Basetest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccountpage;

public class TC002_Loginpagetest extends Basetest
{
	@Test (groups = {"regression","master","fun"})
	public void verify_login()
	{
		HomePage hp=new HomePage(driver);
		hp.MyAccount();
		hp.login();
		
		LoginPage lp=new LoginPage(driver);
		lp.email_Address(pa.getProperty("email"));
		lp.Pwd(pa.getProperty("pass"));
		lp.login_btn();
		
		Myaccountpage mp=new Myaccountpage(driver);
		boolean myacc=mp.Is_Myaccountpage_exists();
		Assert.assertTrue(myacc);
	}
	

}
