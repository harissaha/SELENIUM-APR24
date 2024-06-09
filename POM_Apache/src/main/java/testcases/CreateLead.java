package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class CreateLead extends BaseClass {

	@BeforeTest
	public void setFileName() {

		fileName = "CreateLeadData";

	}

	@Test(dataProvider = "fetchData")
	public void executeCreateLead(String uName, String pWord, String cName, String fName, String lName) {

		new LoginPage(driver).enterUsername(uName).enterPassword(pWord).clickLogin().verifyWelcomePage()
				.clickCRMSFALink().clickLeads().clickCreateLead().enterCompanyName(uName).enterFirstName(fName)
				.enterLastName(lName).clickSubmit().verifyViewLeadPage().confirmLeadCreated(cName);

	}
}
