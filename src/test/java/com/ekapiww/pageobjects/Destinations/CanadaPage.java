package com.ekapiww.pageobjects.Destinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class CanadaPage {

	private WebDriver driver;

	public CanadaPage(WebDriver driver) {
		this.driver=driver;
	}

	public void assertCanadaPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-211"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-211"));
		Assert.assertTrue(elementOnPage);
	}
}
