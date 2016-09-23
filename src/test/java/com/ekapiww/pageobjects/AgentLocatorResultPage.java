package com.ekapiww.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ekapiww.utils.Utils;

public class AgentLocatorResultPage {

	private WebDriver driver;

	public AgentLocatorResultPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void assertAgentLocatorPage(){
		Utils.waitForElementPresence(driver, By.cssSelector("#agntloca > h2:nth-child(2)"), 10);
		boolean agentLocatorResult = Utils.isElementPresent(driver, By.cssSelector("#agntloca > h2:nth-child(2)"));
		Assert.assertTrue(driver.getCurrentUrl() + " Agent Locator result page not found", agentLocatorResult);
	
	}
	
	public AgentLocatorResultPage selectCity(String city) throws InterruptedException{
		TimeUnit.SECONDS.sleep(3);
		driver.findElement(By.id("Region")).clear();
		driver.findElement(By.id("Region")).sendKeys(city);
			
		return this;
	}
	
	public AgentLocatorResultPage selectSchool(String school) throws InterruptedException{
		driver.findElement(By.id("School")).clear();
		driver.findElement(By.id("School")).sendKeys(school);
				
		return this;
	}
	
	public AgentLocatorResultPage clickSearch(){
		driver.findElement(By.id("search")).click();
		
		return this;
	}
	
	
	public void assertResultForBR(String msg1, String msg2) throws InterruptedException{
		if (msg1.contains("Three agents"))
			{
			 	List<WebElement> agent = driver.findElements(By.cssSelector("div#content.content div#agntloca div#agentsResults div.result div div.resultlist"));
				Assert.assertTrue(agent.size() >= 3);
				
			}
		else{
			TimeUnit.SECONDS.sleep(7);
			String errorMsg1 = driver.findElement(By.cssSelector("#search-form-validation > ul:nth-child(1) > li:nth-child(1)")).getText();
						
			Assert.assertTrue(errorMsg1.contains(msg1));
			
				if(msg2.contains("escola"))
				{	
					String errorMsg2 = driver.findElement(By.cssSelector("#search-form-validation > ul:nth-child(1) > li:nth-child(2)")).getText();
					
					Assert.assertTrue(errorMsg2.contains(msg2));
				}

			}
	}
	
	public void assertResultForSPA(String msg1, String msg2) throws InterruptedException{
		if (msg1.contains("Three agents"))
		{
			TimeUnit.SECONDS.sleep(3);
			List<WebElement> noOfAgent = driver.findElements(By.className("resultlist"));
			
			Assert.assertTrue(noOfAgent.size() <=3);

		}
		else{
			TimeUnit.SECONDS.sleep(5);
			String errorMsg1 = driver.findElement(By.cssSelector("#search-form-validation > ul:nth-child(1) > li:nth-child(1)")).getText();
				
			Assert.assertTrue(errorMsg1.contains(msg1));
			
				if(msg2.contains("centro"))
				{	
					String errorMsg2 = driver.findElement(By.cssSelector("#search-form-validation > ul:nth-child(1) > li:nth-child(2)")).getText();
					
					Assert.assertTrue(errorMsg2.contains(msg2));
				}
				
		}
			
	}
	
	public AgentSelectionFormPage selectAgent(String agent) throws InterruptedException{
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.id(agent)).click();

		return new AgentSelectionFormPage(driver);		

	}
	
//	public AgentSelectionFormPage selectAgent(){
//		driver.findElement(By.id("CI - Central De Intercâmbio")).click();
//
//		
//		return new AgentSelectionFormPage(driver);
//		
//	}

}
