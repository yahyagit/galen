@smoke
@EnglishCourseType
Feature: English Course Type

Background:
Given I am on Homepage
When I view the English Course Type Section

Scenario: Checking the first panel in English course type
And I see the first panel 
Then I should see Headline, subhead line, description text and two CTAs
When I click on the primary free english test CTA
Then it navigates me to the english test
When I click on the secondary find out more CTA
Then it navigates to english courses hubpage

Scenario: Checking the 5 English course type panels
Then I should see Flexible english courses with headline text and view courses links
When I click on view course link in Flexible english courses
Then it navigates to Flexible english course page 
And I navigate back
Then I should see Exam preperation courses with headline text and view courses links
When I click on view course link in Exam preperation courses
Then it navigates to Exam preperation courses page 
And I navigate back
Then I should see Long Term courses with headline text and view courses links
When I click on view course link in Long Term courses
Then it navigates to Long Term courses page 
And I navigate back
Then I should see Business english courses with headline text and view courses links
When I click on view course link in Business english courses
Then it navigates to Business english courses page 
And I navigate back
Then I should see Work and study program with headline text and view courses links
When I click on view course link in Work and study program
Then it navigates to Work and study program page 
