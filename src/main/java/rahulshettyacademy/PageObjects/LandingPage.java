package rahulshettyacademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver Driver, WebDriver driver)
	{
		super(Driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

		
		//WebElement userEmails = driver.findElement(By.id("userEmail"));
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement passwordEle;
		
		@FindBy(id="login")
		WebElement submit;
		
		public static ProductCatalogue loginApplication(String email, String Password)
		{
			userEmail.sendKeys(email);
			passwordEle.sendKeys(Password);
			submit.click();
		}
		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		

	

}
