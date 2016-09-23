package com.ekapiww.pageobjects.EnglishCourses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class EnglishforYoungLearnersPage {
	
	private WebDriver driver;
	
	public EnglishforYoungLearnersPage(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void assertYoungLearnersPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-young-learners"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, (By.cssSelector(".page-young-learners")));
		Assert.assertTrue(elementOnPage);
	}

}
