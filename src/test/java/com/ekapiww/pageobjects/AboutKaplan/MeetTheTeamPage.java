package com.ekapiww.pageobjects.AboutKaplan;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class MeetTheTeamPage {

	private WebDriver driver;

	public MeetTheTeamPage(WebDriver driver) {
		this.driver=driver;
	}

	public void assertMeetTheTeamPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-806"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-806"));
		Assert.assertTrue(elementOnPage);
	}

}
