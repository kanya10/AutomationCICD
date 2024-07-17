import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamsIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td"));
		List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(elementList.equals(sortedList));
		List<WebElement> rowList = driver.findElements(By.xpath("//tr/td[1]"));
		Object price = rowList.stream().filter(s -> s.getText().contains("Brinjal"))
				.map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		((Stream<WebElement>) price).forEach(a->System.out.println(a));
		if(((List<WebElement>) price).size()<1);
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		{
			
		
	}while(((List<WebElement>) price).size()<1);}
		
		
	

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}

}
