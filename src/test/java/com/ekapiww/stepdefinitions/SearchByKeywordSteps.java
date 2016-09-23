package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.HeaderSection;
import com.ekapiww.pageobjects.SearchByKeywordPage;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchByKeywordSteps {
	SearchByKeywordPage search;
	HeaderSection header=new HeaderSection(AppDriver.getDriver());

	@When("^I view search panel$")
	public void i_view_search_panel() throws Throwable {
		search= header.clickSearch();
		search.assertSearchIsPresent();
	}

	@And("^I search for \"([^\"]*)\"$")
	public void i_search_for(String keyword) throws Throwable {
		search.enterKeyword(keyword);	
	}

	@Then("^I should get relevant search results$")
	public void i_should_get_relevant_search_results() throws Throwable {
		search.verifyResult();
	}

	@And("^I search for invalid \"([^\"]*)\"$")
	public void i_search_for_invalid(String keyword) throws Throwable {
		search.enterInvalidKeyword(keyword);
	}

	@Then("^I should go to no result page$")
	public void i_should_go_to_no_result_page_saying_no_result_found() throws Throwable {
		search.noResultsPage();
	}
}