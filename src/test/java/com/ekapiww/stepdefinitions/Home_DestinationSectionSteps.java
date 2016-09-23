package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.DestinationOrderingPage;
import com.ekapiww.pageobjects.HomeDestinationSection;
import com.ekapiww.pageobjects.cms.AdminPage;
import com.ekapiww.pageobjects.cms.CmsHomeDestinationSection;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Home_DestinationSectionSteps {
	private AdminPage adminPage = new AdminPage(AppDriver.getDriver());
	private CmsHomeDestinationSection cmsHomeDestinationSection;
	private HomeDestinationSection homeDestinationSection = new HomeDestinationSection(AppDriver.getDriver());
	private DestinationOrderingPage destinationOrdering;
	

	@Given("^goto destination ordering page$")
	public void goto_destination_ordering_page() throws Throwable {
		cmsHomeDestinationSection = adminPage.navigateToDestinationSection();
		destinationOrdering = cmsHomeDestinationSection.navigateToOrdering();
	}

	@Given("^I select (\\d+) panel templates structure$")
	public void i_select_panel_templates_structure(String items) throws Throwable {
		destinationOrdering.setPanelStructure(items);
		destinationOrdering.save();		
		cmsHomeDestinationSection = destinationOrdering.clickOnHome();
	}

	@Then("^I should see (\\d+) panel structure on homepage view countries$")
	public void i_should_see_panel_structure_on_homepage_view_countries(int items) throws Throwable {	
		cmsHomeDestinationSection.assertPanelStructure(items);
	}

	@Then("^I should see (\\d+) countires in list on homepage view all cities$")
	public void i_should_see_countires_in_list_on_homepage_view_all_cities(int items) throws Throwable {
		cmsHomeDestinationSection.clickViewAllCities();
		cmsHomeDestinationSection.assertPanelStructure(items);
	}

	
	@When("^I change the order of the countries$")
	public void i_change_the_order_of_the_countries() throws Throwable {
		destinationOrdering.changeCountriesOrder();
		destinationOrdering.save();		
		cmsHomeDestinationSection = destinationOrdering.clickOnHome();
	}
	
	@Then("^I should see the same order on homepage view countries$")
	public void i_should_see_the_same_order_on_homepage_view_countries() throws Throwable {
		cmsHomeDestinationSection.assertDestinationOrdering();
	}

	@Then("^I should see the same order on homepage view all cities$")
	public void i_should_see_the_same_order_on_homepage_view_all_cities() throws Throwable {
		cmsHomeDestinationSection.clickViewAllCities();
		
		cmsHomeDestinationSection.assertDestinationOrdering();

		destinationOrdering = cmsHomeDestinationSection.navigateToOrdering();
		
		destinationOrdering.resetCountriesOrder();	
		destinationOrdering.save();		
	}
	
	@When("^I view the Destination Intro Section$")
	public void i_view_the_Destination_Intro_Section() throws Throwable {
		homeDestinationSection.assertDestinationSectionIntroPresent();
		
	}

	@Then("^I should see headline and description text with two CTAs$")
	public void i_should_see_headline_and_description_text_with_two_CTAs() throws Throwable {
		homeDestinationSection.assertDestinationSectionIntroConetent();
	}
}
