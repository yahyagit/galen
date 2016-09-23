package com.ekapiww.stepdefinitions;

import java.util.concurrent.TimeUnit;

import com.ekapiww.pageobjects.ContactUsConfirmationPage;
import com.ekapiww.pageobjects.ContactUsPage;
import com.ekapiww.pageobjects.HeaderSection;
import com.ekapiww.utils.AppDriver;
import com.ekapiww.utils.RestAssure;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactUsSteps {
	HeaderSection headerSection = new HeaderSection(AppDriver.getDriver());
	ContactUsPage contactUsPage;
	ContactUsConfirmationPage contactUsConfirmationPage;
	RestAssure restAssure = new RestAssure();
	
	@When("^I click on contact us$")
	public void i_click_on_contact_us() throws Throwable {
		contactUsPage=headerSection.clickContactUs();
	
	}

	@When("^I populate the contact us form$")
	public void i_populate_the_contact_us_form() throws Throwable {
		contactUsPage.populateContactUsForm();
		contactUsPage.checkIfCheckboxIsSelected();
		contactUsConfirmationPage = contactUsPage.clickOnContactAStudentAdvisor();
		TimeUnit.SECONDS.sleep(3);
		
	}

	@Then("^I should see a contact us form submission confirmation page$")
	public void i_should_see_a_contact_us_form_submission_confirmation_page() throws Throwable {
		contactUsConfirmationPage.assertContactUsConfirmationPage();
						
	}
	
	@Then("^I expect a lead to be generated in Salesforce with submitted values for Contact Us$")
	public void i_expect_a_lead_to_be_generated_in_Salesforce_with_submitted_values_for_Contact_Us() throws Throwable {
		restAssure.assertLeadGeneratedContactUS();
		
		AppDriver.closeDriver();
	}

}
