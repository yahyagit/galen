package com.ekapiww.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ekapiww.dataobjects.GenerateData;
import com.ekapiww.utils.AppDriver;
import com.ekapiww.utils.AppVariables;
import com.ekapiww.utils.Utils;


public class EnglishLevelTestSignupPage {
	
	private WebDriver driver;
	
	public EnglishLevelTestSignupPage(WebDriver driver){
		this.driver = driver;
	}
	private static GenerateData gendata = new GenerateData(AppDriver.getDriver());
	public static CharSequence email = gendata.generateEmail(12) ;
	
	public void fillSignupTestForm() {
		driver.findElement(By.xpath("//input[contains(@id, 'edit-submitted-firstname')]")).sendKeys("testEnglish");
		
		driver.findElement(By.xpath("//input[contains(@id, 'edit-submitted-lastname')]")).sendKeys("User");
		
		try{
			Boolean countryField =Utils.isElementPresent(driver, By.cssSelector("div.form-item:nth-child(4) > label:nth-child(1)"));
			if(countryField){
				
				if (AppVariables.APP_URL.contains("ru")){
					driver.findElement(By.xpath("//select[contains(@id, 'edit-submitted-country')]")).sendKeys("Россия");
				}
				else{
				driver.findElement(By.xpath("//select[contains(@id, 'edit-submitted-country')]")).sendKeys("Bra");
				}
				
			}	
		}
		catch(Exception e){
			
		}
		
		if (AppVariables.APP_URL.contains("ar")){
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id^='edit-submitted-nationality']"), 2);
		}
		
	
		driver.findElement(By.xpath("//input[contains(@id, 'edit-submitted-email')]")).sendKeys(email);
	}

	public EnglishLevelTestAttemptPage submitSignupForm() {
		driver.findElement(By.cssSelector(".webform-submit")).sendKeys(Keys.ENTER);
		
		return new EnglishLevelTestAttemptPage(driver);
	}

}
