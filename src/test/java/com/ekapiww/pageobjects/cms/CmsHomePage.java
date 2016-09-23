package com.ekapiww.pageobjects.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CmsHomePage {

	private WebDriver driver = null;

	public CmsHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void logout() {

		driver.findElement(By.cssSelector(".admin-menu-action>a")).sendKeys(Keys.ENTER);
	}
}
