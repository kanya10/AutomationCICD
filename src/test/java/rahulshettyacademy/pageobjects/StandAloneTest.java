package rahulshettyacademy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.PageObjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productName = "Sauce Labs Backpack";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		LandinPage landinpage = new LandinPage(driver);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item")));
		List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
		WebElement prod = products.stream().filter(product->
	product.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText().equals(productName)).findFirst().orElse(null);//whatever filtered product stored in "product
	prod.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory ")).click();
	driver.findElement(By.cssSelector(".shopping_cart_link")).click();
	
	List<WebElement> cartProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
	Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	Assert.assertTrue(match);
	
	driver.findElement(By.id("checkout")).click();
	
	driver.findElement(By.id("first-name")).sendKeys("Sukanya");
	driver.findElement(By.id("last-name")).sendKeys("R");
	driver.findElement(By.id("postal-code")).sendKeys("94004");
	driver.findElement(By.id("continue")).click();
	driver.findElement(By.id("finish")).click();
	System.out.println(driver.findElement(By.cssSelector(".complete-header")).getText());
	System.out.println(driver.findElement(By.cssSelector(".complete-text")).getText());
	
	}

}
