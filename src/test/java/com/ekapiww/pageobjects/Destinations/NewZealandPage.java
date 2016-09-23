package com.ekapiww.pageobjects.Destinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class NewZealandPage {

	private WebDriver driver;

	public NewZealandPage(WebDriver driver) {
		this.driver=driver;
	}

	public void assertNewZealandPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-209"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-209"));
		Assert.assertTrue(elementOnPage);
	}
}
