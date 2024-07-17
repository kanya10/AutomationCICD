import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OwnPractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
		driver.findElement(By.id("signin2")).click();
		driver.findElement(By.id("sign-username")).sendKeys("Sukanya");
		driver.findElement(By.id("sign-password")).sendKeys("Operahouse");
		driver.findElement(By.cssSelector("button[onclick='register()']")).click();
		
	}
}