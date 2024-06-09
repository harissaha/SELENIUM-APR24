package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public LoginPage enterUsername(String userName) {
		driver.findElement(By.id("username")).sendKeys(userName);
		// return new LoginPage();
		return this; // returning the current class's object
	}

	public LoginPage enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		// return new LoginPage();
		return this;
	}

	public WelcomePage clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new WelcomePage(driver);
	}
}
