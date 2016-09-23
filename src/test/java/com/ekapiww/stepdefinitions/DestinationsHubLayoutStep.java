package com.ekapiww.stepdefinitions;

import java.util.concurrent.TimeUnit;

import com.ekapiww.pageobjects.DestinationsHubPage;
import com.ekapiww.pageobjects.cms.AdminPage;
import com.ekapiww.pageobjects.cms.ConfigCountryLayoutPage;
import com.ekapiww.pageobjects.cms.ConfigCountryPage;
import com.ekapiww.pageobjects.cms.ConfigPage;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DestinationsHubLayoutStep {
	String cmsAdminWindowHandle;
	String userWindowHandle;
	
	
	private AdminPage adminPage = new AdminPage(AppDriver.getDriver());
	private ConfigPage adminConfigPage;
	private ConfigCountryPage configCountryPage;
	private ConfigCountryLayoutPage configCountryLayoutPage;
	

	private DestinationsHubPage destinationHubPage = new DestinationsHubPage(AppDriver.getDriver());;

	@Given("^I click configuration$")
	public void i_click_configuration() throws Throwable {
		adminConfigPage = adminPage.clickConfiguration();
	}

	@Given("^I click Countries$")
	public void i_click_Countries() throws Throwable {
		configCountryPage = adminConfigPage.clickCountries();
	}

	@Given("^I click Layouts$")
	public void i_click_Layouts() throws Throwable {
		configCountryLayoutPage = configCountryPage.clickLayout();

	}
	
	@Given("^I reset the panels to original format$")
	public void i_reset_the_panels_to_original_format() throws Throwable {
		configCountryLayoutPage.resetTileDesign();
		
	}

	@When("^I click Australia$")
	public void i_click_Australia() throws Throwable {
		configCountryLayoutPage.clickAustralia();	
	}

	@When("^I click New Zealand$")
	public void i_click_New_Zealand() throws Throwable {
		configCountryLayoutPage.clickNewZealand();
	}

	@When("^I click swap$")
	public void i_click_swap() throws Throwable {
		configCountryLayoutPage.clickSwap();
	}

	@When("^I check row(\\d+) layout$")
	public void i_check_row_layout(int rowNumber) throws Throwable {
		configCountryLayoutPage.selectDestinationRow(rowNumber);
	}

	@When("^click Save$")
	public void click_Save() throws Throwable {
		configCountryLayoutPage.clickSave();
	}
	@Given("^I click the first selection checkbox$")
	public void i_click_the_first_selection_checkbox() throws Throwable {
	    configCountryLayoutPage.checkSelectionCheckbox();
	}
	@When("^I select the first country name in the first row$")
	public void i_select_the_first_country_name_in_the_first_row() throws Throwable {
		configCountryLayoutPage.selectFirstCountry();
	}
	@When("^I select the second country name in the first row$")
	public void i_select_the_second_country_name_in_the_first_row() throws Throwable {
		configCountryLayoutPage.selectSecondCountry();
	}

	@Given("^I navigate to destinations hub page$")
	public void i_navigate_to_destinations_hub_page() throws Throwable {
		TimeUnit.SECONDS.sleep(3);
		destinationHubPage.newWindowDestinationsHubPage();
		
	}
	
	@Then("^I should see the changes in the layout$")
	public void i_should_see_the_changes_in_the_layout() throws Throwable {
		destinationHubPage.assertCountryShuffle();
	}

	@Then("^I rollback to the original layout$")
	public void i_rollback_to_the_original_layout() throws Throwable {
		destinationHubPage.switchToAdminWindow();
		configCountryLayoutPage.resetTileDesign();
		
		AppDriver.closeDriver();

	}

}
