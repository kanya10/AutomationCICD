package rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	private static final String String = null;

	WebDriver driver;

	public ProductCatalogue(WebDriver Driver) {
		super(Driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");

	public List<WebElement> getproductList() {
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getproductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProductToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
	}

}
