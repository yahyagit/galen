package com.ekapiww.pageobjects;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ekapiww.pageobjects.cms.ConfigCountryLayoutPage;
import com.ekapiww.utils.AppVariables;

public class DestinationsHubPage {
	String cmsAdminWindowHandle;
	String userWindowHandle;
	
	private WebDriver driver;
		
	public DestinationsHubPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	
	public void newWindowDestinationsHubPage() {
		String destinationUrl = AppVariables.APP_ADMIN_URL+"destinations?sdfjsn";
		
		
		Set<String> windows = driver.getWindowHandles();
		this.cmsAdminWindowHandle = driver.getWindowHandle();
		
//		Actions newWindow = new Actions(driver);
//	    newWindow.sendKeys(Keys.CONTROL + "n").perform();

		((JavascriptExecutor)driver).executeScript("window.open();");
		Set<String> customerWindow = driver.getWindowHandles();
		
		customerWindow.removeAll(windows);
		this.userWindowHandle =((String)customerWindow.toArray()[0]);	
	    
		driver.switchTo().window(userWindowHandle);
		
		System.out.println(AppVariables.APP_ADMIN_URL);
		
		driver.navigate().to(destinationUrl);	
		
	}
	
	public void assertCountryShuffle() throws Throwable {
		Thread.sleep(5000);
		WebElement countryName = driver.findElement(By.cssSelector("#destinations-row-1 > div:nth-child(1) > div  > div"));
		String countryNameID = countryName.getAttribute("id");
		System.out.println(countryNameID);
		Assert.assertTrue(countryNameID.equals(ConfigCountryLayoutPage.secondCountryNameID));
		
		WebElement countryName2 = driver.findElement(By.cssSelector("#destinations-row-1 > div:nth-child(2) > div > div"));
		String countryNameID2 = countryName2.getAttribute("id");
		System.out.println(countryNameID2);
		Assert.assertTrue(countryNameID2.equals(ConfigCountryLayoutPage.firstCountryNameID));
	}

	public void switchToAdminWindow() {
		driver.switchTo().window(cmsAdminWindowHandle);	
	}
}
