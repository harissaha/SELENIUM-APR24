package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class RunLogin extends BaseClass {

	@Test
	public void executeLogin() {
		new LoginPage(driver).
		enterUsername().enterPassword().clickLogin().verifyWelcomePage();
	}
}
