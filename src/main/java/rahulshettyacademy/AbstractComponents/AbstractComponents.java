package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
			this.driver = driver;
	}

	public void waitForElementToAppear(By findBy)
	{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	}

}
