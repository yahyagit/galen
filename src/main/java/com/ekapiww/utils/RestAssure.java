package com.ekapiww.utils;

import org.junit.Assert;

import com.ekapiww.pageobjects.ContactUsPage;
import com.ekapiww.pageobjects.EnglishLevelTestSignupPage;
import com.ekapiww.pageobjects.FooterSection;
import com.ekapiww.pageobjects.FreeBrochurePage;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.equalTo;

public class RestAssure {

	public static String getAPIPath(){
		return new PropertyReader("/com/ekapiww/properties/url.properties").readProperty(AppVariables.APP_ENV+".fromPrice.api.path");
	}
	
	public static String getAPIToken(){
		return new PropertyReader("/com/ekapiww/properties/url.properties").readProperty(AppVariables.APP_ENV+".fromPrice.api.token");
	}
	public static String getAPIPathSF(){
		return new PropertyReader("/com/ekapiww/properties/url.properties").readProperty(AppVariables.APP_ENV+".englishTest.api.path");

	}
	public static String getAuthCredentialsUsername(){
		return new PropertyReader("/com/ekapiww/properties/testdata.properties").readProperty(AppVariables.APP_ENV+".englishTestAuthUsername");
	}
	public static String getAuthCredentialsPassword(){
		return new PropertyReader("/com/ekapiww/properties/testdata.properties").readProperty(AppVariables.APP_ENV+".englishTestAuthPassword");
	}
	
	public static String getFromPrice(String school, String course){
				
		RestAssured.baseURI = getAPIPath();

		String apiToken = getAPIToken();
		
		String json = RestAssured.get(school+"/"+course+apiToken).asString();
		
		return json;
	}
	
	public static void assertFromPrice(String school, String course, float lowestPrice){
		
		RestAssured.baseURI = getAPIPath();

		String apiToken = getAPIToken();
		
		RestAssured.get(school+"/"+course+apiToken).then().assertThat().body("DestinationPrice",equalTo(lowestPrice));

	}

	public void assertLeadGenerated() {
		RestAssured.baseURI = getAPIPathSF();
		String basicAuthUsername = getAuthCredentialsUsername();
		String basicAuthPassword = getAuthCredentialsPassword();

		String body = RestAssured.given().contentType("application/JSON")
				// add authentication credentials
				.authentication().basic(basicAuthUsername, basicAuthPassword)
				// GET request and assert status code 200 - lead created successfully
				.get("/"+EnglishLevelTestSignupPage.email).then().assertThat()
				.statusCode(200).and().extract().body().asString();
		System.out.println(body);
		JsonPath jsonPath = new JsonPath(body);
		String countryName = jsonPath.getString("countryName");
		String englishLevel = jsonPath.getString("englishLevel");
		String englishScore = jsonPath.getString("englishScore");
		String email	= jsonPath.getString("email");
		String firstName = jsonPath.getString("firstName");
		System.out.println(countryName + englishLevel + englishScore
				+ firstName + email);
		// Assert data values
		Assert.assertTrue(englishLevel.equals("[Intermediate]"));
		Assert.assertTrue(englishScore.equals("[25]"));
		Assert.assertTrue(firstName.equals("[testEnglish]"));
		
		if (AppVariables.APP_URL.contains("tw")) {
			Assert.assertTrue(countryName.equals("[Taiwan]"));
		}
		else if (AppVariables.APP_URL.contains("th")) {
			Assert.assertTrue(countryName.equals("[Thailand]"));
		}
		else if (AppVariables.APP_URL.contains("ru")) {
			Assert.assertTrue(countryName.equals("[Russia]"));
		}
		else{
			{
				Assert.assertTrue(countryName.equals("[Brazil]"));
			}
		}
		

	}
	
	public void assertLeadGeneratedBrochure(){
		RestAssured.baseURI = getAPIPathSF();
		String basicAuthUsername = getAuthCredentialsUsername();
		String basicAuthPassword = getAuthCredentialsPassword();
		
		String body = RestAssured.given().contentType("application/JSON")
				// add authentication credentials
				.authentication().basic(basicAuthUsername, basicAuthPassword)
				// GET request and assert status code 200 - lead created successfully
				.get("/"+FreeBrochurePage.email).then().assertThat()
				.statusCode(200).and().extract().body().asString();
		System.out.println(body);
		JsonPath jsonPath = new JsonPath(body);
		String countryName = jsonPath.getString("countryName");
		String leatType = jsonPath.getString("leadType");
		String email = jsonPath.getString("email");
		String publication = jsonPath.getString("publication");
		System.out.println(countryName + leatType + email + publication
				);
			
		Assert.assertTrue(leatType.equals("[Brochure Download]"));
		
		if (AppVariables.APP_URL.contains("th")){
			Assert.assertTrue(publication.equals("[THA]"));
		}
		else if (AppVariables.APP_URL.contains("ru")){
			Assert.assertTrue(publication.equals("[RUS]"));
		}
		else if (AppVariables.APP_URL.contains("de")){
			Assert.assertTrue(publication.equals("[DE]"));
		
		}
		else if (AppVariables.APP_URL.contains("tw")){
			Assert.assertTrue(publication.equals("[TW]"));
		}
		else if (AppVariables.APP_URL.contains("ar")){
			Assert.assertTrue(publication.equals("[ARA]"));
		}
		else {
			Assert.assertTrue(publication.equals("[ENG]"));
		}
	}
	
	public void assertLeadGeneratedContactUS(){
		RestAssured.baseURI = getAPIPathSF();
		String basicAuthUsername = getAuthCredentialsUsername();
		String basicAuthPassword = getAuthCredentialsPassword();
		
		String body = RestAssured.given().contentType("application/JSON")
				// add authentication credentials
				.authentication().basic(basicAuthUsername, basicAuthPassword)
				// GET request and assert status code 200 - lead created successfully
				.get("/"+ContactUsPage.email).then().assertThat()
				.statusCode(200).and().extract().body().asString();
		System.out.println(body);
		JsonPath jsonPath = new JsonPath(body);
		String countryName = jsonPath.getString("countryName");
		String leatType = jsonPath.getString("leadType");
		String email = jsonPath.getString("email");
		String publication = jsonPath.getString("publication");
		System.out.println(countryName + leatType + email + publication
				);
			
		Assert.assertTrue(leatType.equals("[Contact Us]"));
		
		if (AppVariables.APP_URL.contains("th")){
			Assert.assertTrue(publication.equals("[THA]"));
		}
		else if (AppVariables.APP_URL.contains("ru")){
			Assert.assertTrue(publication.equals("[RUS]"));
		}
		else if (AppVariables.APP_URL.contains("de")){
			Assert.assertTrue(publication.equals("[DE]"));
		
		}
		else if (AppVariables.APP_URL.contains("tw")){
			Assert.assertTrue(publication.equals("[TW]"));
		}
		else if (AppVariables.APP_URL.contains("ar")){
			Assert.assertTrue(publication.equals("[ARA]"));
		}
		else {
			Assert.assertTrue(publication.equals("[ENG]"));
		}
	}

	public void assertLeadGeneratedNewsletter(){
		RestAssured.baseURI = getAPIPathSF();
		String basicAuthUsername = getAuthCredentialsUsername();
		String basicAuthPassword = getAuthCredentialsPassword();
		
		String body = RestAssured.given().contentType("application/JSON")
				// add authentication credentials
				.authentication().basic(basicAuthUsername, basicAuthPassword)
				// GET request and assert status code 200 - lead created successfully
				.get("/"+FooterSection.email).then().assertThat()
				.statusCode(200).and().extract().body().asString();
		System.out.println(body);
		JsonPath jsonPath = new JsonPath(body);
		String countryName = jsonPath.getString("countryName");
		String leatType = jsonPath.getString("leadType");
		String email = jsonPath.getString("email");
		String publication = jsonPath.getString("publication");
		System.out.println(countryName + leatType + email + publication
				);
				
		Assert.assertTrue(leatType.equals("[Sign Up]"));
		
		if (AppVariables.APP_URL.contains("th")){
			Assert.assertTrue(publication.equals("[THA]"));
		}
		else if (AppVariables.APP_URL.contains("ru")){
			Assert.assertTrue(publication.equals("[RUS]"));
		}
		else if (AppVariables.APP_URL.contains("de")){
			Assert.assertTrue(publication.equals("[DE]"));
		
		}
		else if (AppVariables.APP_URL.contains("tw")){
			Assert.assertTrue(publication.equals("[TW]"));
		}
		else if (AppVariables.APP_URL.contains("ar")){
			Assert.assertTrue(publication.equals("[ARA]"));
		}
		else {
			Assert.assertTrue(publication.equals("[ENG]"));
		}
	}

}