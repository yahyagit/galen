@CMS
@DestinationHubPageLayout 
Feature: New destinations hub page with admin page layout

Scenario: Making changes to design layout in admin page
Given I am logged in to cmsadmin as admin
And I click configuration
And I click Countries
And I click Layouts
And I reset the panels to original format

When I select the first country name in the first row
And I select the second country name in the first row

And I click swap
And click Save
And I navigate to destinations hub page
Then I should see the changes in the layout

