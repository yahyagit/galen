@agentLocatorBR
Feature: Portuguese contact us form for Agent locator

Background:
Given I am on Homepage
And I click on Contact us for Agent locator
And I navigate to Agent locator form


Scenario Outline: Should redirect to contact Us page when selected 'no/ ' for fifth question
When I select option <option1> for question one
And I enter current place for question two
And I select date to start course for question three
And I select the country for question four
And I select option <option2> for question five
And I click search to take me to Contact us
Then I expect to be redirected to the Drupal Portuguese Contact Us form

Examples:
|	option1	|	option2	|
|	1		|	0		|
|	2		|	2		|
|	3		|	2		|


Scenario Outline: Should redirect to Agent locator page when selected first option for first question
When I select option <option1> for question one
And I enter current place for question two
And I select date to start course for question three
And I select the country for question four
And I select option <option2> for question five
And I click search to take me to Agent Locator Result page
Then I expect to be redirected to the Agent Locator Result page

Examples:
|	option1	|	option2	|
|	2		|	1		|
|	3		|	1		|

 