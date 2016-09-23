package com.ekapiww.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.ekapiww.utils.AppVariables;

public class AgentConfirmationPage {

	private WebDriver driver;

	public AgentConfirmationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void assertConfirmationPage(){
		if(driver.getCurrentUrl().contains("spa")){
		Assert.assertTrue(driver.getCurrentUrl() + " Failed confirmation page", driver.getPageSource().contains("Thank you. Your response has been processed successfully."));
		}
		else{
			Assert.assertTrue(driver.getCurrentUrl() + " Failed confirmation page", driver.getPageSource().contains("page-node-2115"));
		}
	}
	
	public void assertSpanishPage(){
		if(driver.getCurrentUrl().contains("spa")){
			Assert.assertTrue(driver.getCurrentUrl() + " Failed confirmation page", driver.getPageSource().contains("Thank you. Your response has been processed successfully."));
			}
	}

}
