package com.ekapiww.pageobjects.Destinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class SingaporePage {

	private WebDriver driver;

	public SingaporePage(WebDriver driver) {
		this.driver=driver;
	}

	public void assertSingaporePage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-426"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-426"));
		Assert.assertTrue(elementOnPage);
	}
}
