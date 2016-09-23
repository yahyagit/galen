package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.FreeBrochurePage;
import com.ekapiww.pageobjects.HomeWhyStudyWithKaplanSection;
import com.ekapiww.pageobjects.AboutKaplan.AboutKaplanPage;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Home_WhyStudyWithKaplanSteps {
	
	HomeWhyStudyWithKaplanSection homeWhyStudyWithKaplanSection = new HomeWhyStudyWithKaplanSection(AppDriver.getDriver());
	AboutKaplanPage aboutKaplanPage;
	FreeBrochurePage freeBrochurePage;
	
	@When("^I view on why study with Kaplan section$")
	public void i_view_on_why_study_with_Kaplan_section() throws Throwable {
		homeWhyStudyWithKaplanSection.assertWhyKaplanSection();
	}

	@Then("^I see head line and description text$")
	public void i_see_head_line_and_description_text() throws Throwable {
		homeWhyStudyWithKaplanSection.assertIntro();
	}

	@Then("^I see four icons with text and description$")
	public void i_see_four_icons_with_text_and_description() throws Throwable {
		homeWhyStudyWithKaplanSection.assertIcons();
		
	}

	@Then("^I see two CTAs as per design$")
	public void i_see_two_CTAs_as_per_design() throws Throwable {
		homeWhyStudyWithKaplanSection.assertCTAs();
	}

	@When("^I click on the primary learn more about us CTA$")
	public void i_click_on_the_primary_learn_more_about_us_CTA() throws Throwable {
		aboutKaplanPage = homeWhyStudyWithKaplanSection.clickOnLearnMoreAboutUs();
	}

	@Then("^I am taken to the about us page$")
	public void i_am_taken_to_the_about_us_page() throws Throwable {
		aboutKaplanPage.assertAboutKaplanPage();
	}

	@When("^I click on the secondary download brochure CTA$")
	public void i_click_on_the_secondary_download_brochure_CTA() throws Throwable{
		freeBrochurePage = homeWhyStudyWithKaplanSection.clickOnDownloadBrochure();
	}

	@Then("^I am taken to the download the brochure page$")
	public void i_am_taken_to_the_download_the_brochure_page() throws Throwable {
		freeBrochurePage.assertFreeBrochureUrl();
	}

}
