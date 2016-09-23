package com.ekapiww.utils;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utils {
	
	public static Boolean waitForElementPresence(WebDriver driver, By by, int waitTime){
		new WebDriverWait(driver, waitTime)
				.until(ExpectedConditions.presenceOfElementLocated(by));
		return null;
		
	}
	
	public static void selectFromDropDownByIndex(WebDriver driver, By by, int value){
		Select select = new Select (driver.findElement(by));
				select.selectByIndex(value);
	} 


	public static boolean isElementPresent(WebDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 if (driver.findElements(by).size() != 0){
			 return true;
		 }
		
		return false;
	}

	
	public boolean isAlertPresent(WebDriver driver){

        try{
            driver.switchTo().alert();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
	

	/**Returns the web element if it exist
	 * @param driver 
	 * 				current Selenium driver
	 * @param by	 
	 * 				element locator	
	 * @return Select
	 * 				Returns the select element 
	 */
	public static WebElement getWebElement(WebDriver driver, By by) {
		
		try {
			WebElement element = (new WebDriverWait(driver, 20))
					.until(ExpectedConditions.presenceOfElementLocated(by));

			return element;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	/** Returns the Select web element if it exists
	 * 
	 * @param driver 
	 * 				current Selenium driver
	 * @param by	 
	 * 				element locator	
	 * @return Select
	 * 				Returns the select element 
	 */
	public static Select getSelectElement(WebDriver driver, By by) {
		
		
		try {
			WebElement element = (new WebDriverWait(driver, 20))
					.until(ExpectedConditions.presenceOfElementLocated(by));

	
			return new Select(element);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	public static void waitForElementToBeClickable(WebDriver driver, By by){
		
		new WebDriverWait(driver, 10)
			.until(ExpectedConditions.elementToBeClickable(by));
		}

}
