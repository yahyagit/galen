package com.ekapiww.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekapiww.pageobjects.cms.CmsHomeDestinationSection;
import com.ekapiww.pageobjects.cms.CmsHomePage;

public class DestinationOrderingPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public DestinationOrderingPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	public void setPanelStructure(String items) {
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.id("edit-items-to-display")))
		.sendKeys(items);
		
	}

	public CmsHomePage save() {
		driver.findElement(By.id("edit-submit")).click();
		    
		return new CmsHomePage(driver);
	}

	public void changeCountriesOrder() throws Throwable {
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.className("tabledrag-toggle-weight"))).sendKeys(Keys.ENTER);
//				.click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		
		setCountryPlace(".AU", "-1");
		setCountryPlace(".CA", "-2");
		setCountryPlace(".IE", "-3");
		setCountryPlace(".MT", "-4");
		setCountryPlace(".NZ", "-5");
		setCountryPlace(".SG", "-6");
		setCountryPlace(".GB", "-7");
		setCountryPlace(".US", "-8");
	}
	
	public void resetCountriesOrder() {
	
		setCountryPlace(".AU", "-8");
		setCountryPlace(".CA", "-7");
		setCountryPlace(".IE", "-6");
		setCountryPlace(".MT", "-5");
		setCountryPlace(".NZ", "-4");
		setCountryPlace(".SG", "-3");
		setCountryPlace(".GB", "-2");
		setCountryPlace(".US", "-1");
	}
	
	public void setCountryPlace(String country, String orderWeight) {
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.cssSelector(country + " .draggableviews-weight")))
		.sendKeys(orderWeight);
	}

	public CmsHomeDestinationSection clickOnHome() {
		driver.findElement(
				By.cssSelector(".breadcrumb > a:nth-child(1)")).sendKeys(Keys.ENTER);		
		
		return new CmsHomeDestinationSection(driver);
	}
}
