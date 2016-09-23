@CMS
@Home_DestinationPanel
Feature: Destination section layout on home page

Background:
Given I am logged in to cmsadmin as content publisher

Scenario: Manage panel templates structure per market
And goto destination ordering page
When I select 5 panel templates structure 
Then I should see 5 panel structure on homepage view countries
And I should see 5 countires in list on homepage view all cities
And goto destination ordering page
When I select 6 panel templates structure 
Then I should see 6 panel structure on homepage view countries
And I should see 6 countires in list on homepage view all cities
And goto destination ordering page
When I select 7 panel templates structure 
Then I should see 7 panel structure on homepage view countries
And I should see 7 countires in list on homepage view all cities
And goto destination ordering page
When I select 8 panel templates structure 
Then I should see 8 panel structure on homepage view countries
And I should see 8 countires in list on homepage view all cities
And I logout as a content publisher


Scenario: Manage the order of the countries
And goto destination ordering page
When I change the order of the countries
Then I should see the same order on homepage view countries
And I should see the same order on homepage view all cities
And I logout as a content publisher
