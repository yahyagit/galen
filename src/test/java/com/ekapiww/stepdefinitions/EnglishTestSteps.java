package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.EnglishLevelTestAttemptPage;
import com.ekapiww.pageobjects.EnglishLevelTestSignupPage;
import com.ekapiww.pageobjects.HomeCourseSection;
import com.ekapiww.pageobjects.EnglishCourses.FreeEnglishTestPage;
import com.ekapiww.utils.AppDriver;
import com.ekapiww.utils.RestAssure;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EnglishTestSteps {
	HomeCourseSection homeCourseSection = new HomeCourseSection(AppDriver.getDriver());
	FreeEnglishTestPage freeEnglishTestPage;
	EnglishLevelTestSignupPage englishLevelTestSignupPage;
	EnglishLevelTestAttemptPage englishLevelTestAttemptPage = new EnglishLevelTestAttemptPage(AppDriver.getDriver());
	RestAssure restAssure = new RestAssure();
	
	@When("^I goto English test page$")
	public void i_goto_English_test_page() throws Throwable {
		freeEnglishTestPage = homeCourseSection.clickFPPrimaryCTA();
		freeEnglishTestPage.assertEnglishTestPage();		
	}
	
	@When("^I populated the registration form$")
	public void i_populated_the_registration_form() throws Throwable {
		englishLevelTestSignupPage = freeEnglishTestPage.startTest();
		englishLevelTestSignupPage.fillSignupTestForm();	
	}

	@When("^I register for the test$")
	public void i_register_for_the_test() throws Throwable {
		englishLevelTestAttemptPage = englishLevelTestSignupPage.submitSignupForm();
		
	}

	@When("^I complete the english test$")
	public void i_complete_the_english_test() throws Throwable {
		englishLevelTestAttemptPage.takeTest();
		
	}

	@Then("^I should see the result for test$")
	public void i_should_see_the_result_for_test() throws Throwable {
		englishLevelTestAttemptPage.assertResultPage();
		
		AppDriver.closeDriver();
	}
	
	@Then("^I expect a lead to be generated in Salesforce with submitted values$")
	public void i_expect_a_lead_to_be_generated_in_Salesforce_with_submitted_values() throws Throwable {
	   
		Thread.sleep(60000);
		//asserting lead generated by verifying status code, countryName, firstName, englishLevel and englishScore 
		restAssure.assertLeadGenerated();
		
		
	}
}
