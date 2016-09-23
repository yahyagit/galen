package com.ekapiww.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitySchoolPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public CitySchoolPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	public float getCoursePrice(String courseCode) {
		String price = wait.until(
								ExpectedConditions.presenceOfElementLocated(
										By.cssSelector("#"+courseCode+" .placeholder")))
								.getText();
		
		price = removeCurrency(price);
		return Float.valueOf(price);
	}

	private String removeCurrency(String price) {
		if (price.contains("£")) {
			price = price.substring(1);
		}
		if (price.contains("$")) {
			price = price.substring(1);
		}
		if (price.contains("€")) {
			price = price.replace("€", "");
			price = price.replace(",", ".");		
		}
		if (price.contains("AUD")) {
			price = price.replace("AUD", "");
		}	
		if (price.contains("NZD")) {
			price = price.replace("NZD", "");
		}
		
		return price;
	}


}
