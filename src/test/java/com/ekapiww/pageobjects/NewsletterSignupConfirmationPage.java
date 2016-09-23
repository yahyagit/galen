package com.ekapiww.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class NewsletterSignupConfirmationPage {

	private WebDriver driver;

	public NewsletterSignupConfirmationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void assertNewsletterSignupConfirmationPage(){
		Assert.assertTrue(driver.getCurrentUrl() + " Failed Newsletter Sign Up confirmation page.", driver.getCurrentUrl().contains("newsletter-signup/thank-you"));
	}

}
