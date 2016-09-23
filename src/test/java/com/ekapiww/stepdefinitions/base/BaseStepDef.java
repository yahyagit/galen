package com.ekapiww.stepdefinitions.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ekapiww.element.ObjectRepoReader;
import com.ekapiww.utils.AppDriver;
import com.ekapiww.utils.AppVariables;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseStepDef {

	@Before
	public void doSetup() {
		if (AppVariables.APP_DRIVER == null) {
			AppVariables.APP_DRIVER = AppDriver.getDriver();
		}

		if (AppVariables.OBJECT_REPO == null) {
			AppVariables.OBJECT_REPO = new ObjectRepoReader("/com/ekapiww/properties/ObjectRepository.properties");
		}
	}

	 @After
	public void embedScreenshot(Scenario scenario) {
		System.out.println("After hook...");
		if (scenario.isFailed()) {
			System.out.println("Scenario failed..");
			byte[] screenshot = ((TakesScreenshot) AppVariables.APP_DRIVER).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/jpeg");
		}
	}
}
