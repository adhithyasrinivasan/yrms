package com.yantra.auto.yrms.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AutomationBase 
{
	protected static GlobalSettings globalSettings = new GlobalSettings();
	public static String browserName=null;
	public static WebDriver driver=null;
	private static String browser=null;
	private static String yrmsurl=null;
	private static String os=GlobalSettings.getProperty(GlobalSettings.OS);
	private static String gecko_driver=GlobalSettings.getProperty(GlobalSettings.gecko_driver);
	private static String gecko_windows=GlobalSettings.getProperty(GlobalSettings.gecko_windows);
	private static String chrome_driver=GlobalSettings.getProperty(GlobalSettings.chrome_driver);
	private static String chrome_windows=GlobalSettings.getProperty(GlobalSettings.chrome_windows);
	private static String chromePath=GlobalSettings.getProperty(GlobalSettings.chromeBrowserPath);
	public static void setup(final String BROWSER)
	{
		if(BROWSER.equalsIgnoreCase("firefox") && os.equalsIgnoreCase("linux"))
		{
			System.setProperty("webdriver.gecko.driver", gecko_driver);
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox") && os.equalsIgnoreCase("windows"))
		{
			System.setProperty("webdriver.gecko.driver", gecko_windows);
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome") && os.equalsIgnoreCase("linux"))
		{
			System.setProperty("webdriver.chrome.driver", chrome_driver);
			ChromeOptions options=new ChromeOptions();
			options.setBinary(chromePath);
			driver = new ChromeDriver(options);
		}
		else if(BROWSER.equalsIgnoreCase("chrome") && os.equalsIgnoreCase("windows"))
		{
			System.setProperty("webdriver.chrome.driver", chrome_windows);
			ChromeOptions options=new ChromeOptions();
			options.setBinary(chromePath);
			driver=new ChromeDriver(options);
		}
		else if(BROWSER.equalsIgnoreCase("html"))
		{
			//To be implemented
		}
		else if(BROWSER.equalsIgnoreCase("safari"))
		{
			//To be implemented
		}
		else if(BROWSER.equalsIgnoreCase("IE"))
		{
			//To be implemented
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
		driver.manage().deleteAllCookies();
	}
	public static String getBrowser()
	{
		if(browser==null)
		{
				browser=GlobalSettings.getProperty("browser");
		}
		return browser;
	}
	public static String getYrmsUrl()
	{
		if(yrmsurl==null)
		{
			yrmsurl=GlobalSettings.getProperty("yrmsurl");
		}
		return yrmsurl;
	}
}
