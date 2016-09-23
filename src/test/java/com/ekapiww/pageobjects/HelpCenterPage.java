package com.ekapiww.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class HelpCenterPage {
	private WebDriver driver;
	
	public HelpCenterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void assertHelpCenterPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-help"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-help"));
		Assert.assertTrue(elementOnPage);
	}
	
}
