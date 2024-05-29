package week4.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.sukgu.Shadow;

public class ServicenowTestcase {
	public static void main(String[] args) {
		/*
		 * Instance URL: https://dev200784.service-now.com/ Username: admin
		 * Password: k6C8-ajUWqY%
		 */
		ChromeDriver driver = new ChromeDriver();
		// Launch a web browser.
		driver.get("https://dev200784.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Enter the username and the password
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("k6C8-ajUWqY%");
		// Click on the "Login" button.
		driver.findElement(By.id("sysverb_login")).click();
		// Click on "All."
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//div[text()='All']").click();
		
		// Click on "Service Catalog."
		// Click on "Mobiles."
		// Click on "Apple MacBook Pro 13."
		// Choose all mandatory fields
		// Click on "Order now"
		// Print the order message.
		// Print the request number
		// Take a snap of the resulting page.
		// Close the browser
	}

}
