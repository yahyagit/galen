package com.ekapiww.pageobjects.Schools;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ekapiww.utils.PropertyReader;

public class SchoolReservationStudentDetailsPage {
	private WebDriver driver = null;
	private PropertyReader propReader = new PropertyReader("/testdata.properties");
	
	public SchoolReservationStudentDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterStudentDetails() {
		driver.findElement(By.id("edit-first-name")).sendKeys(
				propReader.readProperty("firstname"));
		
		driver.findElement(By.id("edit-last-name")).sendKeys(
				propReader.readProperty("lastname"));
		
		String genderListXpath = ".//*[@id='edit-gender']/div";
		List<WebElement> genderList = driver.findElements(By.xpath(genderListXpath));
		for(int i = 0; i < genderList.size(); i++) {
			String genderXpath = genderListXpath + "[" + (i +1) + "]";
			if(driver.findElement(By.xpath(genderXpath + "/label"))
					.getText()
					.trim()
					.equalsIgnoreCase(propReader.readProperty("gender"))) {
				driver.findElement(By.xpath(genderXpath + "/input")).click();
			}
		}
		
		new Select(driver.findElement(By.id("edit-date-of-birth-day"))).selectByVisibleText(
				propReader.readProperty("dob_day"));
		new Select(driver.findElement(By.id("edit-date-of-birth-month"))).selectByVisibleText(
				propReader.readProperty("dob_month"));
		new Select(driver.findElement(By.id("edit-date-of-birth-year"))).selectByVisibleText(
				propReader.readProperty("dob_year"));
		
		new Select(driver.findElement(By.id("edit-nationality"))).selectByVisibleText(
				propReader.readProperty("nationality"));
		
		driver.findElement(By.id("edit-address-1")).sendKeys(
				propReader.readProperty("addr1"));
		
		driver.findElement(By.id("edit-city")).sendKeys(
				propReader.readProperty("city"));
		
		driver.findElement(By.id("edit-county")).sendKeys(
				propReader.readProperty("county"));
		
		new Select(driver.findElement(By.id("edit-country"))).selectByVisibleText(
				propReader.readProperty("country"));
		
		driver.findElement(By.id("edit-postcode")).sendKeys(
				propReader.readProperty("postcode"));
		
		driver.findElement(By.id("edit-phone")).sendKeys(
				propReader.readProperty("phone"));
		
		driver.findElement(By.id("edit-personal-email")).sendKeys(
				propReader.readProperty("email"));
		
		driver.findElement(By.id("edit-confirm-personal-email")).sendKeys(
				propReader.readProperty("confirm_email"));
	}
	
	public void selectPaymentOption() {
		List<WebElement> paymentOptions = driver.findElements(By.name("payment_options"));
		
		for(WebElement e : paymentOptions) {
			if(e.getAttribute("value").equalsIgnoreCase(
					propReader.readProperty("paymentOption"))) {
				e.click();
			}
		}
	}
	
	public void agreeTheTerms() {
		driver.findElement(By.id("edit-tcs")).click();
	}
	
	public SchoolReservationPaymentPage ClickPayNowByCard() {
		driver.findElement(By.id("edit-continue")).click();
		
		return new SchoolReservationPaymentPage(driver);
	}
}
