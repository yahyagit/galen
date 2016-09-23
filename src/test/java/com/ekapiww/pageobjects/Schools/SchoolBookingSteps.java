package com.ekapiww.pageobjects.Schools;

import com.ekapiww.utils.AppDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SchoolBookingSteps {
	private CourseSearchPage courseSearchPage = new CourseSearchPage(AppDriver.getDriver());
	private SchoolSearchResultsPage schoolSearchResultsPage;
	private SchoolReservationStudentDetailsPage studentDetailsPage;
	private SchoolReservationPaymentPage paymentPage;
	private SchoolReservationConfirmationPage confirmationPage;
	
	@Given("^I am in Find Your Course form on home page$")
	public void i_am_in_Find_Your_Course_form_on_home_page() {
		AppDriver.launchUrl("");
	}

	@And("^I select the student type$")
	public void i_select_the_student_type() {
		courseSearchPage.selectStudentType();
	}

	@And("^I select the course type$")
	public void i_select_the_course_type() {
		courseSearchPage.selectCourseType();
	}

	@And("^I choose the destination$")
	public void i_choose_the_destination() {
		courseSearchPage.selectDestination();
	}

	@And("^I choose the study from$")
	public void i_choose_the_study_from() {
		courseSearchPage.selectStudyFrom();
	}

	@And("^I select the duration$")
	public void i_select_the_duration() {
		courseSearchPage.selectDuration();
	}

	@And("^I click Find it now$")
	public void i_click_Find_it_now() {
		schoolSearchResultsPage = courseSearchPage.submitCourseSearch();
	}

	@And("^I select a school from Search results page$")
	public void i_select_a_school_from_Search_results_page() {
		schoolSearchResultsPage.selectSchool();
	}

	@And("^I verified the Quote details page is displayed$")
	public void i_verified_the_Quote_details_page_is_displayed() {
		schoolSearchResultsPage.isQuoteDetailsPageDisplayed();
	}

	@And("^I verified the cheapest course is selected by default$")
	public void i_verified_the_cheapest_course_is_selected_by_default() {
		schoolSearchResultsPage.hasCheapestCourseSelected();
	}

	@And("^I select a different course$")
	public void i_select_a_different_course() {
	    schoolSearchResultsPage.selectDifferentCourse();
	}

	@And("^I verified the accommodation is selected by default$")
	public void i_verified_the_accommodation_is_selected_by_default() {
	    schoolSearchResultsPage.hasAccomodationSelected();
	}

	@And("^I select a different accommodation$")
	public void i_select_a_different_accommodation() {
	    schoolSearchResultsPage.selectDiffferentAccomodation();
	}

	@And("^I select a transfer$")
	public void i_select_a_transfer() {
	    schoolSearchResultsPage.selectTransfer();
	}

	@And("^I select an insurance$")
	public void i_select_an_insurance() {
	   schoolSearchResultsPage.selectInsurance();
	}

	@And("^I validate all the selected items are correct in the basket$")
	public void i_validate_all_the_selected_items_are_correct_in_the_basket() {
	    schoolSearchResultsPage.verifyTheCartWithQuote();
	}

	@And("^I click Reserve your place$")
	public void i_click_Reserve_your_place() {
		studentDetailsPage = schoolSearchResultsPage.reserveThePlace();
	}

	@And("^I fill the details in Personal details form$")
	public void i_fill_the_details_in_Personal_details_form() {
		studentDetailsPage.enterStudentDetails();
	}

	@And("^I select payment option \"([^\"]*)\"$")
	public void i_select_payment_option(String arg1) {
	    studentDetailsPage.selectPaymentOption();
	}

	@And("^I select agree to the terms and conditions$")
	public void i_select_agree_to_the_terms_and_conditions() {
	    studentDetailsPage.agreeTheTerms();
	}

	@And("^I click Pay Now by \"([^\"]*)\" to proceed checkout$")
	public void i_click_Pay_Now_by_to_proceed_checkout(String arg1) {
		paymentPage = studentDetailsPage.ClickPayNowByCard();
	}

	@When("^I submit the payment card details$")
	public void i_submit_the_payment_card_details() {
	    confirmationPage = paymentPage.enterPaymentDetails();
	}

	@Then("^the order should be placed successfully and receive an order number$")
	public void the_order_should_be_placed_successfully_and_receive_an_order_number() {
	    confirmationPage.confirmReservation();
	}
}
