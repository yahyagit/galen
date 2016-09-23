@smoke
@HeroBanner
Feature: Hero Banner Section on Homepage

Background:
Given I am on Homepage

Scenario: Assert if all elements are present for HeroBanner
When I view the Hero Banner section
Then I should see sub heading, main heading and description
#And I should see two CTAs
When I click on the secondary Contact us CTA
Then it should navigates to Contact us page