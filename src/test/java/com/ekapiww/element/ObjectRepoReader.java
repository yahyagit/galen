package com.ekapiww.element;

import org.openqa.selenium.By;

import com.ekapiww.utils.PropertyReader;

public class ObjectRepoReader {
	PropertyReader propReader = null;
	
	public ObjectRepoReader(String objectRepoPath) {
		propReader = new PropertyReader(objectRepoPath);
	}
	
	public By getLocator(String webElementKey) {
		By elementLocator = null;
		
		 // retrieve the specified object from the object list
        String locator = propReader.readProperty(webElementKey);
         
        // extract the locator type and value from the object
        String locatorType = locator.split(":")[0];
        String locatorValue = locator.split(":")[1];
		ElementLocatorIdentifierEnum elementLocatorMethod = ElementLocatorIdentifierEnum.getElementLocatorByMethodName(locatorType);
		
		switch(elementLocatorMethod) {
		case ID:
			elementLocator = By.id(locatorValue);
			break;
		case NAME:
			elementLocator = By.name(locatorValue);
			break;
		case XPATH:
			elementLocator = By.xpath(locatorValue);
			break;
		case CSS:
			elementLocator = By.cssSelector(locatorValue);
			break;
		case LINK_TEXT:
			elementLocator = By.linkText(locatorValue);
			break;
		case PARTIAL_LINK_TEXT:
			elementLocator = By.partialLinkText(locatorValue);
			break;
		case CLASSNAME:
			elementLocator = By.className(locatorValue);
			break;
		case TAGNAME:
			elementLocator = By.tagName(locatorValue);
			break;
		}
		
		if(elementLocator == null) {
			throw new IllegalArgumentException("Invalid Object Identifier: " + locatorType +
					" or Object Path: " + locatorValue);
		}

		return elementLocator;
	}

}
