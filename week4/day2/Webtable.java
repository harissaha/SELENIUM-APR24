package week4.day2;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(5000);
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("Kanniyakumari", Keys.ENTER);
		Thread.sleep(5000);
		WebElement destination = driver.findElement(By.id("txtStationTo"));
		destination.clear();
		destination.sendKeys("Chennai", Keys.ENTER);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> trainNames = driver.findElements(
				By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']/tbody/tr/td[2]"));
		for (WebElement eachTrainName : trainNames) {
			System.out.println(eachTrainName.getText());
		}
		Set<WebElement> trainNameSet = new HashSet<WebElement>();

		if (trainNameSet.size() == trainNames.size()) {
			System.out.println("No duplicate in the train names");
		} else {
			System.out.println("duplicate in the train names");
		}

	}

}
