package com.ekapiww.pageobjects.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigCountryPage {
	WebDriver driver;
	WebDriverWait wait;
	public ConfigCountryPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
	}
	
	public ConfigCountryLayoutPage clickLayout() {
		wait.until(
				ExpectedConditions.elementToBeClickable(
						By.linkText("Layouts"))).click();
		
		return new ConfigCountryLayoutPage(driver);
		
	}

}
