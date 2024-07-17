import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement emailEditBox = driver.findElement(By.cssSelector("input[name='email']"));
		driver.findElement(with(By.tagName("label")).below(emailEditBox)).getText();

	}

	private static Object with(By tagName) {
		// TODO Auto-generated method stub
		return null;
	}

}
