@smoke
@DestinationIntro
Feature: Destination Section Intro (Homepage)

Scenario: Checking destination section on home page is loading properly
Given I am on Homepage
When I view the Destination Intro Section
Then I should see headline and description text with two CTAs

