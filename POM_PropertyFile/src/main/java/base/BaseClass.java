package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	public ChromeDriver driver;
	public static Properties prop;
	
	@Parameters({"url","language"})
	@BeforeMethod
	public void preCondition(String url, String lang) throws IOException {
		FileInputStream fis = new FileInputStream("src\\main\\resources\\config."+lang+".properties");
		prop = new Properties();
		prop.load(fis);
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
	
}
