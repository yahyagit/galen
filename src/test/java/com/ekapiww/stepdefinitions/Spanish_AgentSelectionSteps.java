package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.AgentLocatorResultPage;
import com.ekapiww.pageobjects.AgentSelectionFormPage;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Spanish_AgentSelectionSteps {
	AgentLocatorResultPage agentLocatorResultPage =new AgentLocatorResultPage(AppDriver.getDriver());
	AgentSelectionFormPage agentSelectionFormPage;
	
	@Given("^I enter city$")
	public void i_enter_city() throws Throwable {
		agentLocatorResultPage.selectCity("Barcelona");
	}

	@Given("^I enter school$")
	public void i_enter_school() throws Throwable {
		agentLocatorResultPage.selectSchool("Estados Unidos");
	}

	@Given("^I select a Spanish agent$")
	public void i_select_a_Spanish_agent() throws Throwable {
		agentSelectionFormPage =agentLocatorResultPage.selectAgent("CIE");
		
	}
	
	@When("^I populate the form for Spanish agent$")
	public void i_populate_the_form_for_Spanish_agent() throws Throwable {
		agentSelectionFormPage.populateAgentFormForSpanish().checkingChkBoxIsSelected("tfa_72");
	}


}
