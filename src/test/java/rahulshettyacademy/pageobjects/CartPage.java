package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	@FindBy(css = ".inventory_item_name")
	List<WebElement> cartList;

	@FindBy(id = "checkout")
	WebElement checkOut;

	@FindBy(id = "first-name")
	WebElement firstName;

	@FindBy(id = "last-name")
	WebElement lastName;

	@FindBy(id = "postal-code")
	WebElement postalCode;

	@FindBy(id = "continue")
	WebElement continueButton;
	
	@FindBy(id = "finish")
	WebElement finishButton;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartList.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	public ConfirmationPage CartList() {
		checkOut.click();
		return new ConfirmationPage(driver);
	}

	public ConfirmationPage yourInfo(String FN, String LN, String PC) {
		firstName.sendKeys(FN);
		lastName.sendKeys(LN);
		postalCode.sendKeys(PC);
		continueButton.click();
		finishButton.click();
		return new ConfirmationPage(driver);
	}
	
}
