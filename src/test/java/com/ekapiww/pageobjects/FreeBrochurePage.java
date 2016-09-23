package com.ekapiww.pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ekapiww.dataobjects.GenerateData;
import com.ekapiww.utils.AppDriver;
import com.ekapiww.utils.PropertyReader;
import com.ekapiww.utils.Utils;

public class FreeBrochurePage {
	private WebDriver driver;
	private PropertyReader propReader = new PropertyReader("/com/ekapiww/properties/testdata.properties");
		
	public FreeBrochurePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private static GenerateData gendata = new GenerateData(AppDriver.getDriver());
	public static CharSequence email = gendata.generateEmail(12) ;

	public void assertFreeBrochureUrl(){
		Assert.assertTrue(driver.getCurrentUrl().contains("brochure-download/form"));
		
	}
	
	public FreeBrochurePage populateBrochureForm(){
		try{
			List<WebElement> checkbox = driver.findElements(By.className("form-checkbox"));
				((WebElement) checkbox.get(1)).click();
		
				Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id^='edit-submitted-country']"), 2);
		}
		catch(Exception e){
			
		}
		
		driver.findElement(By.cssSelector("input[id^='edit-submitted-firstname'")).sendKeys(propReader.readProperty("firstname"));
		driver.findElement(By.cssSelector("input[id^='edit-submitted-lastname'")).sendKeys(propReader.readProperty("lastname"));
		driver.findElement(By.cssSelector("input[id^='edit-submitted-email'")).sendKeys(email);
		driver.findElement(By.cssSelector("input[id^='edit-submitted-phone'")).sendKeys(propReader.readProperty("phone"));
		
		try{
		Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id^='edit-submitted-study-where']"), 2);
		}
		catch(Exception e){
			
		}
	
		try{	
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id^='edit-submitted-country']"), 2);
		}
		catch(Exception e){

		}
		
		try{
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id^='edit-submitted-nationality']"), 3);
		}
		catch(Exception e){
			
		}
		return this;
	}
	
	public FreeBrochurePage checkIfCheckboxIsSelected(){
		WebElement checkbx = driver.findElement(By.cssSelector("input[id^='edit-submitted-subscribe-to-promotions']"));
		
		if(!checkbx.isSelected()){
			checkbx.click();
			System.out.println("Checkbox is already selected");
		}
		else{
			System.out.println("Checkbox is checked");
		}
		
		return this;
	}
	
	public BrochureDownloadConfirmationPage clickGetMyFreeBrochure(){
		driver.findElement(By.cssSelector(".webform-submit")).click();
		
		return new BrochureDownloadConfirmationPage(driver);
	}
	
}
