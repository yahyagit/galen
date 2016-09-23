package com.ekapiww.utils;

import org.openqa.selenium.WebDriver;

import com.ekapiww.element.ObjectRepoReader;

public class AppVariables {
	public static WebDriver APP_DRIVER;
	public static String APP_URL;
	public static String APP_AUTH_URL;
	public static String APP_ADMIN_URL;
	public static String APP_ENV;
		
	public static String APP_MARKET_KEY = "app_market";
	public static String APP_MARKET_ENGLISH = "";
	public static String APP_MARKET_GERMAN = "de/";
	public static String APP_MARKET_CHINESE = "tw/";
	public static String APP_MARKET_ARABIC = "ar/";
	public static String APP_MARKET_RUSSIAN = "ru/";
	public static String APP_MARKET_THAI = "th/";
	public static String APP_MARKET_PORTUGUESE = "br";
	public static String APP_MARKET_SPANISH = "spa";
	public static String APP_ENV_KEY="environment";

	public static ObjectRepoReader OBJECT_REPO;
}
