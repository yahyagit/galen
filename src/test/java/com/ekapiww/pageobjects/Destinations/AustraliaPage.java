package com.ekapiww.pageobjects.Destinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class AustraliaPage {

	private WebDriver driver;

	public AustraliaPage(WebDriver driver) {
		this.driver=driver;
	}

	public void assertAustraliaPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-210"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-210"));
		Assert.assertTrue(elementOnPage);
	}
}
