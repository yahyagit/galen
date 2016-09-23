package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.HomeCourseSection;
import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Home_YoungLearnerSteps {
	private HomeCourseSection homeCourseSection = new HomeCourseSection(AppDriver.getDriver());
	
	@When("^I view the Young Learners Section$")
	public void i_view_the_Young_Learners_Section() throws Throwable {
		homeCourseSection.assertYoungLearnerSectionPresent();
	}

	@Then("^I see the first panel with Headline, subhead line, description text, one secondary CTA$")
	public void i_see_the_first_panel_with_Headline_subhead_line_description_text_one_secondary_CTA() throws Throwable {
		homeCourseSection.assertYLFirstPanelPresent();
		homeCourseSection.assertYLFirstPanelContent();
	}

	@Then("^I click on the secondary find out more CTA in young learners$")
	public void i_click_on_the_secondary_find_out_more_CTA_in_young_learners() throws Throwable {
		homeCourseSection.clickYLPanelSecondaryCTA();
	}
	
	@Then("^it takes me to young learners hubpage$")
	public void it_takes_me_to_young_learners_hubpage() throws Throwable {
		homeCourseSection.assertCTALink("young-learners");
	}

	@Then("^I see three young learner destination panels$")
	public void i_see_three_young_learner_destination_panels() throws Throwable {
		homeCourseSection.assertYLDestinationPanelsPresent();	
	}

	@Then("^I hover over each panel I see a headline text with description, view courses CTA$")
	public void i_hover_over_each_panel_I_see_a_headline_text_with_description_view_courses_CTA() throws Throwable {
		homeCourseSection.assertYLDestinationPanelContent();
	}
}
