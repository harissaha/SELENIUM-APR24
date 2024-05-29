package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnBasicXpath {
	
	public static void main(String[] args) {
		// Driver declaration
		ChromeDriver driver = new ChromeDriver();
		// maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// launch url
		driver.get("http://leaftaps.com/opentaps/control/main");
		// enter username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		// enter password
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		// click submit
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		// click crm/sfa link to get into home page
		driver.findElement(By.xpath("//a[contains(text(),'SFA')]")).click();
		// click leads button
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		// click create lead button
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		// select source drop down
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("tcs");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("hari");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("s");
		WebElement sourceEle = driver.findElement(By.xpath("(//select[@class='inputBox'])[1]"));
		Select sourceDD = new Select(sourceEle);
		sourceDD.selectByIndex(1);
		// select market campaign drop down
		WebElement marketCampEle = driver.findElement(By.xpath("//select[@name='marketingCampaignId']"));
		Select marketCampDD = new Select(marketCampEle);
		marketCampDD.selectByValue("CATRQ_CARNDRIVER");
		// select industry drop down
		WebElement industryEle = driver.findElement(By.xpath("//select[@id='createLeadForm_industryEnumId']"));
		Select industryDD = new Select(industryEle);
		industryDD.selectByVisibleText("General Services");
		// click submit button
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		System.out.println(driver.getTitle());
	}

}
