package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.AgentLocatorFormPage;
import com.ekapiww.pageobjects.AgentLocatorResultPage;
import com.ekapiww.pageobjects.ContactUsPage;
import com.ekapiww.pageobjects.HomeHeroBannerSection;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Portuguese_Agent_LocatorSteps {
	//HeaderSection headerSection = new HeaderSection(AppDriver.getDriver());
	HomeHeroBannerSection homeHeroBannerSection = new HomeHeroBannerSection(AppDriver.getDriver());
	AgentLocatorFormPage agentLocatorFormPage;
	AgentLocatorResultPage locatorPage;
	ContactUsPage contactUsPage;
	

	@Given("^I click on Contact us for Agent locator$")
	public void i_click_on_Contact_us_for_Agent_locator() throws Throwable {
		//agentLocatorFormPage = headerSection.clickContactUsForPortugeseAgentLocator();
		agentLocatorFormPage = homeHeroBannerSection.clickOnContactUsCTAForAgentLocator();
	}
	
	@Then("^I navigate to Agent locator form$")
	public void i_navigate_to_Agent_locator_form() throws Throwable {
		agentLocatorFormPage.assertAgentLocatorFormPage();
	}
	
	@When("^I enter current place for question two$")
	public void i_enter_current_place_for_question_two() throws Throwable {
		agentLocatorFormPage.selectOptionForSecondQuestion();
	}

	@When("^I select date to start course for question three$")
	public void i_select_date_to_start_course_for_question_three() throws Throwable {
		agentLocatorFormPage.selectDateForThirdQuestion();
	}

	@When("^I select the country for question four$")
	public void i_select_the_country_for_question_four() throws Throwable {
		agentLocatorFormPage.selectOptionForForthQuestion();
	}

	
	@When("^I click search to take me to Agent Locator Result page$")
	public void i_click_search_to_take_me_to_Agent_Locator_Result_page() throws Throwable {
		locatorPage= agentLocatorFormPage.clickOnEnviarForAgentLocator();
	}
	
	@Then("^I expect to be redirected to the Agent Locator Result page$")
	public void i_expect_to_be_redirected_to_the_Agent_Locator_Result_page() throws Throwable {
			locatorPage.assertAgentLocatorPage();
	}
			
	@When("^I click search to take me to Contact us$")
	public void i_click_search_to_take_me_to_Contact_us() throws Throwable {
		contactUsPage = agentLocatorFormPage.clickOnEnviarForContactUs();
	}

	
	@Then("^I expect to be redirected to the Drupal Portuguese Contact Us form$")
	public void i_expect_to_be_redirected_to_the_Drupal_Portuguese_Contact_Us_form() throws Throwable {
		contactUsPage.assertContactUsPageForPortuguese();
	}
	
	
	@When("^I select option (\\d+) for question one$")
	public void i_select_option_for_question_one(int index) throws Throwable {
		agentLocatorFormPage.selectOptionforFirstQuestion(index);
	}
	
	@When("^I select option (\\d+) for question five$")
	public void i_select_option_for_question_five(int index) throws Throwable {
		agentLocatorFormPage.selectOptionforFifthQuestion(index);
	}

}
