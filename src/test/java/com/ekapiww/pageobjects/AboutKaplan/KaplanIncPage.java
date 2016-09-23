package com.ekapiww.pageobjects.AboutKaplan;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class KaplanIncPage {
	private WebDriver driver;
	
	public KaplanIncPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void assertKaplanIncPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-912"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-912"));
		Assert.assertTrue(elementOnPage);
	}

}
