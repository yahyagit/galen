package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.FooterSection;
import com.ekapiww.pageobjects.NewsletterSignupPage;
import com.ekapiww.pageobjects.NewsletterSignupConfirmationPage;
import com.ekapiww.utils.AppDriver;
import com.ekapiww.utils.RestAssure;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewsletterSignUpSteps {
	FooterSection footerSection = new FooterSection(AppDriver.getDriver());
	NewsletterSignupPage newsletterSignUpPage = new NewsletterSignupPage(AppDriver.getDriver());
	NewsletterSignupConfirmationPage NewsletterConfirmationPage;
	RestAssure restAssure =new RestAssure();
	

	@When("^I enter email id on newsletter section$")
	public void i_enter_email_id_on_newsletter_section() throws Throwable {
		footerSection.enterEmail();
	}

	@When("^I click Sign up$")
	public void i_click_Sign_up() throws Throwable {
		newsletterSignUpPage=footerSection.clickSignUp();
	}

	@Then("^I should navigate to Newsletter page$")
	public void i_should_navigate_to_Newsletter_page() throws Throwable {
		newsletterSignUpPage.assertNewsletterSignupPage();
	}

	@When("^I populate newsletter form$")
	public void i_populate_newsletter_form() throws Throwable {
		newsletterSignUpPage
				.enterFirstName()
				.enterLastName()
				.selectCountry();
				
	}
	
	@When("^I verfity pre-populated email id with the one used to sign up$")
	public void i_verfity_pre_populated_email_id_with_the_one_used_to_sign_up() throws Throwable {
		newsletterSignUpPage.verifyEmail();
	}

	@When("^I click keep me updated$")
	public void i_click_keep_me_updated() throws Throwable {
		NewsletterConfirmationPage=newsletterSignUpPage.clickKeepMeUpdate();
	}

	@Then("^I should see a newsletter confirmation page$")
	public void i_should_see_a_newsletter_confirmation_page() throws Throwable {
		NewsletterConfirmationPage.assertNewsletterSignupConfirmationPage();
		
	}
	
	@Then("^I expect a lead to be generated in Salesforce with submitted values for Newsletter$")
	public void i_expect_a_lead_to_be_generated_in_Salesforce_with_submitted_values_for_Newsletter() throws Throwable {
		restAssure.assertLeadGeneratedNewsletter();
		
		AppDriver.closeDriver();
	}
	
		
}
