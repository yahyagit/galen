@CMS
@CourseTypeOrdering
Feature: Ability to change the order of English course type section

  Scenario: Change the order of the course type
    Given I am logged in to cmsadmin as content publisher
    When I goto course type ordering page
    And I change the order of the course type
    Then I should see the same order on the home page
    And I logout as a content publisher
