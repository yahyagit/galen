package com.ekapiww.pageobjects.AboutKaplan;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class AboutKaplanPage {
	private WebDriver driver;

	public AboutKaplanPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void assertAboutKaplanPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-893"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-893"));
		Assert.assertTrue(elementOnPage);
			
	}

}
