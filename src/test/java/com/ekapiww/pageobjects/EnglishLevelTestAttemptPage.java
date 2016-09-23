package com.ekapiww.pageobjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class EnglishLevelTestAttemptPage {
	private WebDriver driver;
	
	public EnglishLevelTestAttemptPage(WebDriver driver) {
		this.driver = driver;
	}

	public void takeTest() throws InterruptedException {
		//driver.get("http://englishtest.kaplaninternational.com/quiz/English%20Level%20Test/1?UserCulture=en");
	
		
		driver.findElement(By.xpath("//input[@type='radio' and @value='2']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='8']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='15']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='16']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='21']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='28']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='35']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='36']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='41']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='46']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='56']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='63']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='70']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='72']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='80']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='84']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='87']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='91']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='99']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='105']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='108']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='113']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='119']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='124']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='129']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='133']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='139']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='145']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='146']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='152']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='157']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='162']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='167']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='173']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='54']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='177']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='184']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='191']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='194']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='198']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='206']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='209']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='214']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='219']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='225']")).click();
		driver.findElement(By.className("NextButton")).click();

		driver.findElement(By.xpath("//input[@type='radio' and @value='228']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='231']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='233']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='237']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @value='240']")).click();
		driver.findElement(By.className("NextButton")).sendKeys(Keys.ENTER);

	}

	public void assertResultPage() {
		String pageTitle = driver.getTitle();
		Assert.assertTrue(driver.getCurrentUrl() + " Not on result page", pageTitle.contains("Result"));		
	}

}
