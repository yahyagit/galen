package com.ekapiww.pageobjects.cms;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekapiww.pageobjects.CourseTypeOrderingPage;
import com.ekapiww.utils.Utils;

public class CmsHomeCourseSection {
	WebDriver driver;
	WebDriverWait wait;
	
	
	public CmsHomeCourseSection(WebDriver driver) {
		this.driver = driver; 
		this.wait = new WebDriverWait(driver, 20);
	}

	public CourseTypeOrderingPage navigateToOrderingPage() {
		Utils.waitForElementPresence(driver, By.cssSelector(".adult-eng-intro > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1)"), 10);
		driver.navigate().refresh();
		
		wait.until(
				ExpectedConditions.elementToBeClickable(
						By.cssSelector(".adult-eng-intro .edit_translate a"))).sendKeys(Keys.ENTER);
	 		
		return new CourseTypeOrderingPage(driver);
	}
	
	public CmsHomeCourseSection assertCourseOrder() {
		
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".course-type-558.position-1"));	   	
		Assert.assertTrue("Exam Preparation Courses is not at correct position", elementOnPage);
		
		elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".course-type-557.position-2"));	   	
		Assert.assertTrue("Flexible English is not at correct position", elementOnPage);
		
		elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".course-type-560.position-3"));	   	
		Assert.assertTrue("Business English Courses is not at correct position", elementOnPage);
		
		elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".course-type-561.position-4"));	   	
		Assert.assertTrue("Work amd Study programs is not  at correct position", elementOnPage);
		
		elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".course-type-559.position-5"));	   	
		Assert.assertTrue("Long term courses is not at correct position", elementOnPage);
		
		return new CmsHomeCourseSection(driver);
	}
	

	public void logout() {
		driver.findElement(By.id("navbar-item--5")).click();
		driver.findElement(By.cssSelector(".logout a")).click();
	}	
}
