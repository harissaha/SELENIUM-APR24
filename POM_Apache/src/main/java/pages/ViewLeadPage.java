package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class ViewLeadPage extends BaseClass {

	public ViewLeadPage(ChromeDriver driver) {
		this.driver=driver;
	}

	public ViewLeadPage verifyViewLeadPage() {
		String title = driver.getTitle();
		if (title.contains("View Lead")) {
			System.out.println("View Lead page is displayed");
		} else {
			System.out.println("View Lead page is not displayed");
		}
		return this;
	}

	public ViewLeadPage confirmLeadCreated(String cName) {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains(cName)) {
			System.out.println("Lead created successfully");
		} else {
			System.out.println("Lead is not created");
		}
		return this;
	}

}
