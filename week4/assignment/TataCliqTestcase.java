package week4.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TataCliqTestcase {
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();	
		// Load the url as https://www.tatacliq.com/
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement elePopup = driver.findElement(By.xpath("//button[text()='Ask me later']"));
		if(elePopup.isDisplayed()) {
			elePopup.click();
		}
		// MouseHover on 'Brands'
		WebElement eleBrand = driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryAndBrand'])[2]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(eleBrand).perform();
		// MouseHover on 'Watches & Accessories'
		WebElement eleWatch = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		builder.moveToElement(eleWatch).perform();
		// Choose the first option from the 'Featured brands'.
		driver.findElement(By.xpath("//div[@class='DesktopHeader__featureBrands']/div[2]")).click();
		// Select sortby: New Arrivals
		WebElement eleSortDd = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select dd = new Select(eleSortDd);
		dd.selectByVisibleText("New Arrivals");
		// choose men from catagories filter.
		driver.findElement(By.xpath("//div[text()='Men']/preceding-sibling::div")).click();
		// print all price of watches
		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		System.out.println(priceList.size());
		// click on the first resulting watch.
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[contains(@id,'ProductModule-')])[1]")).click();
		// compare two price are similar
		Set<String> windowHandles = driver.getWindowHandles();
		for (String each : windowHandles) {
			driver.switchTo().window(each);
		}
		WebElement priceFirstEle = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3"));
		System.out.println(priceFirstEle.getText());
		// click Add to cart and get count from the cart icon.
		WebElement eleCart = driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));
		builder.moveToElement(eleCart).click(eleCart).perform();
		WebElement productCount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']"));
		System.out.println(productCount.getText());
		// Click on the cart
		driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']/parent::div")).click();
		// Take a snap of the resulting page.
		Thread.sleep(3000);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/image.png");
		FileUtils.copyFile(src, dest);
		// All the opened windows one by one.
		for (String each : windowHandles) {
			driver.switchTo().window(each);
			Thread.sleep(3000);
			driver.close();
		}
	}

}
