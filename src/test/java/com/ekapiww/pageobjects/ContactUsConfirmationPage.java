package com.ekapiww.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ContactUsConfirmationPage {

	private WebDriver driver;

	public ContactUsConfirmationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void assertContactUsConfirmationPage(){
		Assert.assertTrue(driver.getCurrentUrl() + " Failed contact us  confirmation page", driver.getPageSource().contains("page-node-888"));
		
	}

}
