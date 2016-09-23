package com.ekapiww.pageobjects.Schools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SchoolSearchResultsPage {
	private WebDriver driver = null;
	
	public SchoolSearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectSchool() {
		String schoolListXpath = ".//*[@id='search-result']/div[3]/div/div/div[2]/div/div";
		List<WebElement> searchResults = driver.findElements(By.xpath(schoolListXpath));
		
		if(searchResults.size() > 0) {
			driver.findElement(By.xpath(".//*[@id='search-result']/div[3]/div/div/div[2]/div/div[1]/div[3]/a")).click();
		}
		else {
			Assert.fail("No Schools found for this search");
		}
	}
	
	public void isQuoteDetailsPageDisplayed() {
		Assert.assertTrue("Quote Details Page not found", 
				driver.findElement(By.cssSelector("div.breadcrumb")).getText().contains("Quote details"));
	}
	
	public void hasCheapestCourseSelected() {
		String coursePriceListXpath = ".//*[@id='section-course']/div[2]/div/div/div/div[2]/table/tbody/tr[@class='extra-row']";
		List<WebElement> coursePriceList = driver.findElements(By.xpath(coursePriceListXpath));
		if(coursePriceList.size() > 1) {
			List<PriceMap> priceList = new ArrayList<PriceMap>(coursePriceList.size());
			
			for(int i = 1; i < coursePriceList.size() + 1; i++) {
				String priceXpath = coursePriceListXpath + "[" + i + "]/td/div/div[2]"; 
				String price = driver.findElement(By.xpath(priceXpath)).getText();
				String selectXpath = coursePriceListXpath + "[" + i + "]/td/form/div/button";
				WebElement selectButton = driver.findElement(By.xpath(selectXpath));
				priceList.add(this.new PriceMap(i, price, selectButton));
			}
			
			Collections.sort(priceList);
			Assert.assertTrue("The cheapest course is not selected by default.", 
					priceList.get(0).getElement().getAttribute("class").contains("selected")); 
		}
		else {
			WebElement selectElement = driver.findElement(By.xpath(coursePriceListXpath + "/td/form/div/button"));
			Assert.assertTrue("The cheapest course is not selected by default.", 
					selectElement.getAttribute("class").contains("selected")); 

		}
	}

	public void selectDifferentCourse() {
		String coursePriceListXpath = ".//*[@id='section-course']/div[2]/div/div/div/div[2]/table/tbody/tr[@class='extra-row']";
		List<WebElement> coursePriceList = driver.findElements(By.xpath(coursePriceListXpath));
		if(coursePriceList.size() > 1) {
			List<PriceMap> priceList = new ArrayList<PriceMap>(coursePriceList.size());
			
			for(int i = 1; i < coursePriceList.size() + 1; i++) {
				String priceXpath = coursePriceListXpath + "[" + i + "]/td/div/div[2]"; 
				String price = driver.findElement(By.xpath(priceXpath)).getText();
				String selectXpath = coursePriceListXpath + "[" + i + "]/td/form/div/button";
				WebElement selectButton = driver.findElement(By.xpath(selectXpath));
				priceList.add(this.new PriceMap(i, price, selectButton));
			}
			
			Collections.sort(priceList);
			priceList.get(1).getElement().click();
			int index = priceList.get(1).getElementIndex();
			//Explicit wait after clicking Select button
			String xpathExpression = ".//*[@id='section-course']/div[2]/div/div/div/div[2]/table/tbody/tr[@class='extra-row']["
					+ index + "]/td/form/div/button";
			waitUntilSelected(xpathExpression);
		}
	}
	
	public void hasAccomodationSelected() {
		String selectXPath = ".//*[@id='section-accommodation']/div[2]/div[1]/div/div/div/div[1]/div/div/div[2]/div[2]/span/form/div/button";
		Assert.assertTrue("Accomodation is not selected by default", 
				driver.findElement(By.xpath(selectXPath)).getAttribute("class").contains("selected"));
	}
	
	public void selectDiffferentAccomodation() {
		String selectListXPath = ".//*[@id='section-accommodation']/div[2]/div[1]/div/div/div/div/div/div/div[2]/div[2]";
		List<WebElement> selectList = driver.findElements(By.xpath(selectListXPath));
		
		if(selectList.size() > 1) {
			String xpathExpr = ".//*[@id='section-accommodation']/div[2]/div[1]/div/div/div/div[2]/div/div/div[2]/div[2]/span/form/div/button";
			driver.findElement(By.xpath(xpathExpr)).click();
			waitUntilSelected(xpathExpr);
		}
	}

	public void selectTransfer() {
		List<WebElement> selectTransfer = driver.findElements(By.xpath(
				".//*[@id='section-transfer']/div[2]/div/div/div/div[1]/div/div/div/div[2]/div[2]/span/form/div/button"));
		int index;
		if(selectTransfer.size() > 1) {
			index = new Random().nextInt(selectTransfer.size());
		}
		else {
			index = 0;
		}
		selectTransfer.get(index).click();
		String xpathExpr = ".//*[@id='section-transfer']/div[2]/div/div/div/div[1]/div[" 
							+ (index + 1)
							+ "]/div/div/div[2]/div[2]/span/form/div/button";
		waitUntilSelected(xpathExpr);
	}
	
	public void selectInsurance() {
		List<WebElement> selectInsurance = driver.findElements(By.xpath(
				".//*[@id='section-insurance']/div[2]/div/div/div/div[1]/div/div/div/div[2]/div[2]/span/form/div/button"));
		int index;
		if(selectInsurance.size() > 1) {
			index = new Random().nextInt(selectInsurance.size());
			selectInsurance.get(index).click();
		}
		else {
			index = 0;
		}
		selectInsurance.get(index).click();
		String xpathExpr = ".//*[@id='section-insurance']/div[2]/div/div/div/div[1]/div/div/div[" 
							+ (index + 1) + "]/div[2]/div[2]/span/form/div/button";
		waitUntilSelected(xpathExpr);
		
	}

	public void verifyTheCartWithQuote() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String quoteTotalPrice = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath(".//*[@id='section-quote-details-footer']/div/div/div/div[1]/div/span[2]"))).getText(); 
				
		String cartTotalPrice = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath(".//*[@id='block-system-main']/div/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/span[2]")))
				.getText();
				
		Assert.assertTrue("Quote total price is different is basket", quoteTotalPrice.equals(cartTotalPrice));
	}
	
	public SchoolReservationStudentDetailsPage reserveThePlace() {
		driver.findElement(By.xpath(".//*[@id='section-quote-details-footer']/div/div/div/a")).click();
		
		return new SchoolReservationStudentDetailsPage(driver);
	}
	
	private void waitUntilSelected(final String expression) {
		
		new WebDriverWait(driver, 30)
			.ignoring(StaleElementReferenceException.class)
			.until(new ExpectedCondition<Boolean>() {
			
		public Boolean apply(WebDriver driver) {
			return driver.findElement(By.xpath(expression)).getAttribute("class").contains("selected");
		}
	});
		
	}

	private class PriceMap implements Comparable<PriceMap> {
		private int elementIndex;
		private String price;
		private WebElement element;
		
		public PriceMap(int elementIndex, String price, WebElement element) {
			this.elementIndex = elementIndex;
			 this.price = price;
			 this.element = element;
		}

		public int getElementIndex() {
			return elementIndex;
		}

		public String getPrice() {
			return price;
		}

		public WebElement getElement() {
			return element;
		}

		public int compareTo(PriceMap o) {
			return price.compareTo(o.price);
		}
		
		@Override
		public String toString() {
			    return "index=" + getElementIndex() + ", price=" + getPrice() + ", element = " + getElement();
		}
		
	}
}
