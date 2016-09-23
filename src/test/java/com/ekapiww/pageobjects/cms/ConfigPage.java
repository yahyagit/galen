package com.ekapiww.pageobjects.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ConfigPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	public ConfigCountryPage clickCountries() {
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.linkText("Countries"))).sendKeys(Keys.ENTER);
	
		return new ConfigCountryPage(driver);
	}
	
	public KisSettingsPage clickKisSettings(){
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.linkText("KIS settings"))).click();
		
		return new KisSettingsPage(driver);
	}

}
