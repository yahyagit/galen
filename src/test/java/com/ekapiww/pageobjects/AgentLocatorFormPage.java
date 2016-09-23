package com.ekapiww.pageobjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ekapiww.utils.Utils;


public class AgentLocatorFormPage {

	private WebDriver driver;
	
	
	public AgentLocatorFormPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void assertAgentLocatorFormPage(){
		Assert.assertTrue(driver.getCurrentUrl() + " Agent Locator page is missing", driver.getPageSource().contains("page-agent-locator"));
	}

	public void selectOptionforFirstQuestion(int index){
		Utils.waitForElementPresence(driver, By.cssSelector("select[id*='question1']"), 10);
		Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id*='question1']"), index);
	}
		
	public AgentLocatorFormPage selectThirdOptionForFirstQuestion(){
		Utils.waitForElementPresence(driver, By.cssSelector("select[id*='question1']"), 10);
		Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id*='question1']"), 3);	
		
		return this;
	}
	
	
	public AgentLocatorFormPage selectOptionForSecondQuestion(){
		WebElement place = driver.findElement(By.cssSelector("div[id*='question2']"));
		new Actions(driver).moveToElement(place).click().sendKeys(Keys.DOWN,"sau", Keys.DOWN, Keys.DOWN).perform();
		return this;
	}
	
	public void selectDateForThirdQuestion(){
			driver.findElement(By.cssSelector("input[id*='question3']")).click();
			String date1 = courseStartDate();
			driver.findElement(By.cssSelector("input[id*='question3']")).sendKeys(date1);
		
	}
	
	
	public AgentLocatorFormPage selectOptionForForthQuestion(){
		Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id*='question4']"), 2);
		
		return this;
		
	}
	
	public AgentLocatorFormPage selectYesOptionForFifthQuestion(){
		Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id*='question5']"), 1);
		
		return this;
	}
	
	public AgentLocatorFormPage selectOptionforFifthQuestion(int index){
		Utils.selectFromDropDownByIndex(driver, By.cssSelector("select[id*='question5']"), index);
		
		return this;
	}
	
		
	public AgentLocatorResultPage clickOnEnviarForAgentLocator(){
		driver.findElement(By.cssSelector("#edit-send")).click();
					
		return new AgentLocatorResultPage(driver);
	}
	
	public ContactUsPage clickOnEnviarForContactUs(){
		driver.findElement(By.cssSelector("#edit-send")).click();
		
		return new ContactUsPage(driver);
	}
	
		
	public static String courseStartDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar today = Calendar.getInstance();
        today.setTime(new Date()); 
        today.add(Calendar.DATE, 30); 
        String courseStartDate = dateFormat.format(today.getTime());
       
        return courseStartDate;
        }
		
}
