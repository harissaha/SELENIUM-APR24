package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.ReadExcel;

public class BaseClass {

	public ChromeDriver driver;
	public String fileName;
	
	@Parameters({"url"})
	@BeforeMethod
	public void preCondition(String url) {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		driver.get(url);
	}

	@AfterMethod
	public void postCondition() {		
		driver.close();
	}
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		return ReadExcel.excelRead(fileName);

	}
}
