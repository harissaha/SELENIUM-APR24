package week2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("SFA")).click();
		// Click on the "Accounts" tab
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		// Click on the "Create Account" button
		driver.findElement(By.xpath("//a[text()='Create Account']")).click();
		//Enter an account name.
		driver.findElement(By.id("accountName")).sendKeys("tester account");
		//- Enter a description as "Selenium Automation Tester."
		driver.findElement(By.xpath("(//textarea[@class='inputBox'])[1]")).sendKeys("Selenium Automation Tester.");
		//- Select "ComputerSoftware" as the industry.
		WebElement industryEle = driver.findElement(By.xpath("//select[@name='industryEnumId']"));
		Select indDD = new Select(industryEle);
		indDD.selectByIndex(2);
		//- Select "S-Corporation" as ownership using SelectByVisibleText.
		WebElement ownerShipEle = driver.findElement(By.xpath("//select[@name='ownershipEnumId']"));
		Select ownDD = new Select(ownerShipEle);
		ownDD.selectByVisibleText("S-Corporation");
		//- Select "Employee" as the source using SelectByValue.
		WebElement sourceEle = driver.findElement(By.id("dataSourceId"));
		Select sourceDD = new Select(sourceEle);
		sourceDD.selectByValue("LEAD_EMPLOYEE");
		//- Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex.
		WebElement marketCampEle = driver.findElement(By.id("marketingCampaignId"));
		Select marketCampDD = new Select(marketCampEle);
		marketCampDD.selectByIndex(5);
		//- Select "Texas" as the state/province using SelectByValue.
		WebElement stateEle = driver.findElement(By.xpath("//select[@id='generalStateProvinceGeoId']"));
		Select stateDD = new Select(stateEle);
		stateDD.selectByValue("TX");
		//- Click the "Create Account" button.
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();
		//- Verify that the account name is displayed correctly.
		String accountName = driver.findElement(By.xpath("(//span[text()='Account Name']/following::span)[1]")).getText();
		System.out.println(accountName);
		// Close the browser window.
		driver.close();
	}

}
