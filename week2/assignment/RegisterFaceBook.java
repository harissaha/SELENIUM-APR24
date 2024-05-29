package week2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterFaceBook {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//a[text()='Create a Page']/preceding::form/div[5]/a")).click();
		driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("john");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("max");
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input")).sendKeys("123456789");
		driver.findElement(By.id("password_step_input")).sendKeys("12345678");
		Thread.sleep(3000);
		WebElement dateEle = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateDD = new Select(dateEle);
		dateDD.selectByIndex(3);
		
		WebElement monthEle = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthDD = new Select(monthEle);
		dateDD.selectByValue("1");
		/*
		 * WebElement yearEle = driver.findElement(By.xpath("//select[@id='Year']"));
		 * Select yearDD = new Select(yearEle); yearDD.selectByVisibleText("2022");
		 */
		
		driver.findElement(By.xpath("//label[text()='Male']/following-sibling::input")).click();
		driver.findElement(By.name("websubmit")).click();
	}
}
