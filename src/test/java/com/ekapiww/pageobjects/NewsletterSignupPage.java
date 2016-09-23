package com.ekapiww.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ekapiww.utils.PropertyReader;
import com.ekapiww.utils.Utils;
import org.junit.Assert;


public class NewsletterSignupPage {

	private WebDriver driver;
	private PropertyReader propReader = new PropertyReader("/com/ekapiww/properties/testdata.properties");

	public NewsletterSignupPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void assertNewsletterSignupPage(){
		Assert.assertTrue(driver.getCurrentUrl().contains("newsletter-signup"));
	}
	
		
	public NewsletterSignupPage enterFirstName(){
		driver.findElement(By.cssSelector("[id^='edit-submitted-firstname']")).sendKeys(propReader.readProperty("firstname"));
		
		return this;
	}
	
	public NewsletterSignupPage enterLastName(){
		driver.findElement(By.cssSelector("[id^='edit-submitted-lastname'")).sendKeys(propReader.readProperty("lastname"));
		
		return this;
	}
	
	public NewsletterSignupPage selectCountry(){
		try{
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("[id^='edit-submitted-country'"), 3);
			Utils.selectFromDropDownByIndex(driver, By.cssSelector("[id^='edit-submitted-nationality']"), 2);
		}
		catch(Exception e){
		}
		
		return this;
	}
	
	public void enterDataOnHoneypotField(){
		
		((JavascriptExecutor)driver).executeScript("document.getElementById('edit-homepage').value=('TEST')");
				
	}	
	
	
	public NewsletterSignupConfirmationPage clickKeepMeUpdate(){
		driver.findElement(By.cssSelector(".webform-submit")).click();
		
		return new NewsletterSignupConfirmationPage(driver);
	}
	
	public void verifyEmail(){
		String emailPopulated = driver.findElement(By.cssSelector("[id^='edit-submitted-email'")).getAttribute("value");
		String emailPopulatedOnHomepage = get(FooterSection.email);
				
		Assert.assertEquals(driver.getCurrentUrl() + " Email is not pre-populated.",emailPopulatedOnHomepage, emailPopulated);
	}

	
	private String get(CharSequence email) {
		
		return (String) email;
	}
	
	public void assertHoneyhotFailtureMessage(){
		WebElement honeypot = driver.findElement(By.cssSelector(".alert-block"));
		Assert.assertTrue(driver.getCurrentUrl() + " Honeypot is not active", honeypot.isDisplayed());
		System.out.println(driver.getCurrentUrl() + honeypot.getText());
		
	}
	
	
}
