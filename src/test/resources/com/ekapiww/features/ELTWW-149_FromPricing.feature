@FromPrice
Feature: Check the from pricing for course on school page

  Scenario Outline: Check the from price is correct
    Given I am on "<coursePage>"
    When I should see the from price for the "<course>" in "<city>"
    Then the price should be lowest price

    Examples: 
      | coursePage                                          | course | city |
      | united-kingdom/bath/english-school-bath?s           | ENGINT | BAT  |
      | united-states/seattle/highline-community-college?sd | ENGGEN | HCC  |
      | ireland/dublin/english-school-dublin?sd             | ENGVAC | DUB  |
      | australia/brisbane/english-school-brisbane?sd       | ENGINT | IHB  |
      | new-zealand/auckland/english-school-auckland?sd     | ENGGEN | AUC  |
