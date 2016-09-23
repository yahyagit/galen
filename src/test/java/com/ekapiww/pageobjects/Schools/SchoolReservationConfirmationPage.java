package com.ekapiww.pageobjects.Schools;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SchoolReservationConfirmationPage {
	private WebDriver driver;
	
	public SchoolReservationConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void confirmReservation() {
		Assert.assertTrue("Reservation failed", 
				new WebDriverWait(driver, 30)
				.until(ExpectedConditions.presenceOfElementLocated(By.id("edit-reference")))
				.isDisplayed());
		
	}

}
