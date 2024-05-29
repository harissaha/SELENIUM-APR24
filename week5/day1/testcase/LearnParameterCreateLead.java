package week5.day1.testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LearnParameterCreateLead extends BaseClass {
	@Test(dataProvider="fetchdata")
	public void runCreateLead(String fName, String lName, String companyName) {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
		driver.close();
	}
	
	@DataProvider(name="fetchdata")
	public String[][] data() {
		String[][] dp = new String[2][3];
		dp[0][0] = "Hari";
		dp[0][1] = "R";
		dp[0][2] = "TCS";
		
		dp[1][0] = "Ravi";
		dp[1][1] = "R";
		dp[1][2] = "HCL";
		return dp;
	}
}
