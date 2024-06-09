package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class CreateLead extends BaseClass {

	@Test
	public void executeCreateLead() {

		new LoginPage(driver).enterUsername().enterPassword().clickLogin().verifyWelcomePage().clickCRMSFALink().clickLeads()
				.clickCreateLead().enterCompanyName().enterFirstName().enterLastName().clickSubmit()
				.verifyViewLeadPage().confirmLeadCreated();

	}
}
