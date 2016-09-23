package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.AgentLocatorFormPage;
import com.ekapiww.pageobjects.AgentLocatorResultPage;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Portuguese_Agent_LocatorReskinSteps {
	AgentLocatorFormPage agentLocatorFormPage = new AgentLocatorFormPage(AppDriver.getDriver());
	AgentLocatorResultPage agentLocatorResultPage;
 	

	@Given("^I populate Agent locator form$")
	public void i_populate_Agent_locator_form() throws Throwable {
		agentLocatorFormPage
				.selectThirdOptionForFirstQuestion()
				.selectOptionForSecondQuestion()
				.selectDateForThirdQuestion();
		agentLocatorFormPage
				.selectOptionForForthQuestion()
				.selectYesOptionForFifthQuestion();
		agentLocatorResultPage = agentLocatorFormPage.clickOnEnviarForAgentLocator();
	}
	
	@Given("^I navigate to Agent Locator result page$")
	public void i_navigate_to_Agent_Locator_result_page() throws Throwable {
		agentLocatorResultPage.assertAgentLocatorPage();
	
	}
	
	@When("^I enter city \"([^\"]*)\" in the first field$")
	public void i_enter_city_in_the_first_field(String city) throws Throwable {
		agentLocatorResultPage.selectCity(city);
	}
	
	@When("^I enter school \"([^\"]*)\" in the second field$")
	public void i_enter_school_in_the_second_field(String school) throws Throwable {
		agentLocatorResultPage.selectSchool(school);
	}
	
	@When("^I click search$")
	public void i_click_search() throws Throwable {
		agentLocatorResultPage.clickSearch();
		
	}
		
	@Then("^I expect to see search result one \"([^\"]*)\" and/or result two \"([^\"]*)\"$")
	public void i_expect_to_see_search_result_one_and_or_result_two(String msg1, String msg2) throws Throwable {
		agentLocatorResultPage.assertResultForBR(msg1,msg2);
	}
}
