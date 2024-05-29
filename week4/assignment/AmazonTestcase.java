package week4.assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonTestcase {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Search for "oneplus 9 pro".
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("oneplus 9 pro", Keys.ENTER);
		// Apply filter on new product
		WebElement eleNew = driver.findElement(By.xpath("//span[text()='New']"));
		Actions builder = new Actions(driver);
		builder.scrollToElement(eleNew).perform();
		eleNew.click();
		System.out.println("Done");
		// Get the price of the first product.
		WebElement priceFirPrdt = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		// builder.scrollToElement(priceFirPrdt).perform();
		String text = priceFirPrdt.getText();
		System.out.println("Price of the first product in result : " + text);
		// Print the number of customer ratings for the first displayed product.

		WebElement eleFrstPrdtRating = driver.findElement(By.xpath("//span[@class='a-icon-alt']"));
		System.out.println("Rating of the first product in result : " + eleFrstPrdtRating.getText());

		// Click the first text link of the first image.
		WebElement eleFirstResult = driver.findElement(By.xpath("//div[@data-cy=\"title-recipe\"]//a"));
		builder.moveToElement(eleFirstResult).perform();
		eleFirstResult.click();
		// Take a screenshot of the product displayed.
		// Click the 'Add to Cart' button.
		Set<String> windowHandles = driver.getWindowHandles();
		for (String each : windowHandles) {
			driver.switchTo().window(each);
		}
		Thread.sleep(5000);
		WebElement eleAddCart = driver.findElement(By.xpath("(//span[text()='Add to Cart'])[2]"));
		builder.scrollToElement(eleAddCart).click(eleAddCart).perform();
		//eleAddCart.click();
		// Get the cart subtotal and verify if it is correct.
		WebElement findElement = driver.findElement(By.id("attach-accessory-cart-subtotal"));
		System.out.println(findElement.getText() );
		// Close the browser.

	}

}
