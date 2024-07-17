import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector(".icp-nav-link-inner"))).build().perform();
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().sendKeys("Hello Kitty").doubleClick().scrollToElement(null).build().perform();	
		
	}

}
