@FormAPITest
@newsletter
Feature: Newsletter sign up

Scenario: Should navigate to Newsletter page when sign up for Newsletter
Given I am on Homepage
When I enter email id on newsletter section
And I click Sign up
Then I should navigate to Newsletter page

Scenario: Should see confirmation page when form is populated
When I populate newsletter form
And I verfity pre-populated email id with the one used to sign up
And I click keep me updated
Then I should see a newsletter confirmation page
And I expect a lead to be generated in Salesforce with submitted values for Newsletter
