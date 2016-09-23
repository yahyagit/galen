@agentLocatorResultSPA
Feature: Search panel
In order to avoid silly problems
As a student
I want to look for an agent in my region

Scenario Outline: Search for agent with different values and validate the result
Given I am on Agent Locator page
When I enter city "<city>" in the city field
And I enter school "<school>" in the school field
And I click search for agent
Then I expect to verify search result one "<msg1>" and/or result two "<msg2>"


Examples:
|	city			|	school			|	msg1															| msg2																|
|	sae				|	Estados Unidos	|	La provincia seleccionada no está en la lista. Seleccione otra	|																	|
|	Barcelona		|	sta				|	El centro seleccionado no está en la lista. Seleccione otro		| 																	|																
|	sae				|	sta				|	La provincia seleccionada no está en la lista. Seleccione otra	| El centro seleccionado no está en la lista. Seleccione otro		|
|					|					|	Provincia requerida												| Centro educativo requerido										|
|					|	Estados Unidos	|	Provincia requerida												|																	|
|	Barcelona		|					|	Centro educativo requerido										| 																	|
|	Barcelona		|	Estados Unidos	| 	Should display at least Three agents							|																	|



