package com.ekapiww.pageobjects.EnglishCourses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class BenefitsOfLearningEnglishPage {
	
	private WebDriver driver;
	
	public BenefitsOfLearningEnglishPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void assertBenefitsOfLearningPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-911"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-911"));
		Assert.assertTrue(elementOnPage);
		
	}

}
