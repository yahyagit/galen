@formSpamTest_Honeypot
Feature: Secure forms from spam attacks through Honeypot

  Background: 
    Given I am on Homepage

@brochureHonepotTest 
@formSpamTest_Honeypot_DE
  Scenario: Test Honeypot for Brochure Download
    And I click on Free brochure
    When I populate brochure download form
    And I fill in the honeypot field
    And I click on get my free brochure
    Then I should form submission failure message

@nesletterHoneypotTest 
@formSpamTest_Honeypot_DE
  Scenario: Test Honeypot for Newsletter Signup
    When I enter email id on newsletter section
    And I click Sign up
    And I should navigate to Newsletter page
    And I populate newsletter form
    And I verfity pre-populated email id with the one used to sign up
    And I fill in the honeypot field
    And I click keep me updated
    Then I should form submission failure message

@contactUsHoneypotTest 
@formSpamTest_Honeypot_DE
  Scenario: Test Honeypot for Contact Us
    When I click on contact us
    And I fill in the honeypot field
    And I populate the contact us form
    Then I should form submission failure message
    
#(This test doesn't run for DE)
@englishTestHoneypot 
  Scenario: Test Honeypot for English Test
    When I goto English test page
    And I populated the registration form
   	And I fill in the honeypot field
    And I register for the test
    Then I should form submission failure message
