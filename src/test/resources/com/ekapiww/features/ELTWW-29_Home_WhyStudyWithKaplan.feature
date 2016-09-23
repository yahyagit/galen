@smoke
@whyKaplan
Feature: Verify why study with Kaplan

Background:
Given I am on Homepage
When I view on why study with Kaplan section

Scenario: Verify all the elements are present on why study with Kaplan Section
Then I see head line and description text
Then I see four icons with text and description 
Then I see two CTAs as per design

Scenario: Assert primary CTA
When I click on the primary learn more about us CTA
Then I am taken to the about us page

Scenario: Assert secondary CTA
When I click on the secondary download brochure CTA
Then I am taken to the download the brochure page