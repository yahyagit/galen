package com.ekapiww.pageobjects.cms;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekapiww.pageobjects.DestinationOrderingPage;
import com.ekapiww.utils.Utils;

public class CmsHomeDestinationSection {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CmsHomeDestinationSection(WebDriver driver) {
		this.driver = driver; 
		this.wait = new WebDriverWait(driver, 20);	
	}

	public DestinationOrderingPage navigateToOrdering() {
		driver.findElement(
				By.cssSelector(".destination-intro > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")).sendKeys(Keys.ENTER);
		
		return new DestinationOrderingPage(driver);
	}
	
	public void assertPanelStructure(int items) {	
		
        for(int i=1; i<=8; i++){
    		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".destination-item.position-"+i));
        	
    		if (i <= items) {
    			Assert.assertTrue(elementOnPage);	
    		} else {
    			Assert.assertFalse(elementOnPage);
    		}
        }

	}

	public void assertDestinationOrdering() {
//		driver.findElement(
//				By.cssSelector(".navbar-icon.navbar-icon-home")).click();
		
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector("#country-212.destination-item.position-1"));	   	
		Assert.assertTrue("Destination US is not at at correct position", elementOnPage);
		
		elementOnPage = Utils.isElementPresent(driver, By.cssSelector("#country-207.destination-item.position-2"));	   	
		Assert.assertTrue("Destination UK is not at at correct position", elementOnPage);
		
		elementOnPage = Utils.isElementPresent(driver, By.cssSelector("#country-426.destination-item.position-3"));	   	
		Assert.assertTrue("Destination Singapore is not at at correct position", elementOnPage);
				
		elementOnPage = Utils.isElementPresent(driver, By.cssSelector("#country-209.destination-item.position-4"));	   	
		Assert.assertTrue("Destination NZ is not at at correct position", elementOnPage);

		elementOnPage = Utils.isElementPresent(driver, By.cssSelector("#country-425.destination-item.position-5"));	   	
		Assert.assertTrue("Destination Malta is not at at correct position", elementOnPage);

		elementOnPage = Utils.isElementPresent(driver, By.cssSelector("#country-208.destination-item.position-6"));	   	
		Assert.assertTrue("Destination Ireland is not at at correct position", elementOnPage);

		elementOnPage = Utils.isElementPresent(driver, By.cssSelector("#country-211.destination-item.position-7"));	   	
		Assert.assertTrue("Destination Canada is not at at correct position", elementOnPage);

		elementOnPage = Utils.isElementPresent(driver, By.cssSelector("#country-210.destination-item.position-8"));	   	
		Assert.assertTrue("Destination Australia is not at at correct position", elementOnPage);

	}

	public void clickViewAllCities() {
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.cssSelector(".destination-intro .cta-container li:nth-child(2)"))).sendKeys(Keys.ENTER);
		
	}
}
