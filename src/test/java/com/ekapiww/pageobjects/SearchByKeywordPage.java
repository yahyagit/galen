package com.ekapiww.pageobjects;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ekapiww.utils.Utils;

public class SearchByKeywordPage {
	private WebDriver driver;
	private String searchPopupHandle;
	private WebElement searchKeyword;

	public SearchByKeywordPage (WebDriver driver){
		this.driver=driver;
	}

	public HeaderSection assertSearchIsPresent() throws InterruptedException{
		searchPopupHandle= driver.getWindowHandle();
		Boolean searchPopup=Utils.isElementPresent(driver, By.id("edit-term"));
		Assert.assertTrue(searchPopup);
		TimeUnit.SECONDS.sleep(3);
		//driver.navigate().back();
		return new HeaderSection(driver);
	}

	public void enterKeyword(String keyword) throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		driver.switchTo().window(searchPopupHandle);
		Boolean searchBoxPresent=Utils.isElementPresent(driver,By.cssSelector("#edit-term"));
		Assert.assertTrue(searchBoxPresent);
		if(searchBoxPresent){
			WebElement searchKeyword=driver.findElement(By.cssSelector("#edit-term"));
			searchKeyword.sendKeys(keyword,Keys.ENTER);
		}
	}

	public void enterInvalidKeyword(String keyword) throws InterruptedException {
		driver.switchTo().window(searchPopupHandle);
		Boolean searchBoxPresent=Utils.isElementPresent(driver,By.cssSelector("#edit-term"));
		Assert.assertTrue(searchBoxPresent);
		if(searchBoxPresent){
			WebElement searchKeyword=driver.findElement(By.cssSelector("#edit-term"));
			searchKeyword.sendKeys(keyword,Keys.ENTER);
		}
	}

	public void verifyResult() throws InterruptedException{
		TimeUnit.SECONDS.sleep(3);
		String keyword=driver.findElement(By.id("edit-keys")).getAttribute("value");
		WebElement searchResult =driver.findElement(By.cssSelector(".search-result .title>a"));
		String topResult=searchResult.getText().toLowerCase();
		Assert.assertTrue("Text not found ====> "+(keyword),topResult.contains(keyword.toLowerCase()));
		System.out.println(keyword +" Keyword is present");
		driver.navigate().back();
	}

	public void noResultsPage() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		//Boolean noResultsPage=Utils.isElementPresent(driver, By.xpath("html/body/div[1]/section/div[4]/section/div/ul/li[1]"));
		Assert.assertTrue("Invalid Results Page not found",driver.getPageSource().contains("Check if your spelling is correct, or try removing filters."));
		driver.navigate().back();
	}
}