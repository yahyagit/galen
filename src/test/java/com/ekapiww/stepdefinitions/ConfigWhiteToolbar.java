package com.ekapiww.stepdefinitions;

import java.util.concurrent.TimeUnit;

import com.ekapiww.pageobjects.cms.AdminPage;
import com.ekapiww.pageobjects.cms.ConfigPage;
import com.ekapiww.pageobjects.cms.KisSettingsPage;
import com.ekapiww.pageobjects.cms.LoginPage;
import com.ekapiww.utils.AppDriver;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class ConfigWhiteToolbar {
	private LoginPage loginPage = new LoginPage(AppDriver.getDriver());

	private AdminPage adminPage =new AdminPage(AppDriver.getDriver()); 
	private ConfigPage configPage;
	private KisSettingsPage kisSettingsPage;
	
//	@Before("@WtoolBar")
	@Given("^I turn on all the White tool bar CTAs per market on cmsadmin$")
	public void i_turn_on_all_the_White_tool_bar_CTAs_per_market_on_cmsadmin() throws Throwable {
	
		AppDriver.launchBackendUrl("/user/");
		adminPage=loginPage.loginAsAdmin();
		
		configPage = adminPage.clickConfiguration();
		kisSettingsPage=configPage.clickKisSettings();
		kisSettingsPage.configureWhiteToolBarForTest();
		TimeUnit.SECONDS.sleep(3);
		AppDriver.closeDriver();

	}
	
}
