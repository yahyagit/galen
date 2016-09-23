package com.ekapiww.stepdefinitions;


import com.ekapiww.pageobjects.ContactUsPage;
import com.ekapiww.pageobjects.CountryHubPage;
import com.ekapiww.pageobjects.FreeBrochurePage;
import com.ekapiww.pageobjects.GetQuotePage;
import com.ekapiww.pageobjects.HeaderSection;
import com.ekapiww.pageobjects.SearchByKeywordPage;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WhiteToolBarSteps {
	
	private HeaderSection headerSection =  new HeaderSection(AppDriver.getDriver());
	private ContactUsPage contactUsPage;	
	private FreeBrochurePage freeBrochurePage;
	private SearchByKeywordPage searchByKeywordPage; 
	private CountryHubPage countryHubPage;
	private GetQuotePage getQuotePage; 
	
	@When("^I view the top of the page$")
	public void i_view_the_top_of_the_page() throws Throwable {
		headerSection.assertWhiteToolBarIsPresent();

	}
	
	@Then("^I expect to see six toolBar CTAs on the top bar with relevent urls$")
	public void i_expect_to_see_six_toolBar_CTAs_on_the_top_bar_with_relevent_urls() throws Throwable {
		
		freeBrochurePage = headerSection.clickFreeBrochure();
		freeBrochurePage.assertFreeBrochureUrl();

		contactUsPage = headerSection.clickContactUs();
		contactUsPage.assertContactUsUrl();
		
		headerSection.assertPhoneCTAIsPresent();
		
		searchByKeywordPage = headerSection.clickSearch();
		searchByKeywordPage.assertSearchIsPresent();
		
		countryHubPage = headerSection.clickCountryLogo();
		countryHubPage.assertCountryLanguageUrlIsPresent();

		getQuotePage = headerSection.clickGetAQuote();
		getQuotePage.assertGetQuoteUrl();
				
	}
	

}
