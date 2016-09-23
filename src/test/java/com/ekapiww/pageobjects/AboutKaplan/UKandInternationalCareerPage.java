package com.ekapiww.pageobjects.AboutKaplan;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.pageobjects.HeaderSection;
import com.ekapiww.utils.Utils;

public class UKandInternationalCareerPage {

	private WebDriver driver;

	public UKandInternationalCareerPage(WebDriver driver) {
		this.driver=driver;
	}

	public HeaderSection assertUKandInternationalCareerPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-id-210"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-id-210"));
		Assert.assertTrue(elementOnPage);
		
		driver.navigate().back();
		return new HeaderSection(driver);
	}

}
