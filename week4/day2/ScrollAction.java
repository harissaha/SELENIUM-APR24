package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollAction {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement eleScroll = driver.findElement(By.linkText("Conditions of Use & Sale"));
		Actions builder = new Actions(driver);
		builder.scrollToElement(eleScroll).perform();
		String text = eleScroll.getText();
		System.out.println("Text Is: "+text);
	}

}
