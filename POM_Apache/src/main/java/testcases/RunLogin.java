package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class RunLogin extends BaseClass {

	@BeforeTest
	public void setFileName() {

		fileName = "LoginData";

	}

	@Test(dataProvider = "fetchData")
	public void executeLogin(String uName, String pWord) {
		new LoginPage(driver).enterUsername(uName).enterPassword(pWord).clickLogin().verifyWelcomePage();
	}
}
