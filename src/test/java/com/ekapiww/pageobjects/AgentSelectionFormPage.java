package com.ekapiww.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ekapiww.utils.PropertyReader;
import com.ekapiww.utils.Utils;

public class AgentSelectionFormPage {

	private WebDriver driver;
	private PropertyReader propReader = new PropertyReader("/com/ekapiww/properties/testdata.properties");

	public AgentSelectionFormPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public AgentSelectionFormPage populateAgentFormForPortuguese(){
		driver.findElement(By.id("tfa_1")).sendKeys(propReader.readProperty("firstname"));
		driver.findElement(By.id("tfa_2")).sendKeys(propReader.readProperty("lastname"));
		driver.findElement(By.id("tfa_12")).sendKeys(propReader.readProperty("email"));
		driver.findElement(By.id("tfa_11")).sendKeys(propReader.readProperty("phone"));
		
		
		Utils.selectFromDropDownByIndex(driver, By.id("tfa_74"), 2);
		
		try{
			Utils.selectFromDropDownByIndex(driver, By.id("tfa_156"), 2);
			
		}catch(Exception e){
		
		}
		
		Utils.selectFromDropDownByIndex(driver, By.id("tfa_81"), 2);
		Utils.selectFromDropDownByIndex(driver, By.id("tfa_90"), 2);
		
		
//		driver.findElement(By.id("tfa_97")).clear();
//		driver.findElement(By.id("tfa_97")).sendKeys(propReader.readProperty("DOB"));
//		driver.findElement(By.cssSelector("#tfa_143")).click();
//		
//		
//		WebElement startDate = driver.findElement(By.id("tfa_90"));
//		startDate.sendKeys(propReader.readProperty("courseStartDate"));
		
		driver.findElement(By.id("tfa_56")).sendKeys(propReader.readProperty("comments"));
				
		return new AgentSelectionFormPage(driver);
	}
	
	public AgentSelectionFormPage populateAgentFormForSpanish(){
		driver.findElement(By.id("tfa_1")).sendKeys(propReader.readProperty("firstname"));
		driver.findElement(By.id("tfa_2")).sendKeys(propReader.readProperty("lastname"));
		driver.findElement(By.id("tfa_4")).sendKeys(propReader.readProperty("streetAddress"));
		driver.findElement(By.id("tfa_3")).sendKeys(propReader.readProperty("city"));
		driver.findElement(By.id("tfa_12")).sendKeys(propReader.readProperty("email"));
		driver.findElement(By.id("tfa_11")).sendKeys(propReader.readProperty("phone"));
		driver.findElement(By.id("tfa_5")).sendKeys(propReader.readProperty("nationality"));
		
		
		Utils.selectFromDropDownByIndex(driver, By.id("tfa_30"), 2);
		Utils.selectFromDropDownByIndex(driver, By.id("tfa_13"), 2);
		
		driver.findElement(By.id("tfa_56")).sendKeys(propReader.readProperty("comments"));
				
		return new AgentSelectionFormPage(driver);
	}
	public void checkingChkBoxIsSelected(String chkBoxID){
		boolean checkStatus;
		WebElement checkBx1 = driver.findElement(By.id(chkBoxID));
		checkStatus=(checkBx1).isSelected();
		
		if(checkStatus==true){
			System.out.println("Checkbox is already selected");
		}
		else{
			((WebElement) checkBx1).click();
			System.out.println("Checkbox is checked");
		}
		
	}
	
	public AgentConfirmationPage clickSubmit(){
		driver.findElement(By.cssSelector(".primaryAction")).click();
		
		return new AgentConfirmationPage(driver);
	}
	
	
	
	

}
