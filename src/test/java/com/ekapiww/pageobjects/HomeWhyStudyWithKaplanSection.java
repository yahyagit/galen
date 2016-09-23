package com.ekapiww.pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ekapiww.pageobjects.AboutKaplan.AboutKaplanPage;
import com.ekapiww.utils.Utils;

public class HomeWhyStudyWithKaplanSection {
	
	private WebDriver driver;

	public HomeWhyStudyWithKaplanSection(WebDriver driver){
		this.driver=driver;
	}
	
	
	public void assertWhyKaplanSection(){
		Utils.waitForElementPresence(driver, By.cssSelector(".about-intro"), 20);
		Boolean whyKaplan = Utils.isElementPresent(driver, By.cssSelector(".about-intro"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Why study with Kaplan section is missing", whyKaplan);
	}

	public void assertIntro(){
		Boolean intro = Utils.isElementPresent(driver, By.cssSelector(".about-intro > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1)"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Why study with Kaplan intro is missing", intro);
		
		Boolean introDesc = Utils.isElementPresent(driver, By.cssSelector(".about-intro > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > p:nth-child(1)"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Why study with Kaplan description is missing", introDesc);
	}
	
	public void assertIcons(){
		Boolean icon = Utils.isElementPresent(driver, By.cssSelector("#home-about .row .col-sm-3"));
		
		if(icon){
			List<WebElement> icons = driver.findElements(By.cssSelector("#home-about .row .col-sm-3 .icon "));
			Assert.assertTrue(driver.getCurrentUrl() + " " + "Icon image is missing", icons.size()==4);
					
		}
		
		List<WebElement> iconTitle = driver.findElements(By.cssSelector("#home-about .row .col-sm-3 .title"));
		Assert.assertTrue("Icon Title is missing", iconTitle.size()==4);
		
		
		List<WebElement> iconDesc = driver.findElements(By.cssSelector("#home-about .row .col-sm-3 .desc"));
		Assert.assertTrue("Icon description is missing", iconDesc.size()==4);
				
	}
	
	public void assertCTAs(){
		Boolean CTA = Utils.isElementPresent(driver, By.cssSelector("div.cta-container:nth-child(1) > p:nth-child(1) > a"));
		
		if(CTA){
			List<WebElement> CTAs = driver.findElements(By.cssSelector("div.cta-container:nth-child(1) > p:nth-child(1) > a"));
			Assert.assertTrue("CTAs are missing", CTAs.size()==2);
			
		}
		
	}
	
	public AboutKaplanPage clickOnLearnMoreAboutUs(){
		driver.findElement(By.cssSelector("div.cta-container:nth-child(1) > p:nth-child(1) > a:nth-child(1)")).sendKeys(Keys.ENTER);
		
		return new AboutKaplanPage(driver);
	}
	
	public FreeBrochurePage clickOnDownloadBrochure(){
		driver.findElement(By.cssSelector("div.cta-container:nth-child(1) > p:nth-child(1) > a:nth-child(2)")).sendKeys(Keys.ENTER);
		
		return new FreeBrochurePage(driver);
	}
	
	
}
