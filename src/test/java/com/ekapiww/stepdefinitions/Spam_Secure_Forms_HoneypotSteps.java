package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.NewsletterSignupPage;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Spam_Secure_Forms_HoneypotSteps {
	NewsletterSignupPage newsletterSignupPage = new NewsletterSignupPage(AppDriver.getDriver());
	
	@When("^I fill in the honeypot field$")
	public void i_fill_in_the_honeypot_field() throws Throwable {
		newsletterSignupPage.enterDataOnHoneypotField();		
	    
	}

	@Then("^I should form submission failure message$")
	public void i_should_form_submission_failure_message() throws Throwable {
		newsletterSignupPage.assertHoneyhotFailtureMessage();
		
	}

}
