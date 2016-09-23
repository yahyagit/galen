package com.ekapiww.element;

public enum ElementLocatorIdentifierEnum {
	ID("id"),
	NAME("name"),
	XPATH("xpath"),
	CSS("cssSelector"),
	LINK_TEXT("linktext"),
	PARTIAL_LINK_TEXT("partiallinktext"),
	CLASSNAME("classname"),
	TAGNAME("tagname");
	
	private String elementIdentifiedByMethod;
	
	private ElementLocatorIdentifierEnum(String elementIdentifiedByMethod) {
		this.elementIdentifiedByMethod = elementIdentifiedByMethod;
	}
	
	public String getElementLocatorByMethod() {
		return elementIdentifiedByMethod;
	}
	
	public static ElementLocatorIdentifierEnum getElementLocatorByMethodName(String elementIdentifiedByMethod) {
		for(ElementLocatorIdentifierEnum elementLocatorByEnum : ElementLocatorIdentifierEnum.values()) {
			if(elementLocatorByEnum.getElementLocatorByMethod().equalsIgnoreCase(elementIdentifiedByMethod)) {
				return elementLocatorByEnum;
			}
		}
		throw new IllegalArgumentException("Unable to locate the web element by this identifiedBy method: " + elementIdentifiedByMethod);
	}
}
