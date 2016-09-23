package com.ekapiww.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.google.gson.JsonSyntaxException;

public class AppDriver {

	private static final Logger LOGGER = Logger.getLogger(AppDriver.class.getName());
	private static final String BROWSER_KEY = "Browser";
	private static final String PLATFORM_KEY = "platform";
	private static final String DEFAULT = "default";
	private static WebDriver driver;
	public static final String OS_IOS = "ios";
	public static final String OS_ANDROID = "android";
	public static final String JSON_PATH = "\\src\\test\\resources\\com\\browserDetails.json";

	/**
	 * Load the specific browser driver using system property defined in pom.xml
	 */
	public static WebDriver getDriver() {

		try {
			driver = getBrowserStackDriver();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Browser browser;
		Platform platform = null;

		if (driver == null) {
			if (System.getProperty(BROWSER_KEY) == null || System.getProperty(BROWSER_KEY).equals(DEFAULT)) {
				browser = Browser.FIREFOX;
			} else {
				browser = Browser.getBrowserType(System.getProperty(BROWSER_KEY));

				if (System.getProperty(PLATFORM_KEY) == null || System.getProperty(PLATFORM_KEY).equals(DEFAULT)) {
					platform = Platform.WIN;
				} else {
					platform = Platform.getPlatformType(System.getProperty(PLATFORM_KEY));
				}
			}

			switch (browser) {
			case CHROME:
				driver = getChromeDriver(platform);
				break;
			case SAFARI:
				driver = getSafariDriver();
				break;
			case IE:
				driver = getIEDriver(platform);
				break;
			case FIREFOX:
			default:
				driver = getFirefoxDriver();
				break;
			}
			doAllBrowserSetup(driver);
		}
		return driver;
	}

	public static WebDriver getBrowserStackDriver() throws JsonSyntaxException, ParseException, IOException {

		if (null != System.getProperty("runconfiguration") && null == driver) {
			JSONObject jsonobj = null;
			JSONObject jsonobjdetails = null;
			PropertyReader propReader = new PropertyReader("/com/ekapiww/properties/testdata.properties");
			String BROWSERSTACK_USERNAME = propReader.readProperty("browserstackUsername");
			String BROWSERSTACK_ACCESSKEY = propReader.readProperty("browserstackAccesskey");
			String localTesting = propReader.readProperty("localTesting");
			String path = System.getProperty("user.dir") + JSON_PATH;
			jsonobj = JsonReader.loadJson(path);
			jsonobjdetails = JsonReader.getJsonProperty(System.getProperty("runconfiguration"), jsonobj);
			DesiredCapabilities capability = null;

			if (OS_IOS.equals(String.valueOf(jsonobjdetails.get("os")))
					|| OS_ANDROID.equals(String.valueOf(jsonobjdetails.get("os")))) {

				capability = getMobileCapability(jsonobjdetails, localTesting);

			} else {
				capability = getDesktopCapability(jsonobjdetails, localTesting);
			}
			try {
				driver = new RemoteWebDriver(new URL("http://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESSKEY
						+ "@hub.browserstack.com/wd/hub"), capability);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		}

		return driver;

	}

	/**
	 * Setting capability for desktop browsers
	 */

	private static DesiredCapabilities getDesktopCapability(JSONObject jsonobjdetails, String localTesting) {

		String browser = String.valueOf(jsonobjdetails.get("browser"));
		String browserVersion = String.valueOf(jsonobjdetails.get("browserVersion"));
		String os = String.valueOf(jsonobjdetails.get("os"));
		String os_version = String.valueOf(jsonobjdetails.get("os_version"));
		String bit64 = String.valueOf(jsonobjdetails.get("64bit"));

		DesiredCapabilities capability = new DesiredCapabilities();

		capability.setCapability("browserstack.debug", "true");
		capability.setCapability("build", "JUnit-Parallel");
		capability.setCapability("browserstack.local", localTesting);
		capability.setCapability("os", os);
		capability.setCapability("os_version", os_version);
		capability.setCapability("64bit", bit64);
		capability.setCapability("browser", browser);
		capability.setCapability("browserVersion", browserVersion);
		capability.setCapability("acceptSslCerts", "true");

		return capability;
	}

	/**
	 * Setting capability for mobile browsers
	 */

	private static DesiredCapabilities getMobileCapability(JSONObject jsonobjdetails, String localTesting) {

		String device = String.valueOf(jsonobjdetails.get("device"));
		String os = String.valueOf(jsonobjdetails.get("os"));
		String deviceOrientation = String.valueOf(jsonobjdetails.get("deviceOrientation"));
		String realDevice = String.valueOf(jsonobjdetails.get("realDevice"));

		DesiredCapabilities capability = new DesiredCapabilities();

		capability.setCapability("browserstack.debug", "true");
		capability.setCapability("build", "JUnit-Parallel");
		capability.setCapability("browserstack.local", localTesting);
		capability.setCapability("os", os);
		capability.setCapability("device", device);
		capability.setCapability("realDevice", realDevice);
		capability.setCapability("deviceOrientation", deviceOrientation);

		return capability;
	}

	/*
	 * Close the current browser driver and clear the browser session
	 */

	public static void closeDriver() {
		getDriver().quit();
		driver = null;
		LOGGER.info("Closing the current browser driver");
	}

	public static void launchUrl(String path) {
		String market = System.getProperty(AppVariables.APP_MARKET_KEY);

		AppVariables.APP_ENV = System.getProperty(AppVariables.APP_ENV_KEY);
		AppVariables.APP_URL = getURL(AppVariables.APP_ENV + ".environment.url") + market;

		LOGGER.info("Loading the Url: " + AppVariables.APP_URL + path);
		getDriver().get(AppVariables.APP_URL + path);

	}

	public static void launchUrl_secondary(String path) {
		String market = System.getProperty(AppVariables.APP_MARKET_KEY);

		AppVariables.APP_ENV = System.getProperty(AppVariables.APP_ENV_KEY);
		AppVariables.APP_URL = getURL(AppVariables.APP_ENV + ".agent.locator.url") + market;

		LOGGER.info("Loading the Url: " + AppVariables.APP_URL + path);
		getDriver().get(AppVariables.APP_URL + path);

	}

	public static void launchBackendUrl(String path) {

		String market = System.getProperty(AppVariables.APP_MARKET_KEY);

		AppVariables.APP_ENV = System.getProperty(AppVariables.APP_ENV_KEY);
		AppVariables.APP_URL = getURL(AppVariables.APP_ENV + ".environment.url") + market;
		AppVariables.APP_ADMIN_URL = getURL(AppVariables.APP_ENV + ".backend.environment.url") + market;

		LOGGER.info("Loading the Url: " + AppVariables.APP_ADMIN_URL);
		getDriver().get(AppVariables.APP_ADMIN_URL + path);
	}

	private static WebDriver getFirefoxDriver() {
		LOGGER.info("Loading the Firefox driver");
		return new FirefoxDriver();
	}

	private static WebDriver getChromeDriver(Platform platform) {
		LOGGER.info("Loading the Chrome driver");
		String driverPath = null;

		if (platform.equals(Platform.MAC)) {
			driverPath = getDriverProperty("chromeForMac");
		} else if (platform.equals(Platform.LINUX)) {
			driverPath = getDriverProperty("chromeForLinux");
		} else {
			driverPath = getDriverProperty("chromeForWindows");
		}

		System.setProperty("webdriver.chrome.driver", driverPath);
		return new ChromeDriver();
	}

	private static WebDriver getIEDriver(Platform platform) {
		LOGGER.info("Loading the IE driver");
		String driverPath = null;

		if (platform.equals(Platform.WIN32)) {
			driverPath = getDriverProperty("ieForWin32");
		} else {
			driverPath = getDriverProperty("ieForWin64");
		}

		System.setProperty("webdriver.ie.driver", driverPath);
		return new InternetExplorerDriver();
	}

	private static WebDriver getSafariDriver() {
		LOGGER.info("Loading the Safari driver");
		return new SafariDriver();
	}

	private static void doAllBrowserSetup(WebDriver driver) {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		driver.manage().window().maximize();
	}

	public static String getURL(String propKey) {
		PropertyReader propReader = new PropertyReader("/com/ekapiww/properties/url.properties");
		return propReader.readProperty(propKey);
	}

	public static String getDriverProperty(String propKey) {
		Properties prop = new Properties();
		String propVal = null;

		try {
			prop.load(AppDriver.class.getResourceAsStream("/appDriver.properties"));
			propVal = prop.getProperty(propKey);
		} catch (IOException ie) {
			LOGGER.info(ie.getMessage());
		}

		return propVal;
	}

	/*
	 * Browser type constants
	 */
	public enum Browser {

		FIREFOX, CHROME, IE, SAFARI;

		public static Browser getBrowserType(String browser) throws IllegalArgumentException {
			for (Browser b : values()) {
				if (b.toString().equalsIgnoreCase(browser)) {
					return b;
				}
			}
			throw browserNotFound(browser);
		}

		private static IllegalArgumentException browserNotFound(String browserName) {
			return new IllegalArgumentException(("Invalid browser [" + browserName + "]"));
		}
	}

	public enum Platform {

		WIN, WIN32, WIN64, MAC, LINUX;

		public static Platform getPlatformType(String platform) throws IllegalArgumentException {
			for (Platform p : values()) {
				if (p.toString().equalsIgnoreCase(platform)) {
					return p;
				}
			}
			throw invalidPlatform(platform);
		}

		private static IllegalArgumentException invalidPlatform(String platform) {
			return new IllegalArgumentException(("Invalid platform [" + platform + "]"));
		}
	}

}