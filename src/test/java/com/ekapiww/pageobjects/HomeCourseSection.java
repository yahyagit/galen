package com.ekapiww.pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekapiww.pageobjects.EnglishCourses.FreeEnglishTestPage;
import com.ekapiww.pageobjects.cms.CmsHomeCourseSection;
import com.ekapiww.utils.AppVariables;
import com.ekapiww.utils.Utils;

public class HomeCourseSection {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	public HomeCourseSection(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		this.action = new Actions(driver);
	}

	public CmsHomeCourseSection assertCourseOrder() {
		
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".course-type-558.position-1"));	   	
		Assert.assertTrue(driver.getCurrentUrl() + " Exam Preparation Courses is not at correct position", elementOnPage);
		
		elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".course-type-557.position-2"));	   	
		Assert.assertTrue(driver.getCurrentUrl() + " Flexible English is not at correct position", elementOnPage);
		
		elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".course-type-560.position-3"));	   	
		Assert.assertTrue(driver.getCurrentUrl() + " Business English Courses is not at correct position", elementOnPage);
		
		elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".course-type-561.position-4"));	   	
		Assert.assertTrue(driver.getCurrentUrl() + " Work amd Study programs is not  at correct position", elementOnPage);
		
		elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".course-type-559.position-5"));	   	
		Assert.assertTrue(driver.getCurrentUrl() + " Long term courses is not at correct position", elementOnPage);
		
		return new CmsHomeCourseSection(driver);
	}

	public void assertEnglishCourseIntroIsPresent() {
		Boolean englishIntroOnPage = Utils.isElementPresent(driver,By.cssSelector(".section-intro.english-intro"));
		Assert.assertTrue(driver.getCurrentUrl() + " English Course Intro is not present on hompage", englishIntroOnPage);	
	}
	
	
	/** Assert English course intro section has content
	 * 
	 */
	public void assertCourseIntroTextIsPresent() {
		Boolean titleOnPage = Utils.isElementPresent(driver,By.cssSelector(".section-intro.english-intro .title-container"));
		Assert.assertTrue(driver.getCurrentUrl() + " English Course Intro Title is not present on hompage", titleOnPage);
		
		Boolean descriptionOnPage = Utils.isElementPresent(driver,By.cssSelector(".section-intro.english-intro .desc-container"));
		Assert.assertTrue(driver.getCurrentUrl() + " English Course Intro Description is not present on hompage", descriptionOnPage);
	}

	/** Assert English course intro has 3 CTA's
	 * 	
	 */
	public void assertThreeCTAIsPresent() {
		Boolean ctaOnPage = Utils.isElementPresent(driver,By.cssSelector(".section-intro.english-intro .cta-container"));
		Assert.assertTrue(driver.getCurrentUrl() + " English Course Intro CTAs are not present on hompage", ctaOnPage);
		
		if(ctaOnPage) {
			 List<WebElement> ctas = driver.findElements(By.cssSelector(".section-intro.english-intro .cta-container a"));
			 Assert.assertTrue(driver.getCurrentUrl() + " 3 CTA's not present on English course intro", ctas.size() == 3);
		}
	}
	
	/** Assert English course type section is present
	 * 
	 */
	public void assertEnglishCourseTypeSectionPresent() {
		Boolean englishCourseTypeOnPage = Utils.isElementPresent(driver,By.cssSelector(".pane-kis-pages-feature-kis-home-english-adults"));
		Assert.assertTrue(driver.getCurrentUrl() + " English Course Type Section is not present on hompage", englishCourseTypeOnPage);	
	}

	/** Assert first panel is present in English course type section
	 * 
	 */
	public void assertECTFirstPanelPresent() {
		Boolean firstPanelECTOnPage = Utils.isElementPresent(driver,By.cssSelector(".adult-eng .adult-eng-intro"));
		Assert.assertTrue(driver.getCurrentUrl() + " English Course Type first Panel is not present on hompage", firstPanelECTOnPage);		
	}

	/** Assert first panel in English course type section has content
	 * 
	 */
	public void assertECTFirstPanelContent() {
		Boolean firstPanelECTTitle = Utils.isElementPresent(driver,By.cssSelector(".adult-eng-intro .eng-item-inner .title"));
		Assert.assertTrue(driver.getCurrentUrl() + " Title in first panel for English Course Type is not present on hompage", firstPanelECTTitle);		
		
		Boolean firstPanelECTSubTitle = Utils.isElementPresent(driver,By.cssSelector(".adult-eng-intro .eng-item-inner .sub-title"));
		Assert.assertTrue(driver.getCurrentUrl() + " Title in first panel for English Course Type is not present on hompage", firstPanelECTSubTitle);		

		Boolean firstPanelECTDesc = Utils.isElementPresent(driver,By.cssSelector(".adult-eng-intro .eng-item-inner .desc"));
		Assert.assertTrue(driver.getCurrentUrl() + " Description on first panel for English Course Type first Panel is not present on hompage", firstPanelECTDesc);		
		
		List<WebElement> ctas = driver.findElements(By.cssSelector(".adult-eng-intro .eng-item-inner a.btn"));
		Assert.assertTrue(driver.getCurrentUrl() + " 2 CTA's are not present for first panel in English course type", ctas.size() == 2);
		
	}

	//Click on secondary CTA in first panel
	public void clickFPSecondaryCTA() throws InterruptedException {
		wait.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath(".//*[@id='home-english']/div[3]/div/div/div/div[1]/div/div/div/a[2]"))).sendKeys(Keys.ENTER);	
	}
	
	//Assert CTA Links
	public void assertCTALink(String pageNode) {
		Assert.assertTrue(driver.getPageSource().contains(pageNode));
		driver.navigate().back();
	}

	//Click on primary CTA in first panel
	public FreeEnglishTestPage clickFPPrimaryCTA() {
		if(AppVariables.APP_URL.contains("th")){
			driver.findElement(By.cssSelector("li.expanded:nth-child(1) > a")).click();
			driver.findElement(By.cssSelector("li.expanded:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a")).click();
		}
		else{
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(".//*[@id='home-english']/div[3]/div/div/div/div[1]/div/div/div/a[3]"))).sendKeys(Keys.ENTER);	
		}
		return new FreeEnglishTestPage(driver);
	}

	public void assertCoursePanelsPresent() {
		List<WebElement> coursePanels = driver.findElements(By.cssSelector("#home-english .adult-eng .adult-eng-item"));
		Assert.assertTrue(driver.getCurrentUrl() + " 5 course panels are not present in English course type Section", coursePanels.size() == 5);
	}

	//Assert if course type are present with title, description and link
	public void assertCourseTypePresent(String course, String courseName) {
			Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector("."+course));
			Assert.assertTrue(driver.getCurrentUrl() + " " + courseName+" not present on homepage", elementOnPage);
			
			
			//Check if title is present
			Boolean titleOnPage = Utils.isElementPresent(driver, By.cssSelector("."+course+" .course-title"));
			Assert.assertTrue(driver.getCurrentUrl() + " " + "Title in "+courseName+" not present on homepage", titleOnPage);
			
			//Check Title is not blank
			if(titleOnPage){
				String title = driver.findElement(By.cssSelector("."+course+" .course-title")).getText();
				
				Assert.assertTrue(driver.getCurrentUrl() + " " + courseName+" title is blank", title.length() > 0);
			}
			
			//Mouse over the panel
			action.moveToElement(
					driver.findElement(By.cssSelector("."+course))).build().perform();
						
			//Check if description is present
			Boolean descOnPage = Utils.isElementPresent(driver, By.cssSelector("."+course+" .course-desc"));
			Assert.assertTrue(driver.getCurrentUrl() + " " + "Description in "+courseName+" not present on homepage", descOnPage);
			
			//Check Description is not blank
			if(descOnPage){
				String desc = driver.findElement(By.cssSelector("."+course+" .course-desc")).getText();
				Assert.assertTrue(driver.getCurrentUrl() + " " + courseName+" description is blank", desc.length() > 0);
			}
			
			//Check if link is present
			Boolean linkOnPage = Utils.isElementPresent(driver, By.cssSelector("."+course+" .course-link"));
			Assert.assertTrue(driver.getCurrentUrl() + " " + "Link in "+courseName+" not present on homepage", linkOnPage);
			
			//Check link is not blank
			if(linkOnPage){
				String link = driver.findElement(By.cssSelector("."+course+" .course-link")).getText();
				
				Assert.assertTrue(driver.getCurrentUrl() + " " + courseName+" link is blank", link.length() > 0);
			}			
			
	}
	
	public void clickCourseLink(String course) throws InterruptedException {
		Thread.sleep(3);
		driver.findElement(
				By.cssSelector("."+course+" .course-link")).click();
	}
	
	/** Navigate browser back
	 * 
	 */
	public void navigateBack() {
		driver.navigate().back();
	}

	/**
	 * Assert landing on correct page
	 * @param pageClass 	class for the page item
	 * @param courseName 	Name of the course, which was clicked
	 */
	public void assertEnglishPage(String pageClass, String courseName) {
		Boolean youngLearnerOnPage = Utils.isElementPresent(driver, By.cssSelector("."+pageClass));
		Assert.assertTrue(driver.getCurrentUrl() + " " + courseName+" page is not found", youngLearnerOnPage);
	}

	public void assertYoungLearnerSectionPresent() {
		Boolean elementOnPage = Utils.isElementPresent(driver, By.cssSelector(".pane-kis-pages-feature-kis-yl-home"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Young learners section is not present on homepage", elementOnPage);
	}

	public void assertYLFirstPanelPresent() {
		Boolean firstPanelYLOnPage = Utils.isElementPresent(driver,By.cssSelector(".young-eng .young-eng-intro"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "English Course Type first Panel is not present on hompage", firstPanelYLOnPage);		

	}

	public void assertYLFirstPanelContent() {
		Boolean firstPanelYLTitle = Utils.isElementPresent(driver, By.cssSelector(".young-eng .young-eng-intro .title"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Title in first panel for Young Learner is not present on hompage", firstPanelYLTitle);		

		Boolean firstPanelYLSubTitle = Utils.isElementPresent(driver, By.cssSelector(".young-eng .young-eng-intro .sub-title"));
		Assert.assertTrue("Sub Title in first panel for Young Learner is not present on hompage", firstPanelYLSubTitle);		

		Boolean firstPanelYLDescription = Utils.isElementPresent(driver, By.cssSelector(".young-eng .young-eng-intro .desc"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Description in first panel for Young Learner is not present on hompage", firstPanelYLDescription);		

		
		List<WebElement> ctas = driver.findElements(By.cssSelector(".young-eng .young-eng-intro a.btn"));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "2 CTA's are not present for first panel in English course type", ctas.size() == 1);

	}

	public void clickYLPanelSecondaryCTA() {
		WebElement cta = Utils.getWebElement(driver, By.cssSelector(".young-eng .young-eng-intro a.btn"));
		if(cta != null) {		
			cta.sendKeys(Keys.ENTER);
		}
		
	}

	public void assertYLDestinationPanelsPresent() throws InterruptedException {
		Thread.sleep(2);
		List<WebElement> destinationPanels= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".young-eng .young-eng-item")));
		Assert.assertTrue(driver.getCurrentUrl() + " " + "Destination panels are missing in Young learners section", destinationPanels.size() >= 3);
	}

	public void assertYLDestinationPanelContent() throws InterruptedException {
		Thread.sleep(3);
		List<WebElement> destinationPanels= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".young-eng .young-eng-item")));
		destinationPanels.remove(0);

		if(destinationPanels.size() > 0){
			for(WebElement panel : destinationPanels) {
				
				action.moveToElement(panel).build().perform();	
			
				Boolean titleOnPage = panel.findElement(By.cssSelector(".course-item .course-title")).isDisplayed();
				Assert.assertTrue(driver.getCurrentUrl() + " " + "Destination panel title is missing", titleOnPage);

				Boolean descOnPage = panel.findElement(By.cssSelector(".course-item .course-desc")).isDisplayed();
				Assert.assertTrue(driver.getCurrentUrl() + " " + "Destination panel Description is missing", descOnPage);
				
				Boolean linkOnPage = panel.findElement(By.cssSelector(".course-item .course-link")).isDisplayed();
				Assert.assertTrue(driver.getCurrentUrl() + " " + "Destination panel link is missing", linkOnPage);

				
			}
			
		}
		
	}


}
