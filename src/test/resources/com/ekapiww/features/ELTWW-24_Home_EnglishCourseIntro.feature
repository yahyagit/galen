@smoke
@EnglishCourseIntro
Feature: English Course Intro

Scenario: Assert if all elements are present for English Course Intro
Given I am on Homepage
When I view the English Course Intro
Then I should see the Kaplan courses introduction text 
And I should see three CTAs