@smoke 
@LanguageURL
Feature: Verify language URL

  Scenario Outline: Verify couuntry URL according to the language
    Given I am on Homepage
    When I navigate to country hub page
    And I click on "<country>"
    Then I should navigate to the "<URL>"

    Examples: 
      | country             	   | URL             |
      | United Kingdom      	   | kapintdc.com/   |
      | Deutschland (Germany)	   | kapintdc.com/de |
      | Россия (Russia)     	   | kapintdc.com/ru |
      | 台灣 (Taiwan)     	     	 | kapintdc.com/tw |
      | ประเทศไทย (Thailand) 				 | kapintdc.com/th |
