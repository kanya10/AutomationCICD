package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandinPage {
	
	WebDriver driver;
	
	public LandinPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
   
   @FindBy(id="user-name")
   WebElement username;
   
   @FindBy(id="password")
   WebElement password;
   
   @FindBy(id="login-button")
   WebElement LoginButton;
   
   @FindBy(css=".error-button")
   WebElement errorMessage;
   
   public ProductCatalogue loginApplication(String email, String Password)
   {
	   username.sendKeys(email);
	   password.sendKeys(Password);
	   LoginButton.click();
	   ProductCatalogue productCatalogue = new ProductCatalogue(driver);
	   return productCatalogue;
   }
   
   public String getErrorMessage()
   {
	   
	   return errorMessage.getText();
   }
   
   public void goTo()
	{
		driver.get("https://www.saucedemo.com");
	}

}