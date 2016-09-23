package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.cms.LoginPage;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Given;

public class BaseStepDefinition {
	private LoginPage loginPage = new LoginPage(AppDriver.getDriver());

	@Given("^I am logged in to cmsadmin as admin$")
	public void i_am_logged_in_to_cmsadmin_as_admin() throws Throwable {
		AppDriver.launchBackendUrl("user/");
		loginPage.loginAsAdmin();
	}
	
	@Given("^I am logged in to cmsadmin as content publisher$")
	public void i_am_logged_in_to_cmsadmin_as_content_publisher() throws Throwable {
		AppDriver.launchBackendUrl("user/");
		loginPage.loginAsContentPublisher();
	}
	
	@Given("^I am on Homepage$")
	public void i_am_on_Homepage() throws Throwable {
	    AppDriver.launchUrl("");
	}
}
