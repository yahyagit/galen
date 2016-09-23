package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.ContactUsPage;
import com.ekapiww.pageobjects.HomeHeroBannerSection;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Hero_BannerSteps {
	HomeHeroBannerSection homeHeroBannerSection = new HomeHeroBannerSection(AppDriver.getDriver());
	ContactUsPage contactUsPage;

	@When("^I view the Hero Banner section$")
	public void i_view_the_Hero_Banner_section() throws Throwable {
		homeHeroBannerSection.assertHeroBannerSection();
		
	}

	@Then("^I should see sub heading, main heading and description$")
	public void i_should_see_sub_heading_main_heading_and_description() throws Throwable {
		homeHeroBannerSection.assertContentOnBanner();
	}

	@Then("^I should see two CTAs$")
	public void i_should_see_two_CTAs() throws Throwable {
		homeHeroBannerSection.assertCTAsOnBanner();
	}

	@When("^I click on the secondary Contact us CTA$")
	public void i_click_on_the_secondary_Contact_us_CTA() throws Throwable {
		contactUsPage = homeHeroBannerSection.clickOnContactUsCTA();
	}

	@Then("^it should navigates to Contact us page$")
	public void it_should_navigates_to_Contact_us_page() throws Throwable {
		contactUsPage.assertContactUsUrl();
		
	}
}
