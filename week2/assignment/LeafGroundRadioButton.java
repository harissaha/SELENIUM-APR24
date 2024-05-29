package week2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundRadioButton {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Select 'Your most favourite browser' from the radio buttons
		driver.findElement(By.xpath("(//label[text()='Chrome']/preceding-sibling::div//span)[1]")).click();
		WebElement selectEle = driver.findElement(By.xpath("(//label[text()='Bengaluru']/preceding-sibling::div//span)[1]"));
		// Click on a radio button, then click on the same radio button again to verify that it becomes ‘unselected’.
		selectEle.click();
		boolean selected = selectEle.isSelected();		
		System.out.println(selected);
		// Identify the radio button that is initially selected by default.
		List<WebElement> findElements = driver.findElements(By.xpath("//h5[text()='Find the default select radio button']/following-sibling::div//span"));
		int size = findElements.size();
		System.out.println(size);
		for (WebElement webElement : findElements) {
			System.out.println(webElement.isSelected());
			
		}
		// Check and select the age group (21-40 Years) if not already selected
	}

}
