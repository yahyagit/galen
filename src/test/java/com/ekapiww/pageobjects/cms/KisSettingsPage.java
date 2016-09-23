package com.ekapiww.pageobjects.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ekapiww.utils.Utils;

public class KisSettingsPage {

	private WebDriver driver;

	public KisSettingsPage(WebDriver driver) {
		this.driver =driver;
	}
	
	public void configureWhiteToolBarForTest() throws InterruptedException{
		
		//turn CTAs on for Arabic	
		Utils.waitForElementToBeClickable(driver, By.linkText("Arabic"));
		driver.findElement(By.linkText("Arabic")).click();
		this.checkWhiteToolBarCTAsOnKisSetting();
		this.clickSaveKisSettings();
		
		//turn CTAs on for Russian
		Utils.waitForElementToBeClickable(driver, By.linkText("Russian"));
		driver.findElement(By.linkText("Russian")).click();
		this.checkWhiteToolBarCTAsOnKisSetting();
		this.clickSaveKisSettings();
		
		//turn CTAs on for Germany
		Utils.waitForElementToBeClickable(driver, By.linkText("German"));
		driver.findElement(By.linkText("German")).click();
		this.checkWhiteToolBarCTAsOnKisSetting();
		this.clickSaveKisSettings();
		
		//turn CTAs on for English
		Utils.waitForElementToBeClickable(driver, By.linkText("English"));
		driver.findElement(By.linkText("English")).click();
		this.checkWhiteToolBarCTAsOnKisSetting();
		this.clickSaveKisSettings();
		
		//turn CTAs on for Taiwan
		Utils.waitForElementToBeClickable(driver, By.linkText("Chinese, Traditional"));
		driver.findElement(By.linkText("Chinese, Traditional")).click();
		this.checkWhiteToolBarCTAsOnKisSetting();
		this.clickSaveKisSettings();
		
		//turn CTAs on for Thai
		Utils.waitForElementToBeClickable(driver, By.linkText("Thai"));
		driver.findElement(By.linkText("Thai")).click();
		this.checkWhiteToolBarCTAsOnKisSetting();
		this.clickSaveKisSettings();
		
	}
		
	
	public void checkWhiteToolBarCTAsOnKisSetting() throws InterruptedException{
	
		Utils.waitForElementToBeClickable(driver, By.id("edit-kis-feature-freebrochure-show"));
		
		WebElement brochure = driver.findElement(By.id("edit-kis-feature-freebrochure-show"));
		if(!brochure.isSelected())
			brochure.click();
			System.out.println("Brochure CTA is published");
			
		WebElement getQuote = driver.findElement(By.id("edit-kis-feature-getaquote-show"));
		if(!getQuote.isSelected())
			getQuote.click();
		
		WebElement contactUs = driver.findElement(By.id("edit-kis-feature-contact-us-show"));
		if(!contactUs.isSelected())
			contactUs.click();
		
		WebElement phone = driver.findElement(By.id("edit-kis-feature-phone-number-show"));
		if(!phone.isSelected())
			phone.click();
		
		WebElement search =driver.findElement(By.id("edit-kis-feature-search-show"));
		if(!search.isSelected())
			search.click();
			
	}
	
	
	public KisSettingsPage clickSaveKisSettings() throws InterruptedException{
		driver.findElement(By.id("edit-submit")).click();
				
		return this;
	}


}
