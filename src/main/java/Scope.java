import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement FooterDriver = driver.findElement(By.cssSelector(".main-footer"));
		System.out.println(FooterDriver.findElements(By.tagName("a")).size());
		
	}

}
