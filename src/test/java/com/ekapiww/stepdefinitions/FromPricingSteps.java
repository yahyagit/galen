package com.ekapiww.stepdefinitions;

import com.ekapiww.pageobjects.CitySchoolPage;
import com.ekapiww.utils.AppDriver;
import com.ekapiww.utils.RestAssure;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FromPricingSteps {
	private CitySchoolPage citySchoolPage = new CitySchoolPage(AppDriver.getDriver());
	private float lowestPrice;
	private String city;
	private String course;

	@Given("^I am on \"([^\"]*)\"$")
	public void i_am_on(String coursePage) throws Throwable {
		AppDriver.launchUrl(coursePage);
	}

	@When("^I should see the from price for the \"([^\"]*)\" in \"([^\"]*)\"$")
	public void i_should_see_the_from_price_for_the_in(String course, String city) throws Throwable {
		this.course = course;
		this.city = city;
		lowestPrice = citySchoolPage.getCoursePrice(this.course+"-"+this.city);
	}
		
	@Then("^the price should be lowest price$")
	public void the_price_should_be_lowest_price() throws Throwable {
		RestAssure.assertFromPrice(this.city, this.course, this.lowestPrice);
	}
}
