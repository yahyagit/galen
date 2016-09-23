package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.HomeCourseSection;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Home_EnglishCourseTypeSteps {
	private HomeCourseSection homeCourseSection= new HomeCourseSection(AppDriver.getDriver());
	
	@When("^I view the English Course Type Section$")
	public void i_view_the_English_Course_Type_Section() throws Throwable {
		homeCourseSection.assertEnglishCourseTypeSectionPresent();
	}

	@When("^I see the first panel$")
	public void i_see_the_first_panel() throws Throwable {
		homeCourseSection.assertECTFirstPanelPresent();
	}

	@Then("^I should see Headline, subhead line, description text and two CTAs$")
	public void i_should_see_Headline_subhead_line_description_text_and_two_CTAs() throws Throwable {
		homeCourseSection.assertECTFirstPanelContent();
	}

	@When("^I click on the secondary find out more CTA$")
	public void i_click_on_the_secondary_find_out_more_CTA() throws Throwable {	
		homeCourseSection.clickFPSecondaryCTA();
	}

	@Then("^it navigates to english courses hubpage$")
	public void it_navigates_to_english_courses_hubpage() throws Throwable {
		homeCourseSection.assertCTALink("page-node-554");
	}

	@When("^I click on the primary free english test CTA$")
	public void i_click_on_the_primary_free_english_test_CTA() throws Throwable {
		homeCourseSection.clickFPPrimaryCTA();
	}

	@Then("^it navigates me to the english test$")
	public void it_navigates_me_to_the_english_test() throws Throwable {
		homeCourseSection.assertCTALink("page-node-553");

	}

	@Then("^I should see Flexible english courses with headline text and view courses links$")
	public void i_should_see_Flexible_english_courses_with_headline_text_and_view_courses_links() throws Throwable {
		homeCourseSection.assertCourseTypePresent("course-type-557", "Flexible english course");
	}

	@When("^I click on view course link in Flexible english courses$")
	public void i_click_on_view_course_link_in_Flexible_english_courses() throws Throwable {
		homeCourseSection.clickCourseLink("course-type-557");
	}

	@Then("^it navigates to Flexible english course page$")
	public void it_navigates_to_Flexible_english_course_page() throws Throwable {
		homeCourseSection.assertEnglishPage("page-node-557", "Flexible english course");
	}

	@Then("^I navigate back$")
	public void i_navigate_back() throws Throwable {
		homeCourseSection.navigateBack();
	}

	@Then("^I should see Exam preperation courses with headline text and view courses links$")
	public void i_should_see_Exam_preperation_courses_with_headline_text_and_view_courses_links() throws Throwable {
		homeCourseSection.assertCourseTypePresent("course-type-558", "Exam preperation courses");
	}

	@When("^I click on view course link in Exam preperation courses$")
	public void i_click_on_view_course_link_in_Exam_preperation_courses() throws Throwable {
		homeCourseSection.clickCourseLink("course-type-558");
	}

	@Then("^it navigates to Exam preperation courses page$")
	public void it_navigates_to_Exam_preperation_courses_page() throws Throwable {
		homeCourseSection.assertEnglishPage("page-node-558", "Exam preperation courses");
	}

	@Then("^I should see Long Term courses with headline text and view courses links$")
	public void i_should_see_Long_Term_courses_with_headline_text_and_view_courses_links() throws Throwable {
		homeCourseSection.assertCourseTypePresent("course-type-559", "Long Term courses");
	}

	@When("^I click on view course link in Long Term courses$")
	public void i_click_on_view_course_link_in_Long_Term_courses() throws Throwable {
		homeCourseSection.clickCourseLink("course-type-559");
	}

	@Then("^it navigates to Long Term courses page$")
	public void it_navigates_to_Long_Term_courses_page() throws Throwable {
		homeCourseSection.assertEnglishPage("page-node-559", "Long Term courses");
	}

	@Then("^I should see Business english courses with headline text and view courses links$")
	public void i_should_see_Business_english_courses_with_headline_text_and_view_courses_links() throws Throwable {
		homeCourseSection.assertCourseTypePresent("course-type-560", "Business english courses");
	}

	@When("^I click on view course link in Business english courses$")
	public void i_click_on_view_course_link_in_Business_english_courses() throws Throwable {
		homeCourseSection.clickCourseLink("course-type-560");
	}

	@Then("^it navigates to Business english courses page$")
	public void it_navigates_to_Business_english_courses_page() throws Throwable {
		homeCourseSection.assertEnglishPage("page-node-560", "Business english courses");
	}

	@Then("^I should see Work and study program with headline text and view courses links$")
	public void i_should_see_Work_and_study_program_with_headline_text_and_view_courses_links() throws Throwable {
		homeCourseSection.assertCourseTypePresent("course-type-561", "Work and study program");
	}

	@When("^I click on view course link in Work and study program$")
	public void i_click_on_view_course_link_in_Work_and_study_program() throws Throwable {
		homeCourseSection.clickCourseLink("course-type-561");
	}

	@Then("^it navigates to Work and study program page$")
	public void it_navigates_to_Work_and_study_program_page() throws Throwable {
		homeCourseSection.assertEnglishPage("page-node-561", "Work and study program");
	}

}
