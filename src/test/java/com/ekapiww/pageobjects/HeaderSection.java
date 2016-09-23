package com.ekapiww.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ekapiww.pageobjects.AboutKaplan.AboutKaplanPage;
import com.ekapiww.pageobjects.AboutKaplan.KPlusPage;
import com.ekapiww.pageobjects.AboutKaplan.KaplanIncPage;
import com.ekapiww.pageobjects.AboutKaplan.MeetTheTeamPage;
import com.ekapiww.pageobjects.AboutKaplan.UKandInternationalCareerPage;
import com.ekapiww.pageobjects.AboutKaplan.USAandCanadaCareerPage;
import com.ekapiww.pageobjects.Destinations.AustraliaPage;
import com.ekapiww.pageobjects.Destinations.CanadaPage;
import com.ekapiww.pageobjects.Destinations.IrelandPage;
import com.ekapiww.pageobjects.Destinations.MaltaPage;
import com.ekapiww.pageobjects.Destinations.NewZealandPage;
import com.ekapiww.pageobjects.Destinations.SingaporePage;
import com.ekapiww.pageobjects.Destinations.UnitedKingdomPage;
import com.ekapiww.pageobjects.Destinations.UnitedStatesPage;
import com.ekapiww.pageobjects.EnglishCourses.BenefitsOfLearningEnglishPage;
import com.ekapiww.pageobjects.EnglishCourses.EnglishCoursesForAdults;
import com.ekapiww.pageobjects.EnglishCourses.EnglishCoursesPage;
import com.ekapiww.pageobjects.EnglishCourses.EnglishforYoungLearnersPage;
import com.ekapiww.pageobjects.EnglishCourses.FreeEnglishTestPage;
import com.ekapiww.utils.Utils;

public class HeaderSection {
	
	private WebDriver driver;
	

	public HeaderSection(WebDriver driver){
		this.driver = driver;
	}
	
	//WhiteToolBar
	public void assertWhiteToolBarIsPresent(){
		Utils.waitForElementPresence(driver, (By.xpath("//div[@class='header-top header-featured']")), 20);
		driver.findElement(By.xpath("//div[@class='header-top header-featured']")).isDisplayed();
	}
	
	public void assertPhoneCTAIsPresent(){
		Boolean phoneNumberCTA  =  Utils.isElementPresent(driver, By.id("cta-telephone")); 
		Assert.assertTrue(phoneNumberCTA);
	}
	
	public FreeBrochurePage clickFreeBrochure(){
		Boolean freeBrochure =  Utils.isElementPresent(driver, By.id("cta-freebrochure"));
		Assert.assertTrue(freeBrochure);
		
		if (freeBrochure){
			WebElement freeBrochurePresent = driver.findElement(By.id("cta-freebrochure"));
			freeBrochurePresent.click();
		}
		
		return new FreeBrochurePage(driver);
		
	}
	
	
	public ContactUsPage clickContactUs(){
		Boolean contactUs    =  Utils.isElementPresent(driver, By.id("cta-contact-us"));
		Assert.assertTrue(contactUs);
		
		if (contactUs){
			WebElement contactUsPresent = driver.findElement(By.id("cta-contact-us"));
			contactUsPresent.click();

		}
		
		return new ContactUsPage(driver);
	}
	
	public AgentLocatorFormPage clickContactUsForPortugeseAgentLocator(){
		Boolean contactUs    =  Utils.isElementPresent(driver, By.id("cta-contact-us"));
		Assert.assertTrue(contactUs);
		
		if (contactUs){
			WebElement contactUsPresent = driver.findElement(By.id("cta-contact-us"));
			contactUsPresent.click();

		}
		
		return new AgentLocatorFormPage(driver);
	}
	
	public SearchByKeywordPage clickSearch(){
		Boolean searchButton =  Utils.isElementPresent(driver, By.id("cta-site-search"));
		Assert.assertTrue(searchButton);
		
		if (searchButton){
			WebElement searchButtonPresent = driver.findElement(By.id("cta-site-search"));
			searchButtonPresent.click();

		}
		return new SearchByKeywordPage(driver);
	}
	

	public CountryHubPage clickCountryLogo(){
		boolean countryLogo = driver.findElement(By.id("cta-language-selector")).isEnabled();

		if (countryLogo){
			Utils.waitForElementPresence(driver, (By.id("cta-language-selector")), 10);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("cta-language-selector"))).doubleClick().build().perform();
		}
		return new CountryHubPage(driver);

	}
	
	
	//MainNavigationBar
	
	//English courses
	public void clickEnglishCourses(){
		driver.findElement(By.cssSelector("li.expanded:nth-child(1) > a:nth-child(1)")).click();
	}
	
	public EnglishCoursesPage cilckEnglishCoursesOnDropdown(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a")).click();
				
		return new EnglishCoursesPage(driver);
	}
	
	public EnglishCoursesForAdults clickOnEnglishCoursesForAges16(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a")).click();
			
		return new EnglishCoursesForAdults(driver);
	}
	
	public EnglishforYoungLearnersPage clickOnYoungLearnersOnDropdown(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a")).click();
		
		return new EnglishforYoungLearnersPage(driver);
	}
	
	public FreeEnglishTestPage clickOnFreeEnglishTest(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > a")).click();
		
		return new FreeEnglishTestPage(driver);
	}
	
	public BenefitsOfLearningEnglishPage clickOnBenefitsoflearningEnglish(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a")).click();
		
		return new BenefitsOfLearningEnglishPage(driver);
	}
	
	//Destinations
	public void clickDestinations() {
		driver.findElement(By.cssSelector("ul.nav.navbar-nav.id-menu > li:nth-of-type(2) > a.dropdown-toggle")).click();
		
	}
	public DestinationsHubPage clickAllDestinations() {

		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a")).click();
		
		return new DestinationsHubPage(driver);
	}
	
	public UnitedStatesPage clickOnUnitedStates(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a")).click();
		
		return new UnitedStatesPage(driver);
	}
	
	public UnitedKingdomPage clickOnUnitedKingdom(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a")).click();
		
		return new UnitedKingdomPage(driver);
	}
	
	public IrelandPage clickOnIreland(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > a")).click();
		
		return new IrelandPage(driver);
	}
	
	public AustraliaPage clickOnAustralia(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a")).click();
		
		return new AustraliaPage(driver);
	}
	
	public CanadaPage clickOnCanada(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a")).click();
		
		return new CanadaPage(driver);
	}
	
	public NewZealandPage clickOnNewZealand(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(7) > a")).click();
		
		return new NewZealandPage(driver);
	}
	
	public SingaporePage clickOnSingapore(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(8) > a")).click();
		
		return new SingaporePage(driver);
	}
	
	public MaltaPage clickOnMalta(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(9) > a")).click();
		
		return new MaltaPage(driver);
	}
	
	//Promotions
	public PromotionsPage clickPromotions(){
		driver.findElement(By.cssSelector(".nav > li:nth-child(3) > a ")).click();
		
		return new PromotionsPage(driver);
	}
	
	//Help
	public void clickOnHelpCenter(){
		driver.findElement(By.cssSelector("li.expanded:nth-child(4) > a")).click();
	}
	
	public HelpCenterPage clickOnVisaInfoAndFAQs(){
		driver.findElement(By.cssSelector("li.last:nth-child(1) > a")).click();
		
		return new HelpCenterPage(driver);
	}
	
	//AboutKaplan
	public void clickOnAboutKaplan(){
		driver.findElement(By.cssSelector("li.expanded:nth-child(5) > a")).click();
	}
	
	public AboutKaplanPage clickOnAboutKaplanInternational(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(5) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a")).click();
		
		return new AboutKaplanPage(driver);
	}
	
	public MeetTheTeamPage clickOnMeetTheTeam(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(5) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a")).click();
		
		return new MeetTheTeamPage(driver);
	}

	public KPlusPage clickOnKPlus(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(5) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a")).click();
		
		return new KPlusPage(driver);
	}
	
	public KaplanIncPage clickOnKaplanInc(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(5) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > a")).click();
		
		return new KaplanIncPage(driver);
	}
	
	public UKandInternationalCareerPage clickOnUKandInternationalCareer(){
		driver.findElement
			(By.cssSelector
					("li.expanded:nth-child(5) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a")).click();
		
		return new UKandInternationalCareerPage(driver);
	}
	
	public USAandCanadaCareerPage clickOnUSAandCanadaCareer(){
		driver.findElement(By.cssSelector("li.last:nth-child(6) > a")).click();
		
		return new USAandCanadaCareerPage(driver);
	}
	
	public GetQuotePage clickGetAQuote(){
		Boolean getQuote =  Utils.isElementPresent(driver, By.id("cta-getaquote"));
		Assert.assertTrue(getQuote);
		
		if (getQuote){
			WebElement getQuotePresent = driver.findElement(By.id("cta-getaquote"));
			getQuotePresent.click();
		}
		
		return new GetQuotePage(driver);
		
	}
	
		
}
