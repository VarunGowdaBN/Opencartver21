package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registrationpage extends BasePage
{
	public Registrationpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement Txt_first_name;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement Txt_last_name;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Txt_email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement Txt_telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Txt_Pwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement Txt_confirm_pwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement Check_Box_privacy_policy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Btn_continue ;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmation_mess;
	
	
	public void first_name(String firstname)
	{
		Txt_first_name.sendKeys(firstname);
	}
	public void last_name(String lastname)
	{
		Txt_last_name.sendKeys(lastname);
	}
	public void E_mail(String email)
	{
		Txt_email.sendKeys(email);
	}
	public void telephone(String telephone)
	{
		Txt_telephone.sendKeys(telephone);
	}
	public void password(String pwd)
	{
		Txt_Pwd.sendKeys(pwd);
	}
	public void confirm_pwd(String confirmpwd)
	{
		Txt_confirm_pwd.sendKeys(confirmpwd);
	}
	public void privacy_policy()
	{
		Check_Box_privacy_policy.click();
	}
	public void continuee()
	{
		Btn_continue.click();
	}
	public String confirmation_mess()
	{
		try {
			String conmess=confirmation_mess.getText();
			return conmess;
		    }
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}

}
