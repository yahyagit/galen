package com.ekapiww.pageobjects.AboutKaplan;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.ekapiww.pageobjects.HeaderSection;

public class USAandCanadaCareerPage {

	private WebDriver driver;

	public USAandCanadaCareerPage(WebDriver driver) {
		this.driver=driver;
	}
	public HeaderSection assertUSAandCanadaCareerPage(){
		Assert.assertEquals("Join Our Team - Kaplan Inc.", driver.getTitle());
	
		driver.navigate().back();
		return new HeaderSection(driver);
	}

}
