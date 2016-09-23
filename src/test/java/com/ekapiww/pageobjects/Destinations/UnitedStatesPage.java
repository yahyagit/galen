package com.ekapiww.pageobjects.Destinations;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;


public class UnitedStatesPage {

	private WebDriver driver;

	public UnitedStatesPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void assertUnitedSatesPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-212"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-212"));
		
		Assert.assertTrue(elementOnPage);
	
	}

}
