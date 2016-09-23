package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.FreeBrochurePage;
import com.ekapiww.pageobjects.HomeThreeSecondaryBannerSection;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Three_Secondary_BannerSectionSteps {
	HomeThreeSecondaryBannerSection homeThreeSecondaryBannerSection = new HomeThreeSecondaryBannerSection(AppDriver.getDriver());
	FreeBrochurePage freeBrochurePage;
	
	@When("^I view three secondary banner section$")
	public void i_view_three_secondary_banner_section() throws Throwable {
		homeThreeSecondaryBannerSection.assertThreeBannerSection();
	}

	@Then("^I verfify main heading, sub heading, description, ribbon and CTA on first panel$")
	public void i_verfify_main_heading_sub_heading_description_ribbon_and_CTA_on_first_panel() throws Throwable {
		homeThreeSecondaryBannerSection.assertFirstPanel();
	}

	@Then("^I verify main heading, description and CTA on second panel for Brochure banner$")
	public void i_verify_main_heading_description_and_CTA_on_second_panel_for_Brochure_banner() throws Throwable {
		homeThreeSecondaryBannerSection.assertBrochureBanner();
	}

	@Then("^I click on the find out more CTA for second panel$")
	public void i_click_on_the_find_out_more_CTA_for_second_panel() throws Throwable {
		freeBrochurePage = homeThreeSecondaryBannerSection.clickOnFindOutMoreForBrochure();
	}

	@Then("^I should navigate to brochure page$")
	public void i_should_navigate_to_brochure_page() throws Throwable {
		freeBrochurePage.assertFreeBrochureUrl();
		
	}

	@Then("^I verify main heading, sub heading, description, ribbon and CTA on third panel$")
	public void i_verify_main_heading_sub_heading_description_ribbon_and_CTA_on_third_panel() throws Throwable {
		homeThreeSecondaryBannerSection.assertThirdPanel();
	}

}
