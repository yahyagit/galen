@FormAPITest
@contactus
Feature:
As a user
I want to contact a student advisor
So that I can get more information from the advisor

Scenario:
Given I am on Homepage
When I click on contact us
And I populate the contact us form
Then I should see a contact us form submission confirmation page
And I expect a lead to be generated in Salesforce with submitted values for Contact Us