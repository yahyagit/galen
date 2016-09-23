package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.AgentLocatorResultPage;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Spanish_Agent_locatorReskinSteps {
	AgentLocatorResultPage agentLocatorResultPage =new AgentLocatorResultPage(AppDriver.getDriver());

	
	@Given("^I am on Agent Locator page$")
	public void i_am_on_Agent_Locator_page() throws Throwable {
		AppDriver.launchUrl_secondary("/locator/index");
		
	}
	
	@When("^I enter city \"([^\"]*)\" in the city field$")
	public void i_enter_city_in_the_city_field(String city) throws Throwable {
		agentLocatorResultPage.selectCity(city);
	}

	@When("^I enter school \"([^\"]*)\" in the school field$")
	public void i_enter_school_in_the_school_field(String school) throws Throwable {
		agentLocatorResultPage.selectSchool(school);
	}

	@When("^I click search for agent$")
	public void i_click_search_for_agent() throws Throwable {
		agentLocatorResultPage.clickSearch();
	}

	@Then("^I expect to verify search result one \"([^\"]*)\" and/or result two \"([^\"]*)\"$")
	public void i_expect_to_verify_search_result_one_and_or_result_two(String msg1, String msg2) throws Throwable {
		agentLocatorResultPage.assertResultForSPA(msg1,msg2);
	}
}
