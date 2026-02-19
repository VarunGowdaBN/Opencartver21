package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
	super(driver);
    }
    
    @FindBy (xpath = "//input[@id='input-email']")
    WebElement email;
    @FindBy (xpath = "//input[@id='input-password']")
    WebElement pwd;
    @FindBy (xpath = "//input[@value='Login']")
    WebElement loginbtn;
    
    
    public void email_Address(String emaill)
    {
    	email.sendKeys(emaill);
    }
    public void Pwd(String Pwdd)
    {
    	pwd.sendKeys(Pwdd);
    }
    public void login_btn()
    {
    	loginbtn.click();
    }
    
    
}
