package week5.assignments;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class W3SchoolTest {

	public static ChromeDriver driver;
	public static String fileName = "datasheet";
	public static String sheetName = "Sheet1";

	@Test(dataProvider = "fetchData")
	public void register(String fullName, String eMail, String address, String city, String state, String zip,
			String cvv, String ccNum, String nameOnCard) {
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_checkout_form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.id("fname")).sendKeys(fullName);
		driver.findElement(By.id("email")).sendKeys(eMail);
		driver.findElement(By.id("adr")).sendKeys(address);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("state")).sendKeys(state);
		driver.findElement(By.id("zip")).sendKeys(zip);
		driver.findElement(By.id("cname")).sendKeys(nameOnCard);
		driver.findElement(By.id("ccnum")).sendKeys(ccNum);
		driver.findElement(By.id("expmonth")).sendKeys("October");
		driver.findElement(By.id("expyear")).sendKeys("2018");
		driver.findElement(By.id("cvv")).sendKeys(cvv);
	}

	@DataProvider(name = "fetchData")
	public String[][] dataCall() throws IOException {
		return ReadExcel.readExcel(fileName, sheetName);

	}

}
