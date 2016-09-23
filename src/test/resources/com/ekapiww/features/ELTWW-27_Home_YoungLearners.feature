@YoungLearners
Feature: Young learners Section

Scenario: Young learners first panel 
Given I am on Homepage
When I view the Young Learners Section
Then I see the first panel with Headline, subhead line, description text, one secondary CTA
And I click on the secondary find out more CTA in young learners
Then it takes me to young learners hubpage


Scenario: Three Young learners panels 
Given I am on Homepage
When I view the Young Learners Section
Then I see three young learner destination panels 
And I hover over each panel I see a headline text with description, view courses CTA
