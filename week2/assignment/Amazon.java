package week2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	
	public static void main(String[] args) {
		// 01) Launch Chrome 
		ChromeDriver driver = new ChromeDriver();
		
		//02) Load https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//03) Type "Bags for b" in the Search box
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for b");		
		//04) Choose the 	 item in the result (bags for boys)
		 driver.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();
		//05) Print the total number of results (like 50000) 1-48 of over 30,000 results for "bags for boys"
		 WebElement resultCount = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
		 WebElement resultCategory = driver.findElement(By.xpath("//span[contains(text(),'results for')]/following-sibling::span[2]"));
		 System.out.println(resultCount.getText()+" "+resultCategory.getText());
		// 06) Select the first brand in the left menu
		   driver.findElement(By.xpath("(//span[text()='Brand']/following::span//label/i)[1]")).click();
		//07) Choose New Arrivals (Sort)
		 //  driver.findElement(By.xpath("//span[text()='New Arrivals']/following::span//span[text()='Last 30 days']")).click();
		//08) Print the first resulting bag info (name, discounted price)
		   WebElement bagInfo = driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span)[1]"));
		   System.out.println(bagInfo.getText());
		   WebElement price = driver.findElement(By.xpath("(//span[@class='a-price']/span)[1]"));
		   System.out.println("Price: "+price.getText());
		//09) Get the page title and close the browser(driver.close())
		   System.out.println("Page Title: "+driver.getTitle());
		   
	}

}
