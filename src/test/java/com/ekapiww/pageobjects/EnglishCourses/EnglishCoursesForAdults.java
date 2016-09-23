package com.ekapiww.pageobjects.EnglishCourses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class EnglishCoursesForAdults {
	
	private WebDriver driver;
	
	public EnglishCoursesForAdults(WebDriver driver) {
		this.driver=driver;
	}
	
	public void assertEnglishCoursesForAdultsPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-554"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver,(By.cssSelector(".page-node-554")));
		Assert.assertTrue(elementOnPage);
		
		
	}

}
