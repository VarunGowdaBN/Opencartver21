package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage
{
	 WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	//	System.out.println("Driver in HomePage constructor: " + driver);
		PageFactory.initElements(driver,this);
	}

}
