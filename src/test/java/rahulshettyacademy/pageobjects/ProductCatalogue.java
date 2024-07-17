package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;


public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalogue (WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
  // List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));

   
   @FindBy(css=".inventory_item")
   List<WebElement> products;
   
   By productsBy = By.cssSelector(".inventory_item");
   By addToCart = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory ");
   
   public List<WebElement> getProductList()
   {
	   waitForElementToAppear();
	   return products;
   }
   
   public WebElement getProductByName(String productName)
   {
	   WebElement prod = products.stream().filter(product->
		product.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText().equals(productName)).findFirst().orElse(null);
	   return prod;
   }
   
   public void addProductToCart(String productName)
   {
	   WebElement prods = getProductByName(productName);
			   prods.findElement(addToCart).click();
   }


}

   






   
