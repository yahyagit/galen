package com.ekapiww.pageobjects.Destinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class IrelandPage {

	private WebDriver driver;

	public IrelandPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void assertIrelandPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-208"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-208"));
		Assert.assertTrue(elementOnPage);
	}

}
