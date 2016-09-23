package com.ekapiww.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.Utils;

public class HomeThreeSecondaryBannerSection {
	
	private WebDriver driver;

	public HomeThreeSecondaryBannerSection(WebDriver driver){
		this.driver=driver;
	}
	
	public void assertThreeBannerSection(){
		Utils.waitForElementPresence(driver, By.cssSelector(".hero-lower-container"), 10);
		Boolean threeBannerSection = Utils.isElementPresent(driver, By.cssSelector(".hero-lower-container"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Three Secondary Banner Section is missing", threeBannerSection);

	}
	
	public void assertFirstPanel(){
		
		Boolean firstPanelRibbon= 
				Utils.isElementPresent(driver,  
						By.cssSelector("div.featured-item:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > label:nth-child(1)"));
		
		Assert.assertTrue(driver.getCurrentUrl() + " " + "First Banner Ribbon is missing", firstPanelRibbon);
		
		
		Boolean firstPanelTitle = 
				Utils.isElementPresent(driver,  
						By.cssSelector("div.featured-item:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > span:nth-child(2) > span:nth-child(1)"));

		Assert.assertTrue(driver.getCurrentUrl() + " " + "Banner title is missing", firstPanelTitle);
		
		
		Boolean firstPanelDesc1 = 
				Utils.isElementPresent
					(driver, By.cssSelector("div.featured-item:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > span:nth-child(2) > span:nth-child(2)"));
		
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Banner description is missing", firstPanelDesc1);
		
		
		Boolean firstPanelDesc2 = 
				Utils.isElementPresent(driver,  
						By.cssSelector("div.featured-item:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > span:nth-child(2) > span:nth-child(1)"));

		Assert.assertTrue(driver.getCurrentUrl() + " " + "Banner title is missing", firstPanelDesc2);
		
		
		Boolean firstPanelCTA =  
				Utils.isElementPresent
					(driver, By.cssSelector("div.featured-item:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > span:nth-child(2) > span:nth-child(4)"));
		
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Banner CTA is missing", firstPanelCTA);
				
	}
	
	public void assertBrochureBanner(){
		Boolean brochureBannerTitle = Utils.isElementPresent(driver,  By.cssSelector("span.text-black:nth-child(1)"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Banner title is missing", brochureBannerTitle);
		
		Boolean brochureDesc = Utils.isElementPresent(driver, By.cssSelector("span.text-black:nth-child(2)"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Banner description is missing", brochureDesc);
		
		Boolean brochureCTA =  Utils.isElementPresent(driver, By.cssSelector("span.btn:nth-child(3)"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Banner CTA is missing", brochureCTA);
		
	}

	public FreeBrochurePage clickOnFindOutMoreForBrochure(){
		driver.findElement(By.cssSelector("span.btn:nth-child(3)")).click();
		
		return new FreeBrochurePage(driver);
	}
	
	public void assertThirdPanel(){
		
		Boolean thirdPanelRibbon= 
				Utils.isElementPresent(driver,  
						By.cssSelector("div.featured-item:nth-child(3) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > label:nth-child(1)"));
		
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Third Banner Ribbon is missing", thirdPanelRibbon);
		
		
		Boolean thirdPanelTitle = 
				Utils.isElementPresent(driver,  
						By.cssSelector("div.featured-item:nth-child(3) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > span:nth-child(2) > span:nth-child(1)"));

		Assert.assertTrue(driver.getCurrentUrl() + " " + "Banner title is missing", thirdPanelTitle);
		
		
		Boolean thirdPanelDesc1 = 
				Utils.isElementPresent
					(driver, By.cssSelector("div.featured-item:nth-child(3) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > span:nth-child(2) > span:nth-child(2)"));
		
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Banner description is missing", thirdPanelDesc1);
		
		
		Boolean thirdPanelDesc2 = 
				Utils.isElementPresent(driver,  
						By.cssSelector("div.featured-item:nth-child(3) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > span:nth-child(2) > span:nth-child(1)"));

		Assert.assertTrue(driver.getCurrentUrl() + " " + "Banner title is missing", thirdPanelDesc2);
		
		
		Boolean thirdPanelCTA =  
				Utils.isElementPresent
					(driver, By.cssSelector("div.featured-item:nth-child(3) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > span:nth-child(2) > span:nth-child(4)"));
		
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Banner CTA is missing", thirdPanelCTA);
				
	}
	
	
	
}
