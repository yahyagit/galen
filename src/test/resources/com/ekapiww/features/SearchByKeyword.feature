@SearchByKeyword
Feature: Search bar is present and showing relevant results

  Background: 
    Given I am on Homepage
    When I view search panel

  Scenario Outline: Verify search is giving valid results
    And I search for "<keyword>"
    Then I should get relevant search results

    Examples: 
      | keyword |
      | London  |
      | Visa    |
      | Usa     |

  Scenario Outline: Verify no results page is displayed
    And I search for invalid "<keyword>"
    Then I should go to no result page

    Examples: 
      | keyword   |
      | Londonnnn |
      | London123 |
