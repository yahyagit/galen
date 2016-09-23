@FormAPITest
@EnglishtestAPI
Feature: English test API

Scenario: As a user I expect a lead to be created in SF when I submit an English Test
	Given I am on Homepage
    When I goto English test page
    And I populated the registration form
    And I register for the test
    And I complete the english test
    Then I expect a lead to be generated in Salesforce with submitted values