package com.ekapiww.pageobjects.Destinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class MaltaPage {

	private WebDriver driver;

	public MaltaPage(WebDriver driver) {
		this.driver =driver;
	}

	public void assertMaltaPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-425"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-425"));
		Assert.assertTrue(elementOnPage);
	}
}
