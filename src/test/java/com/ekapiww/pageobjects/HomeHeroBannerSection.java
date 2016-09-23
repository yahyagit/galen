package com.ekapiww.pageobjects;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ekapiww.utils.Utils;

public class HomeHeroBannerSection {
	
	private WebDriver driver;

	public HomeHeroBannerSection(WebDriver driver){
		this.driver=driver;
	}
	
	public void assertHeroBannerSection(){
		Boolean heroBanner = Utils.isElementPresent(driver, By.cssSelector(".vertical-center-inner"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "HeroBanner is not present", heroBanner);
	}
	
	public void assertContentOnBanner(){
		Boolean subHeading = Utils.isElementPresent(driver, By.cssSelector(".text-container > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1)"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Sub heading is missing on Hero Banner", subHeading);
		
		Boolean mainHeading = Utils.isElementPresent(driver, By.cssSelector(".text-container > div:nth-child(1) > div:nth-child(1) > h1:nth-child(2)"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Main heading is missing on Hero Banner", mainHeading);
		
		Boolean description = Utils.isElementPresent(driver, By.cssSelector(".home-desc"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Description is missing on Hero Banner", description);
		
	}
	
	public void assertCTAsOnBanner(){
		Boolean CTA = Utils.isElementPresent(driver, By.cssSelector(".course-finder-link"));
		//Assert.assertTrue("CTA is missing on Hero Banner", CTA);
		
		if (CTA){
			 List<WebElement> cta = driver.findElements(By.cssSelector(".course-finder-link> a"));
			 Assert.assertTrue(cta.size() == 2);
			
		}
	}
	public ContactUsPage clickOnContactUsCTA(){
		driver.findElement(By.cssSelector("a.btn-xl")).click();
		
		
		return new 	ContactUsPage(driver);
	
	}
	
	public AgentLocatorFormPage clickOnContactUsCTAForAgentLocator(){
		driver.findElement(By.cssSelector("a.btn-xl")).click();
		
		
		return new 	AgentLocatorFormPage(driver);
	
	}

}
