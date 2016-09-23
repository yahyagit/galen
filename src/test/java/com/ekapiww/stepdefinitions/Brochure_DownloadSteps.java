package com.ekapiww.stepdefinitions;

import java.util.concurrent.TimeUnit;

import com.ekapiww.pageobjects.BrochureDownloadConfirmationPage;
import com.ekapiww.pageobjects.FreeBrochurePage;
import com.ekapiww.pageobjects.HeaderSection;
import com.ekapiww.utils.AppDriver;
import com.ekapiww.utils.RestAssure;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Brochure_DownloadSteps {
	HeaderSection headerSection = new HeaderSection(AppDriver.getDriver());
	FreeBrochurePage freeBrochurePage;
	BrochureDownloadConfirmationPage brochureDownloadConfirmationPage;
	RestAssure restAssure = new RestAssure();
	
	@Given("^I click on Free brochure$")
	public void i_click_on_Free_brochure() throws Throwable {
		freeBrochurePage=headerSection.clickFreeBrochure();
	}

	@When("^I populate brochure download form$")
	public void i_populate_brochure_download_form() throws Throwable {
		freeBrochurePage.populateBrochureForm();
		freeBrochurePage.checkIfCheckboxIsSelected();
		TimeUnit.SECONDS.sleep(2);
		
	}

	@When("^I click on get my free brochure$")
	public void i_click_on_get_my_free_brochure() throws Throwable {
		brochureDownloadConfirmationPage=freeBrochurePage.clickGetMyFreeBrochure();
	}

	@Then("^I should see brochure download confirmation page$")
	public void i_should_see_brochure_download_confirmation_page() throws Throwable {
		brochureDownloadConfirmationPage.assertBrochureDownloadConfirmationPage();
		
	}
	
	@Then("^I expect a lead to be generated in Salesforce with submitted values for Brochure$")
	public void i_expect_a_lead_to_be_generated_in_Salesforce_with_submitted_values_for_Brochure() throws Throwable {
		restAssure.assertLeadGeneratedBrochure();
		
		AppDriver.closeDriver();
	}

}
