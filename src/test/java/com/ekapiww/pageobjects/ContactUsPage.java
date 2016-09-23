package com.ekapiww.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ekapiww.dataobjects.GenerateData;
import com.ekapiww.utils.AppDriver;
import com.ekapiww.utils.AppVariables;
import com.ekapiww.utils.PropertyReader;
import com.ekapiww.utils.Utils;

public class ContactUsPage {
	private WebDriver driver;
	private PropertyReader propReader = new PropertyReader("/com/ekapiww/properties/testdata.properties");
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
			
	}
	
	private static GenerateData gendata = new GenerateData(AppDriver.getDriver());
	public static CharSequence email = gendata.generateEmail(12) ;
	
	public  void  assertContactUsUrl(){
		Assert.assertTrue(driver.getCurrentUrl().contains("contact-us/form"));

	}
	
	public void assertContactUsPageForPortuguese(){
		Assert.assertTrue(driver.getCurrentUrl() + " No Contact Us page found for Portuguese Site", driver.getPageSource().contains("page-node-1300"));
	}
	
	public ContactUsPage populateContactUsForm(){
		Utils.selectFromDropDownByIndex(driver,By.cssSelector("select[id^='edit-submitted-program-interest']"),2);
		driver.findElement(By.cssSelector("input[id^='edit-submitted-firstname']")).sendKeys(propReader.readProperty("firstname"));
		driver.findElement(By.cssSelector("input[id^='edit-submitted-lastname'")).sendKeys(propReader.readProperty("lastname"));
		driver.findElement(By.cssSelector("input[id^='edit-submitted-email'")).sendKeys(email);
		driver.findElement(By.cssSelector("input[id^='edit-submitted-phone'")).sendKeys(propReader.readProperty("phone"));
		driver.findElement(By.cssSelector("textarea[id^='edit-submitted-questions']")).sendKeys(propReader.readProperty("comments"));

		
		try{
			if (AppVariables.APP_URL.contains("ar")){
				Utils.selectFromDropDownByIndex(driver,By.cssSelector("select[id^='edit-submitted-study-where']"),2);
			}
			else {
				Utils.selectFromDropDownByIndex(driver,By.cssSelector("select[id^='edit-submitted-study-where']"),1);
//				Utils.selectFromDropDownByIndex(driver,By.id("edit-submitted-study-where-c-sfd-1409671121"),2);
			}
		}
		catch(Exception e){
			
		}
				
		try{
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id$='-month']"), 5);
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id$='-day']"), 5);
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id$='-year']"), 2);
		}
		catch(Exception e){
			
		}

		try{
			driver.findElement(By.cssSelector("input[id^='edit-submitted-city']")).sendKeys(propReader.readProperty("city"));
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id^='edit-submitted-preferred-contact-time']"), 2);
//			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id^='edit-submitted-country']"), 2);
		}
		catch(Exception e){
			
		}
		
		try{
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id^='edit-submitted-country']"), 2);
		}
		catch(Exception e){
			
		}
		try{
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id^='edit-submitted-preferred-start-period']"), 2);
		}
		catch(Exception e){
			
		}
		
				
		if (AppVariables.APP_URL.contains("ar")){
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id^='edit-submitted-nationality']"), 2);
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id^='edit-submitted-study-length']"), 2);
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id^='edit-submitted-accommodation-interest']"), 2);
		}
			
		
		return new ContactUsPage(driver);
	}
	
	public void checkIfCheckboxIsSelected(){
		WebElement chkbox= driver.findElement(By.cssSelector("input[id^='edit-submitted-subscribe-to-promotions']"));
		if(!chkbox.isSelected()){
			chkbox.click();
			System.out.println("Checkbox is checked.");
		}
	}
	
	public ContactUsConfirmationPage clickOnContactAStudentAdvisor(){
		driver.findElement(By.cssSelector(".webform-submit")).click();
		
		return new ContactUsConfirmationPage(driver);
	}
		
			
}
