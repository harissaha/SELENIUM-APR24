package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapdealTestcase {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean displayed = driver.findElement(By.id("pushDenied")).isDisplayed();
		if (displayed) {
			driver.findElement(By.id("pushDenied")).click();
		}
		WebElement eleMen = driver.findElement(By.xpath("//div[@id='category1Data']/preceding-sibling::a"));
		Actions builder = new Actions(driver);
		builder.moveToElement(eleMen).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		String shoeCount = driver
				.findElement(By.xpath("//div[contains(text(),\"Men's Sports Fashion\")]/following-sibling::div"))
				.getText();
		System.out.println(shoeCount);
		driver.findElement(By.xpath("//div[text()='Training Shoes']/parent::a")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
		driver.findElement(By.xpath("//li[@data-sorttype=\"plth\"]")).click();
		List<WebElement> priceList = driver.findElements(By.xpath("//span[contains(@id,'display-price')]"));
		System.out.println(priceList.size());
		List<Integer> priceIntList = new ArrayList<Integer>();
		for (int i = 0; i < priceList.size() - 1; i++) {
			Thread.sleep(5000);
			String attribute = priceList.get(i).getAttribute("display-price");
			//System.out.println(attribute);
			int priceInt = Integer.parseInt(attribute);
			priceIntList.add(priceInt);
		}
		for (Integer each : priceIntList) {
			System.out.println("Below is the Pricelist:");
			System.out.println(each);
		}
		
		for (int i = 0; i < priceIntList.size()-1; i++) {
			if((priceIntList.get(i))<(priceIntList.get(i+1))) {
				System.out.println("Sorting is done based on price : Low To High as expected");
			} else {
				System.out.println("Sorting is not done based on price : Low To High as expected");
			}
		}
	}

}
