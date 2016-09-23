package com.ekapiww.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class GetQuotePage {

	private WebDriver driver;

	public GetQuotePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void assertGetQuoteUrl(){
		Assert.assertTrue(driver.getCurrentUrl().contains("bookings.kaplaninternational.com"));
	}

}
