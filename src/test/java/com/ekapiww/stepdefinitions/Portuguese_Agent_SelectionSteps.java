package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.AgentConfirmationPage;
import com.ekapiww.pageobjects.AgentLocatorResultPage;
import com.ekapiww.pageobjects.AgentSelectionFormPage;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Portuguese_Agent_SelectionSteps {
	AgentLocatorResultPage agentLocatorResultPage =new AgentLocatorResultPage(AppDriver.getDriver());
	AgentSelectionFormPage agentSelectionFormPage = new AgentSelectionFormPage(AppDriver.getDriver());
	AgentConfirmationPage agentConfirmationPage;
	
	
	@Given("^I select a Portuguese agent$")
	public void i_select_a_Portuguese_agent() throws Throwable {
		agentSelectionFormPage=agentLocatorResultPage.selectAgent("CI - Central De Intercâmbio");
	}

	@When("^I enter details on the form$")
	public void i_enter_details_on_the_form() throws Throwable {
		agentSelectionFormPage.populateAgentFormForPortuguese();
		agentSelectionFormPage.checkingChkBoxIsSelected("tfa_73");
		
	}

	@When("^I click Submit$")
	public void i_click_Submit() throws Throwable {
		agentConfirmationPage=agentSelectionFormPage.clickSubmit();
	}

	@Then("^I expect to see confirmation page$")
	public void i_expect_to_see_confirmation_page() throws Throwable {
		agentConfirmationPage.assertConfirmationPage();
		agentConfirmationPage.assertSpanishPage();
		
	}

}
