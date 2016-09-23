package com.ekapiww.pageobjects.EnglishCourses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.pageobjects.EnglishLevelTestSignupPage;
import com.ekapiww.utils.Utils;

public class FreeEnglishTestPage {
	
	private WebDriver driver;
	
	public FreeEnglishTestPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void assertEnglishTestPage(){
		Utils.waitForElementPresence(driver, By.cssSelector(".page-node-553"), 10);
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".page-node-553"));
		Assert.assertTrue(elementOnPage);
	}

	public EnglishLevelTestSignupPage startTest() {
		driver.findElement(By.className("btn-eng-test")).click();
		
		return new EnglishLevelTestSignupPage(driver);
	}
}
