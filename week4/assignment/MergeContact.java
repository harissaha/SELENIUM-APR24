package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {
	
public static void main(String[] args) {
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.partialLinkText("SFA")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.linkText("Merge Contacts")).click();
	driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a/img")).click();
	//div[@style='overflow: visible;']/div//table[1]//div[consists(@class,'col-partyId')]
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> windows = new ArrayList<String>(windowHandles);
	for (String each : windows) {
		driver.switchTo().window(each);
	}
	driver.findElement(By.xpath("(//div[contains(@class,'col-partyId')]/a)[1]")).click();
	driver.switchTo().window(windows.get(0));
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a/img")).click();
	Set<String> windowHandles1 = driver.getWindowHandles();
	List<String> windows1 = new ArrayList<String>(windowHandles1);
	for (String each : windows1) {
		driver.switchTo().window(each);
	}
	driver.findElement(By.xpath("(//div[contains(@class,'col-partyId')]/a)[2]")).click();
	driver.switchTo().window(windows.get(0));
	System.out.println(driver.getTitle());
	driver.findElement(By.linkText("Merge")).click();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	if((driver.getTitle().equalsIgnoreCase("Merge Contacts | opentaps CRM"))){
		System.out.println("Testcase is passed");
	} else {
		System.out.println("Testcase is failed");
	}
}

}
