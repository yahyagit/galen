@ThreeBanner
Feature: Verify three banner section

Background:
Given I am on Homepage

Scenario:
When I view three secondary banner section
Then I verfify main heading, sub heading, description, ribbon and CTA on first panel
Then I verify main heading, sub heading, description, ribbon and CTA on third panel

Scenario:
Then I verify main heading, description and CTA on second panel for Brochure banner
When I click on the find out more CTA for second panel
Then I should navigate to brochure page

