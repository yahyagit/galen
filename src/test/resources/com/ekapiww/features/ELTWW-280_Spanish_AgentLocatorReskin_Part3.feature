@agentSelectionSPA

Feature: Confirmation Page
As a student
I want to see a confirmation page
when I select an agent and fill up the form

Background:
Given I am on Agent Locator page
And I enter city 
And I enter school 
And I click search for agent
And I select a Spanish agent


Scenario: Should see a confirmation page when I fill in a form after selection an agent for agent locator
When I populate the form for Spanish agent
And I click Submit
Then I expect to see confirmation page



