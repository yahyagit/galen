package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.HomeCourseSection;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Home_EnglishCourseIntroSteps {
	private HomeCourseSection homeCourseSection = new HomeCourseSection(AppDriver.getDriver());
	
	@When("^I view the English Course Intro$")
	public void i_view_the_English_Course_Intro() throws Throwable {
		homeCourseSection.assertEnglishCourseIntroIsPresent();	
	}

	@Then("^I should see the Kaplan courses introduction text$")
	public void i_should_see_the_Kaplan_courses_introduction_text() throws Throwable {
		homeCourseSection.assertCourseIntroTextIsPresent();
	}

	@Then("^I should see three CTAs$")
	public void i_should_see_three_CTAs() throws Throwable {
		homeCourseSection.assertThreeCTAIsPresent();
	}
}
