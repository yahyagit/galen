package com.ekapiww.pageobjects.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekapiww.utils.AppVariables;
import com.ekapiww.utils.PropertyReader;

public class LoginPage {
	private WebDriver driver = null;
	private WebDriverWait wait;
	private PropertyReader propReader = new PropertyReader("/com/ekapiww/properties/testdata.properties");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	public AdminPage loginAsAdmin() {
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.id("edit-name"))).sendKeys(propReader.readProperty(AppVariables.APP_ENV+".admin.username"));
		
		driver.findElement(By.id("edit-pass")).sendKeys(propReader.readProperty(AppVariables.APP_ENV+".admin.password"));
		
		driver.findElement(By.id("edit-pass")).submit();
		
		return new AdminPage(driver);
		
	}

	public AdminPage loginAsContentPublisher() {
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.id("edit-name"))).sendKeys(propReader.readProperty(AppVariables.APP_ENV+".contentPublisher.username"));
		
		driver.findElement(By.id("edit-pass")).sendKeys(propReader.readProperty(AppVariables.APP_ENV+".contentPublisher.password"));
		
		driver.findElement(By.id("edit-pass")).submit();
		
		return new AdminPage(driver);
	}

	
}
