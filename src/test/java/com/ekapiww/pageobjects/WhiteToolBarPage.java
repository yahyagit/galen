package com.ekapiww.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekapiww.utils.AppVariables;
import com.ekapiww.utils.Utils;

public class WhiteToolBarPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public WhiteToolBarPage (WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
	}
	
	
	public void assertWhiteToolBarIsPresent(){
		By headerLocator = AppVariables.OBJECT_REPO.getLocator("white_toolbar.header.div");
		wait.until(ExpectedConditions.presenceOfElementLocated(headerLocator));
		AppVariables.APP_DRIVER.findElement(headerLocator).isDisplayed();
	}
	
	
	public void assertIfFiveToolBarPresent() throws InterruptedException{
		By freeBrochureLocator = AppVariables.OBJECT_REPO.getLocator("white_toolbar.free_brochure_id.link");
		Boolean freeBrochure =  Utils.isElementPresent(AppVariables.APP_DRIVER, freeBrochureLocator);
		Assert.assertTrue(freeBrochure);
		
		if (freeBrochure){
			WebElement freeBrochurePresent = AppVariables.APP_DRIVER.findElement(freeBrochureLocator);
			freeBrochurePresent.click();
			
			By freeBrochureHrefLocator = AppVariables.OBJECT_REPO.getLocator("white_toolbar.free_brochure_href.link");
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(freeBrochureHrefLocator));
			Boolean elementOnPage = Utils.isElementPresent(AppVariables.APP_DRIVER, freeBrochureHrefLocator);
			
			Assert.assertTrue(elementOnPage);
			AppVariables.APP_DRIVER.navigate().back();
		}
		
		By contactUsLocator = AppVariables.OBJECT_REPO.getLocator("white_toolbar.contact_us_id.link");
		Boolean contactUs    =  Utils.isElementPresent(AppVariables.APP_DRIVER, contactUsLocator);
		Assert.assertTrue(contactUs);
		if (contactUs){
			WebElement contactUsPresent = AppVariables.APP_DRIVER.findElement(contactUsLocator);
			contactUsPresent.click();

			By contactUsHrefLocator = AppVariables.OBJECT_REPO.getLocator("white_toolbar.contact_us_href.link");
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(contactUsHrefLocator));
			Boolean elementOnPage = Utils.isElementPresent(AppVariables.APP_DRIVER, contactUsHrefLocator);
			
			Assert.assertTrue(elementOnPage);
			AppVariables.APP_DRIVER.navigate().back();		
		}
		
	
		Boolean phoneNumber  =  Utils.isElementPresent(AppVariables.APP_DRIVER, 
				AppVariables.OBJECT_REPO.getLocator("white_toolbar.telephone.link"));
		Assert.assertTrue(phoneNumber);

		By siteSearchLocator = AppVariables.OBJECT_REPO.getLocator("white_toolbar.site_search.link");
		Boolean searchButton =  Utils.isElementPresent(AppVariables.APP_DRIVER, siteSearchLocator);
		Assert.assertTrue(searchButton);
		
		if (searchButton){
			WebElement searchButtonPresent = AppVariables.APP_DRIVER.findElement(siteSearchLocator);
			searchButtonPresent.click();
			
			String baseurl= AppVariables.APP_DRIVER.getWindowHandle();
			By siteSearchTextBoxLocator = AppVariables.OBJECT_REPO.getLocator("white_toolbar.site_search.textbox");
			AppVariables.APP_DRIVER.findElement(siteSearchTextBoxLocator).isEnabled();
			AppVariables.APP_DRIVER.switchTo().window(baseurl);
			AppVariables.APP_DRIVER.findElement(siteSearchTextBoxLocator).getAttribute("disabled");
		
		}
		
		AppVariables.APP_DRIVER.findElement(
				AppVariables.OBJECT_REPO.getLocator("white_toolbar.site_language_selector.link")).isDisplayed();
					
	}
		
		
	public void verifyCountyURL(String countryURL){
	
		By siteLangLocator = AppVariables.OBJECT_REPO.getLocator("white_toolbar.site_language_selector.link");
		boolean countryLogo = AppVariables.APP_DRIVER.findElement(siteLangLocator).isEnabled();
		if (countryLogo){
			WebDriverWait wait = new WebDriverWait(AppVariables.APP_DRIVER, 10);
			wait.until(ExpectedConditions.elementToBeClickable(siteLangLocator));
		
			Actions action = new Actions(AppVariables.APP_DRIVER);
			action.moveToElement(AppVariables.APP_DRIVER.findElement(siteLangLocator)).doubleClick().build().perform();
	
			Assert.assertTrue(AppVariables.APP_DRIVER.getCurrentUrl().contains(countryURL));
		
		}
	}
	
}
