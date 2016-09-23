package com.ekapiww.pageobjects;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekapiww.utils.Utils;

public class HomeDestinationSection {
	WebDriver driver;
	WebDriverWait wait;
	
	public HomeDestinationSection(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	public void assertDestinationSectionIntroPresent() {
		Boolean elementOnPaage = Utils.isElementPresent(driver, By.cssSelector("#home-destination .section-intro"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Destination Intro section is not present on homepage", elementOnPaage);

	}

	public void assertDestinationSectionIntroConetent() {
		Boolean destinationIntroTitle = Utils.isElementPresent(driver, By.cssSelector("#home-destination .section-intro .title-container"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Destination Intro Title is not present on Home Page", destinationIntroTitle);
		
		Boolean destinationIntroDescription = Utils.isElementPresent(driver, By.cssSelector("#home-destination .section-intro .desc-container"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Destination Intro Description is not present on Home Page", destinationIntroDescription);
		
		List<WebElement> ctas = driver.findElements(By.cssSelector("#home-destination .section-intro .cta-container a.btn"));
		
		Assert.assertTrue(driver.getCurrentUrl() + " " + "2 CTA's are not present for first panel in Destination Intro section", ctas.size() == 2);

	}

}
