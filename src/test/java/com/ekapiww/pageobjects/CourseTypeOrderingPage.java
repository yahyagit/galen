package com.ekapiww.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekapiww.pageobjects.cms.CmsHomeCourseSection;

public class CourseTypeOrderingPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public CourseTypeOrderingPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	public void changeCourseOrder() throws InterruptedException {
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.className("tabledrag-toggle-weight")))
				.click();
			
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		setCourseTypePlace(".course-type-559", "-1");
		setCourseTypePlace(".course-type-561", "-2");
		setCourseTypePlace(".course-type-560", "-3");
		setCourseTypePlace(".course-type-557", "-4");
		setCourseTypePlace(".course-type-558", "-5");
	
	}

	public void setCourseTypePlace(String course, String orderWeight){
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.cssSelector(course+" .draggableviews-weight")))
		.sendKeys(orderWeight);	
	}
	
	public void save() {
		driver.findElement(By.id("edit-submit")).click();
	}

	public CmsHomeCourseSection clickOnHome() {
		driver.findElement(
				By.cssSelector(".breadcrumb > a:nth-child(1)")).click();
//				By.cssSelector(".navbar-icon.navbar-icon-home")).click();		
		
		return new CmsHomeCourseSection(driver);
	}

	public void resetCourseOrder() {
		setCourseTypePlace(".course-type-559", "-5");
		setCourseTypePlace(".course-type-561", "-4");
		setCourseTypePlace(".course-type-560", "-3");
		setCourseTypePlace(".course-type-557", "-2");
		setCourseTypePlace(".course-type-558", "-1");		
	}
	
}
