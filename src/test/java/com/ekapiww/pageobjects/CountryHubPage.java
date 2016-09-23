package com.ekapiww.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.AppVariables;

public class CountryHubPage {
	private WebDriver driver;
	
	public CountryHubPage(WebDriver driver) {
		this.driver = driver;
		
	}

	public void assertCountryLanguageUrlIsPresent(){
		
		Assert.assertTrue(driver.getCurrentUrl().contains(AppVariables.APP_URL));
	}
	
	public void clickOnCountry(String country){
		driver.findElement(By.linkText(country)).click();
			
	}
	
	public void assertCountryURL(String URL){
		Assert.assertTrue(driver.getCurrentUrl().contains(URL));
	}
	
}
