package com.ekapiww.pageobjects.AboutKaplan;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class KPlusPage {
	private WebDriver driver;

	public KPlusPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void assertKPlusPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-879"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-879"));
		Assert.assertTrue(elementOnPage);
	}

}
