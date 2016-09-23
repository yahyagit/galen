package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.HeaderSection;
import com.ekapiww.pageobjects.HelpCenterPage;
import com.ekapiww.pageobjects.PromotionsPage;
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
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Then;


public class Main_Navigation_Bar {
	private HeaderSection headerSection = new HeaderSection(AppDriver.getDriver());
	
	private EnglishCoursesPage englishCoursesPage = new EnglishCoursesPage(AppDriver.getDriver());
	private EnglishCoursesForAdults englishCoursesForAdults = new EnglishCoursesForAdults(AppDriver.getDriver());
	private EnglishforYoungLearnersPage englishforYoungLearnersPage = new EnglishforYoungLearnersPage(AppDriver.getDriver());
	private FreeEnglishTestPage freeEnglishTestPage = new FreeEnglishTestPage(AppDriver.getDriver());
	private BenefitsOfLearningEnglishPage benefitsOfLearningEnglishPage = new BenefitsOfLearningEnglishPage(AppDriver.getDriver());
	
	private UnitedStatesPage unitedStatesPage =new UnitedStatesPage(AppDriver.getDriver());
	private UnitedKingdomPage unitedKingdomPage =new UnitedKingdomPage(AppDriver.getDriver());
	private IrelandPage irelandPage = new IrelandPage(AppDriver.getDriver());
	private AustraliaPage australiaPage =new AustraliaPage(AppDriver.getDriver());
	private CanadaPage canadaPage =new CanadaPage(AppDriver.getDriver());
	private NewZealandPage newZealandPage =new NewZealandPage(AppDriver.getDriver());
	private SingaporePage singaporePage = new SingaporePage(AppDriver.getDriver());
	private MaltaPage maltaPage =new MaltaPage(AppDriver.getDriver());
	
	private PromotionsPage promotionsPage = new PromotionsPage(AppDriver.getDriver());
	private HelpCenterPage helpCenterPage = new HelpCenterPage(AppDriver.getDriver());
	
	private AboutKaplanPage aboutKaplanPage = new AboutKaplanPage(AppDriver.getDriver());
	private MeetTheTeamPage meetTheTeamPage = new MeetTheTeamPage (AppDriver.getDriver());
	private KPlusPage kPlusPage =new KPlusPage(AppDriver.getDriver());
	private KaplanIncPage kaplanIncPage =new KaplanIncPage(AppDriver.getDriver());
	private UKandInternationalCareerPage ukAndInternationalCareerPage =new UKandInternationalCareerPage(AppDriver.getDriver());
	private USAandCanadaCareerPage usaAndCanadaCareerPage =new USAandCanadaCareerPage(AppDriver.getDriver());

	
	@Then("^I would like to see English courses menu with relevant sections to my market$")
	public void i_would_like_to_see_English_courses_menu_with_relevant_sections_to_my_market() throws Throwable {
		headerSection.clickEnglishCourses();
		headerSection.cilckEnglishCoursesOnDropdown();
		englishCoursesPage.assertEnglishCoursesPage();
		
		headerSection.clickEnglishCourses();
		headerSection.clickOnEnglishCoursesForAges16();
		englishCoursesForAdults.assertEnglishCoursesForAdultsPage();
		
		headerSection.clickEnglishCourses();
		headerSection.clickOnYoungLearnersOnDropdown();
		englishforYoungLearnersPage.assertYoungLearnersPage();
		
		headerSection.clickEnglishCourses();
		headerSection.clickOnFreeEnglishTest();
		freeEnglishTestPage.assertEnglishTestPage();
		
		headerSection.clickEnglishCourses();
		headerSection.clickOnBenefitsoflearningEnglish();
		benefitsOfLearningEnglishPage.assertBenefitsOfLearningPage();
		
	}

	@Then("^I would like to see Destination menu with relevant sections to my market$")
	public void i_would_like_to_see_Destination_menu_with_relevant_sections_to_my_market() throws Throwable {
		headerSection.clickDestinations();
		headerSection.clickAllDestinations();
		
		headerSection.clickDestinations();
		headerSection.clickOnUnitedStates();
		unitedStatesPage.assertUnitedSatesPage();
		
		headerSection.clickDestinations();
		headerSection.clickOnUnitedKingdom();
		unitedKingdomPage.assertUnitedKingdomPage();
		
		headerSection.clickDestinations();
		headerSection.clickOnIreland();
		irelandPage.assertIrelandPage();
		
		headerSection.clickDestinations();
		headerSection.clickOnAustralia();
		australiaPage.assertAustraliaPage();
		
		headerSection.clickDestinations();
		headerSection.clickOnCanada();
		canadaPage.assertCanadaPage();
		
		headerSection.clickDestinations();
		headerSection.clickOnNewZealand();
		newZealandPage.assertNewZealandPage();
		
		headerSection.clickDestinations();
		headerSection.clickOnSingapore();
		singaporePage.assertSingaporePage();
		
		headerSection.clickDestinations();
		headerSection.clickOnMalta();
		maltaPage.assertMaltaPage();
		
	}

	@Then("^I would like to see Promotions menu with relevant sections to my market$")
	public void i_would_like_to_see_Promotions_menu_with_relevant_sections_to_my_market() throws Throwable {
		headerSection.clickPromotions();
		promotionsPage.assertPromotionPage();
	}

	@Then("^I would like to see Help Center menu with relevant sections to my market$")
	public void i_would_like_to_see_Help_Center_menu_with_relevant_sections_to_my_market() throws Throwable {
		headerSection.clickOnHelpCenter();
		headerSection.clickOnVisaInfoAndFAQs();
		helpCenterPage.assertHelpCenterPage();
	}

	@Then("^I would like to see About Kaplan menu with relevant sections to my market$")
	public void i_would_like_to_see_About_Kaplan_menu_with_relevant_sections_to_my_market() throws Throwable {
		headerSection.clickOnAboutKaplan();
		headerSection.clickOnAboutKaplanInternational();
		aboutKaplanPage.assertAboutKaplanPage();
		
		headerSection.clickOnAboutKaplan();
		headerSection.clickOnMeetTheTeam();
		meetTheTeamPage.assertMeetTheTeamPage();
		
		headerSection.clickOnAboutKaplan();
		headerSection.clickOnKPlus();
		kPlusPage.assertKPlusPage();
		
		headerSection.clickOnAboutKaplan();
		headerSection.clickOnKaplanInc();
		kaplanIncPage.assertKaplanIncPage();
		
		headerSection.clickOnAboutKaplan();
		headerSection.clickOnUKandInternationalCareer();
		headerSection = ukAndInternationalCareerPage.assertUKandInternationalCareerPage();
		
		headerSection.clickOnAboutKaplan();
		headerSection.clickOnUSAandCanadaCareer();
		headerSection = usaAndCanadaCareerPage.assertUSAandCanadaCareerPage();
	}
}
