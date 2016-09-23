package com.ekapiww.pageobjects.Destinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class UnitedKingdomPage {

	private WebDriver driver;

	public UnitedKingdomPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void assertUnitedKingdomPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-207"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-207"));
		Assert.assertTrue(elementOnPage);
	}

}
