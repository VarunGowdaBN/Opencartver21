package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver)
	{
		super(driver);
		//System.out.println("Driver in HomePage constructor: " + driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement clickmyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement clickregister;
	@FindBy(xpath="(//a[normalize-space()='Login'])[1]")
	WebElement clicklogin;
	
	public void MyAccount()
	{
	    clickmyaccount.click();
	}
	public void Register()
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement element = wait.until(
	            ExpectedConditions.elementToBeClickable(clickregister)
	    );
	    element.click();
	}
	public void login()
	{
		clicklogin.click();
	}

}
