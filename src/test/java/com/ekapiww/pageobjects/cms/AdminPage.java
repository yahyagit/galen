package com.ekapiww.pageobjects.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	public ConfigPage clickConfiguration() {
		wait.until(
				ExpectedConditions.elementToBeClickable(
						By.cssSelector("#admin-menu-menu > li:nth-child(8) > a:nth-child(1)"))).click();
		
		return new ConfigPage(driver);
		
	}
	
	public AdminPage clickMenu(){
		driver.findElement(By.id("navbar-item--2")).click();
		
		return new AdminPage(driver);
	}
	
	public AdminPage clickContent(){
		driver.findElement(By.id("navbar-link-admin-content")).click();
		
		return new AdminPage(driver);
		
	}

	public void navigateToHomepage() {
		driver.findElement(
				By.cssSelector(".kielogo")).click();
//		By.cssSelector(".header-logo")).click();

//		return new CmsHomePage(driver);
	}

	public CmsHomeCourseSection navigateToCourseSectionHomepage() {
		this.navigateToHomepage();

		return new CmsHomeCourseSection(driver);

	}

	public CmsHomeDestinationSection navigateToDestinationSection() {
		this.navigateToHomepage();

		return new CmsHomeDestinationSection(driver);
	}
	
}
