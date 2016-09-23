package com.ekapiww.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class PromotionsPage {

	private WebDriver driver;

	public PromotionsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void assertPromotionPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-552"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-552"));
		Assert.assertTrue(elementOnPage);
	}

}
