package week2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundButton {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Click on the button with the text ‘Click and Confirm title.’
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		// Verify that the title of the page is ‘dashboard.’
		System.out.println(driver.getTitle());
		driver.navigate().back();
		// Check if the button with the text ‘Confirm if the button is disabled’ is
		// disabled.
		boolean enabled = driver
				.findElement(By.xpath("//h5[text()='Confirm if the button is disabled.']/following-sibling::button"))
				.isEnabled();
		System.out.println(enabled);
		// Find and print the position of the button with the text ‘Submit.’
		WebElement submitButton = driver.findElement(
				By.xpath("(//h5[text()='Find the position of the Submit button']/following-sibling::button/span)[2]"));
		System.out.println(submitButton.getLocation());
		// Find and print the background color of the button with the text ‘Find the
		// Save button color.’
		WebElement saveButton = driver
				.findElement(By.xpath("(//h5[text()='Find the Save button color']/following-sibling::button/span)[2]"));
		String color = saveButton.getCssValue("color");
		System.out.println(color);
		// Find and print the height and width of the button with the text ‘Find the
		// height and width of this button.’
		System.out.println(driver
				.findElement(By.xpath(
						"(//h5[text()='Find the height and width of this button']/following-sibling::button/span)[2]"))
				.getSize());

		// Close the browser window
		driver.close();
	}
}
