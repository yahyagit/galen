@FormAPITest
@brochure
Feature:
As a user
I want to download brochure
So that I get information about the program I am interested on

Scenario:
Given I am on Homepage
And I click on Free brochure
When I populate brochure download form
And I click on get my free brochure
Then I should see brochure download confirmation page
And I expect a lead to be generated in Salesforce with submitted values for Brochure

