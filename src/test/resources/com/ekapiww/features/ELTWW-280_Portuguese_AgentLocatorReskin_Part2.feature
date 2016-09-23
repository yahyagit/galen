@agentLocatorResultBR
Feature: Search panel
In order to avoid silly problems
As a student
I want to look for an agent in my region

Background:
Given I am on Homepage
And I click on Contact us for Agent locator
And I navigate to Agent locator form
And I populate Agent locator form
And I navigate to Agent Locator result page


Scenario Outline: Search for agent with different values and validate the result
When I enter city "<city>" in the first field
And I enter school "<school>" in the second field
And I click search
Then I expect to see search result one "<msg1>" and/or result two "<msg2>"


Examples:
|	city			|	school			|	msg1																		| msg2																|
|	sae				|	sta				|	A cidade não foi encontrada. Por favor digite o nome da cidade e estado		| A escola selecionada não está na lista. Por favor escolha outra	|
|					|					|	Escolha o estado															| Escolha uma escola												|
|					|	Estados Unidos	|	Escolha o estado															|																	|
|	Saúde, BA		|					|	Escolha uma escola															| 																	|
|	Saúde, BA		|	Estados Unidos	| 	Should display at least Three agents										|																	|
|	sae				|	Estados Unidos	|	A cidade não foi encontrada. Por favor digite o nome da cidade e estado		|																	|
|	Saúde, BA		|	sta				|	A escola selecionada não está na lista. Por favor escolha outra				| 																	|																




