package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSite {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles",Keys.ENTER);
		List<WebElement> mobilePrices = driver.findElements(By.className("a-price-whole"));
		List<String> output = new ArrayList<String>();
		for (WebElement webElement : mobilePrices) {
			String text = webElement.getText();
			output.add(text);
		}
		for (String string : output) {
			System.out.println(string);
		}
	}
}
