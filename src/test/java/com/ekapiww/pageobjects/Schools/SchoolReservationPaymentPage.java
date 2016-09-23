package com.ekapiww.pageobjects.Schools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.ekapiww.utils.PropertyReader;

public class SchoolReservationPaymentPage {
	private WebDriver driver;
	private PropertyReader propReader = new PropertyReader("/testdata.properties");
	
	public SchoolReservationPaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SchoolReservationConfirmationPage enterPaymentDetails() {
		new Select(driver.findElement(By.id("edit-cardtype"))).selectByVisibleText(
				propReader.readProperty("cardType"));
		
		driver.switchTo().frame(driver.findElement(By.className("payframe")));
		
		driver.findElement(By.id("cardNoInput")).sendKeys(propReader.readProperty("cardNumber"));
		new Select(driver.findElement(By.name("cardExp.month"))).selectByVisibleText(
				propReader.readProperty("cardExpMonth"));
		new Select(driver.findElement(By.name("cardExp.year"))).selectByVisibleText(
				propReader.readProperty("cardExpYear"));
		
		driver.findElement(By.id("name")).sendKeys(propReader.readProperty("cardholderName"));
		
		driver.findElement(By.xpath(".//*[@for='op-PMMakePayment']/nobr/span")).click();
		
		driver.findElement(By.name("continue")).click();
		
		driver.switchTo().defaultContent();
		
		return new SchoolReservationConfirmationPage(driver);
	}
	
	
}
