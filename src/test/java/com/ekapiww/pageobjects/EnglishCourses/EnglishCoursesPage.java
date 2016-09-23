package com.ekapiww.pageobjects.EnglishCourses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class EnglishCoursesPage {
	
	private WebDriver driver;

	public EnglishCoursesPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void assertEnglishCoursesPage(){
		
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-555"), 30);
	
		Boolean EnglishCoursePage = Utils.isElementPresent(driver, By.cssSelector(".page-node-555"));
		Assert.assertTrue(EnglishCoursePage);
	}

}
