package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.CourseTypeOrderingPage;
import com.ekapiww.pageobjects.cms.AdminPage;
import com.ekapiww.pageobjects.cms.CmsHomeCourseSection;
import com.ekapiww.pageobjects.cms.CmsHomePage;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Home_CourseOrderingStep {
	private AdminPage adminPage = new AdminPage(AppDriver.getDriver());
	private CmsHomePage cmsHomePage = new CmsHomePage(AppDriver.getDriver());
	private CmsHomeCourseSection cmsHomeCourseSection;
	private CourseTypeOrderingPage courseTypeOrderingPage;
	
	@When("^I goto course type ordering page$")
	public void i_goto_course_type_ordering_page() throws Throwable {	
		cmsHomeCourseSection = adminPage.navigateToCourseSectionHomepage();
		courseTypeOrderingPage = cmsHomeCourseSection.navigateToOrderingPage();
	}

	@When("^I change the order of the course type$")
	public void i_change_the_order_of_the_course_type() throws Throwable {
		courseTypeOrderingPage.changeCourseOrder();
		courseTypeOrderingPage.save();
	}

	@Then("^I should see the same order on the home page$")
	public void i_should_see_the_same_order_on_the_home_page() throws Throwable {
		cmsHomeCourseSection = courseTypeOrderingPage.clickOnHome();
		cmsHomeCourseSection.assertCourseOrder();

		courseTypeOrderingPage = cmsHomeCourseSection.navigateToOrderingPage();
		courseTypeOrderingPage.resetCourseOrder();
		courseTypeOrderingPage.save();
		courseTypeOrderingPage.clickOnHome();
	}
	
	@Then("^I logout as a content publisher$")
	public void i_logout_as_a_content_publisher() throws Throwable {
		cmsHomePage.logout();
		AppDriver.closeDriver();
	}
}
