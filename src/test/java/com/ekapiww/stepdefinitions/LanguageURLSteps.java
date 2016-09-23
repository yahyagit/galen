package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.CountryHubPage;
import com.ekapiww.pageobjects.HeaderSection;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LanguageURLSteps {
	HeaderSection headerSection = new HeaderSection(AppDriver.getDriver());
	CountryHubPage countryHubPage;
	
	
	@When("^I navigate to country hub page$")
	public void i_navigate_to_country_hub_page() throws Throwable {
		countryHubPage =headerSection.clickCountryLogo();
		
	}

	@When("^I click on \"([^\"]*)\"$")
	public void i_click_on(String country) throws Throwable {
		countryHubPage.clickOnCountry(country);
		
	}

	@Then("^I should navigate to the \"([^\"]*)\"$")
	public void i_should_navigate_to_the(String URL) throws Throwable {
		countryHubPage.assertCountryURL(URL);
	}

}
