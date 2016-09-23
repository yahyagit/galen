package com.ekapiww.pageobjects.cms;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigCountryLayoutPage {
	WebDriver driver;
	WebDriverWait wait;

	public ConfigCountryLayoutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	public static String firstCountryNameID;
	public static String secondCountryNameID;
	
	public void clickAustralia() {
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.id("country-au"))).click();
	}

	public void clickNewZealand() {
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.id("country-nz"))).click();
	}

	
	@SuppressWarnings("deprecation")
	public void selectDestinationRow(int rowNumber) {
		wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector(".success"), "Layout reset successfully"));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.cssSelector("li#destinations-row-"+rowNumber+" input"))).click();;
	}

	public void clickSwap() throws Throwable {
		driver.findElement(By.id("edit-swap")).click();	
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public void clickSave() throws Throwable {
		driver.findElement(By.id("edit-save")).click();			
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);	}	
	

	@SuppressWarnings("deprecation")
	public void resetTileDesign() throws Throwable {
		TimeUnit.SECONDS.sleep(2);
		WebElement reset = driver.findElement(By.id("edit-delete"));	
		reset.sendKeys(Keys.TAB);
		new Actions(driver).moveToElement(reset).click().perform();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector(".success"), "Layout reset successfully"));
	}

	public void selectFirstCountry() throws Throwable {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("destinations-row-1")));
		WebElement countryNameLocator = driver.findElement(By.cssSelector("#destinations-row-1 > ul > li:nth-child(1)"));
		countryNameLocator.click();
		String countryNameID = countryNameLocator.getAttribute("id");
		
		System.out.println(countryNameID);
		firstCountryNameID = countryNameID;
		
		
		}

	public void selectSecondCountry() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("destinations-row-1")));
		WebElement countryNameLocator = driver.findElement(By.cssSelector("#destinations-row-1 > ul > li:nth-child(2)"));
		countryNameLocator.click();
		String countryNameID = countryNameLocator.getAttribute("id");
		System.out.println(countryNameID);
		secondCountryNameID = countryNameID;
		
		WebElement layoutBox = driver.findElement(By.cssSelector("#destinations-row-1 > div > select"));
		layoutBox.sendKeys("2 elements");
		
	}

	public void checkSelectionCheckbox() throws Throwable {
		WebElement checkbox = driver.findElement(By.cssSelector("#destinations-row-1 > div > div > input"));
		String elementType = checkbox.getAttribute("type");
		System.out.println(elementType);
		Thread.sleep(5000);
	
		checkbox.click();
		
		
	}
}
