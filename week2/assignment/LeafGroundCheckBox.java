package week2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundCheckBox {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		// Click on the "Basic Checkbox.”
		driver.findElement(By.xpath("//span[text()='Basic']/preceding-sibling::div[1]")).click();
		// Click on the "Notification Checkbox."
		driver.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div[1]")).click();
		// Verify that the expected message is displayed.
		String text = driver.findElement(By.xpath("//span[text()='Checked']")).getText();
		System.out.println(text);
		// Click on your favorite language (assuming it's related to checkboxes).
		driver.findElement(By.xpath("(//h5[text()='Choose your favorite language(s)']/following-sibling::div//div[2])[1]")).click();
		// Click on the "Tri-State Checkbox."
		driver.findElement(By.xpath("(//h5[text()='Tri State Checkbox']/following-sibling::div//div[2])[1]")).click();
		// Verify which tri-state option has been chosen.
		String text2 = driver.findElement(By.xpath("//span[text()='State has been changed.']/following-sibling::p")).getText();
		System.out.println(text2);
		// Click on the "Toggle Switch."
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		// Verify that the expected message is displayed.
		String text3 = driver.findElement(By.xpath("//span[text()='Checked']")).getText();
		System.out.println(text3);
		// Verify if the Checkbox is disabled.
		boolean enabled = driver.findElement(By.xpath("//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default ui-state-disabled ui-state-disabled']")).isEnabled();
		System.out.println(enabled);
		// Select multiple options on the page (details may be needed).
		driver.findElement(By.xpath("//h5[text()='Select Multiple']/following-sibling::div/ul")).click();
		driver.findElement(By.xpath("(//li[@data-item-value='Miami']//div)[3]")).click();
		driver.findElement(By.xpath("(//li[@data-item-value='Istanbul']//div)[3]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'close ui-corner-all')]")).click();
		// Close the web browser when done.
		driver.close();

		
	}

}
