package rahulshettyacademy.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test(groups = { "ErrorHandling" })

	public void LoginErrorValidation() throws IOException {

		landinpage.loginApplication("standard_use", "secret_sauce");
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",
				landinpage.getErrorMessage());

	}

	public void ProductErrorValidation() {

		String productName = "Sauce Labs Backpack";
		ProductCatalogue productcatalogue = landinpage.loginApplication("standard_user", "secret_sauce");
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		CartPage cartPage = productcatalogue.goToCartPage();
		List<WebElement> cartPage1 = cartPage.cartList;
		Boolean match = cartPage.verifyProductDisplay("Sauce Labs Backpackk");
		Assert.assertFalse(match);
	}
}