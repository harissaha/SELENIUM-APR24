package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {
	public static void main(String[] args) {
		// Driver declaration
		ChromeDriver driver = new ChromeDriver();
		// maximize the browser
		driver.manage().window().maximize();
		// launch url
		driver.get("http://leaftaps.com/opentaps/control/main");
		// enter username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		// enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// click submit
		driver.findElement(By.className("decorativeSubmit")).click();
		// click crm/sfa link to get into home page
		driver.findElement(By.partialLinkText("SFA")).click();
		// click leads button
		driver.findElement(By.linkText("Leads")).click();
		// click create lead button
		driver.findElement(By.linkText("Create Lead")).click();
		// select source drop down
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("tcs");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("abc");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("def");
		WebElement sourceEle = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sourceDD = new Select(sourceEle);
		sourceDD.selectByIndex(1);
		// select market campaign drop down
		WebElement marketCampEle = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select marketCampDD = new Select(marketCampEle);
		marketCampDD.selectByValue("CATRQ_CARNDRIVER");
		// select industry drop down
		WebElement industryEle = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select industryDD = new Select(industryEle);
		industryDD.selectByVisibleText("General Services");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("UPDATE");
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		System.out.println(driver.getTitle());
		driver.close();
	}

}
