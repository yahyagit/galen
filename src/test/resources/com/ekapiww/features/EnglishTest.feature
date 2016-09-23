@EnglishTest
Feature: English Test

  Scenario: English Test journey of a user
    Given I am on Homepage
    When I goto English test page
    And I populated the registration form
    And I register for the test
    And I complete the english test
    Then I should see the result for test
