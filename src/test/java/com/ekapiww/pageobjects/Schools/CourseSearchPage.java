package com.ekapiww.pageobjects.Schools;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ekapiww.utils.PropertyReader;

public class CourseSearchPage {
	private WebDriver driver = null;
	private PropertyReader propReader = new PropertyReader("/testdata.properties");
	
	public CourseSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectStudentType() {
		driver.findElement(By.cssSelector("div[id='search_student_type_chosen']>a")).click();
		List<WebElement> studentTypeList = driver.findElements(By.cssSelector("div[id='search_student_type_chosen']>div>ul>li"));
		chooseDataFromList(studentTypeList, "studentType").click();
	}
	
	public void selectCourseType() {
		driver.findElement(By.cssSelector("div[id='search_course_type_chosen']>a")).click();
		List<WebElement> courseTypeList = driver.findElements(By.cssSelector("div[id='search_course_type_chosen']>div>ul>li"));

		chooseDataFromList(courseTypeList, "courseType").click();
	}
	
	public void selectDestination() {
		driver.findElement(By.cssSelector("div[id='search_destination_chosen']>a")).click();
		List<WebElement> destinationList = driver.findElements(By.cssSelector("div[id='search_destination_chosen']>div>ul>li"));
		
		chooseDataFromList(destinationList, "destination").click();
	}
	
	public void selectStudyFrom() {
		driver.findElement(By.cssSelector("div[id='study_from_chosen']>a")).click();
		
		List<WebElement> studyFromList = driver.findElements(By.cssSelector("div[id='study_from_chosen']>div>ul>li"));
		chooseDataFromList(studyFromList, "studyFrom").click();
	}

	public void selectDuration() {
		driver.findElement(By.cssSelector("div[id='study_period_chosen']>a")).click();
		
		List<WebElement> durationList = driver.findElements(By.cssSelector("div[id='study_period_chosen']>div>ul>li"));
		chooseDataFromList(durationList, "duration").click();
	}
	
	public SchoolSearchResultsPage submitCourseSearch() {
		WebElement searchSubmit = driver.findElement(By.id("search-submit-button"));
		searchSubmit.click();
		
		WebElement advancedSearch = driver.findElement(By.cssSelector("div.item.advanced"));
		
		if(advancedSearch.isDisplayed())
		{
			doAdvancedSearch();
			searchSubmit.click();
		}

		return new SchoolSearchResultsPage(driver);
	}
	
	private void doAdvancedSearch() {
		WebElement recogQualification = driver.findElement(By.cssSelector("div[id='recognised_qualification_chosen']>a"));
		if(recogQualification.isDisplayed()) {
			recogQualification.click();
			List<WebElement> recogQualificationList = driver.findElements(By.cssSelector("div[id='recognised_qualification_chosen']>div>ul>li"));
			chooseDataFromList(recogQualificationList, "recogQualification").click();
		}
		
		WebElement destType = driver.findElement(By.cssSelector("div[id='destination_type_chosen']>a"));
		if(destType.isDisplayed()) {
			destType.click();
			
			List<WebElement> destTypeList = driver.findElements(By.cssSelector("div[id='destination_type_chosen']>div>ul>li"));
			chooseDataFromList(destTypeList, "destType").click();;
		}
		
		WebElement distance = driver.findElement(By.cssSelector("div[id='distance_chosen']>a"));
		if(distance.isDisplayed()) {
			distance.click();
			List<WebElement> distanceList = driver.findElements(By.cssSelector("div[id='distance_chosen']>div>ul>li"));
			chooseDataFromList(distanceList, "distance").click();
		}
		
		WebElement destActivity = driver.findElement(By.cssSelector("div[id='destination_activity_chosen']"));
		if(destActivity.isDisplayed()) {
			destActivity.click();
			List<WebElement> destActivityList = driver.findElements(By.cssSelector("div[id='destination_activity_chosen']>div>ul>li"));
			chooseDataFromList(destActivityList, "destActivity").click();
		}
	}
	
	private WebElement chooseDataFromList(List<WebElement> elementList, String propKey) {
		WebElement element = null;
		
		for(WebElement e : elementList) {
			if(e.getText().equalsIgnoreCase(propReader.readProperty(propKey))) {
				element = e;
			}
		}
		
		if(element == null) {
			element = elementList.get(new Random().nextInt(elementList.size()));
		}
		
		return element;
	}

}
