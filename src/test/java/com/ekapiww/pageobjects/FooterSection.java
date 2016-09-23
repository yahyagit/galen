package com.ekapiww.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ekapiww.dataobjects.GenerateData;
import com.ekapiww.utils.AppDriver;
import com.ekapiww.utils.PropertyReader;

public class FooterSection {
	
	private WebDriver driver;
//	private PropertyReader propReader = new PropertyReader("/com/ekapiww/properties/testdata.properties");
	
	private static GenerateData gendata = new GenerateData(AppDriver.getDriver());
	public static CharSequence email = gendata.generateEmail(12) ;

	public FooterSection(WebDriver driver){
		this.driver=driver;
	}
	
	public FooterSection enterEmail(){
		driver.findElement(By.id("edit-email")).sendKeys(email);
		
		return this;
	}
	
	public NewsletterSignupPage clickSignUp(){
		driver.findElement(By.cssSelector(".container-inline > button:nth-child(2)")).click();
		
		return new NewsletterSignupPage(driver);
	}
	

}
