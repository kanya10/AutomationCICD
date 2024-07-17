import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SeleniumDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Sukanya");
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("sukanya.r3@cognizant.com");
		Thread.sleep(2000);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Welcome123");
		Thread.sleep(2000);
		driver.findElement(By.id("exampleCheck1")).click();
		System.out.println(driver.findElement(By.id("exampleCheck1")).isSelected());
		WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("Female");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("10-10-1991");
		driver.findElement(By.cssSelector("input.btn.btn-success")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());

	}

}
