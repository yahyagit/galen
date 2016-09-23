package com.ekapiww.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BrochureDownloadConfirmationPage {

	private WebDriver driver;

	public BrochureDownloadConfirmationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void assertBrochureDownloadConfirmationPage(){
		Assert.assertTrue("Error brochure download confirmation page", driver.getPageSource().contains("page-node-942"));
	}

}
