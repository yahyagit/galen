@agentSelectionBR
Feature: Confirmation Page
As a student
I want to see a confirmation page
when I select an agent and fill up the form

Background:
Given I am on Homepage
And I click on Contact us for Agent locator
And I navigate to Agent locator form
And I populate Agent locator form
And I navigate to Agent Locator result page
And I select a Portuguese agent


Scenario: Should see a confirmation page when I fill in a form after selection an agent for agent locator
When I enter details on the form
And I click Submit
Then I expect to see confirmation page



