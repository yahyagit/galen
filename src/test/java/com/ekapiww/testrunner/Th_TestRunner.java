package com.ekapiww.testrunner;

import org.junit.runner.RunWith;

import com.ekapiww.utils.AppDriver;
import com.ekapiww.utils.AppVariables;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumberRunner.class)
@CucumberOptions(
		features = "classpath:com/ekapiww/features/",
		plugin = {"pretty", "html:target/cucumber-reports/html", "json:target/cucumber.json", "rerun:target/rerun.txt"},
		glue = "com.ekapiww.stepdefinitions",
		tags = {}
		)
public class Th_TestRunner {
	@BeforeTestSuite
	public static void setup() {
		System.setProperty(AppVariables.APP_MARKET_KEY, AppVariables.APP_MARKET_THAI);
	}
	
	@AfterTestSuite
	public static void exitSuite() {
		if(AppVariables.APP_DRIVER != null) {
			AppVariables.APP_DRIVER = null;
			AppDriver.closeDriver();
		}
	}
}
