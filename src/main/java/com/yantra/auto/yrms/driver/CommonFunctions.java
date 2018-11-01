package com.yantra.auto.yrms.driver;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CommonFunctions 
{
	public static void clickField(final WebDriver driver,By by)
	{
		driver.findElement(by).click();
	}
	public static void clickElement(final WebDriver driver,WebElement webElement)
	{
		webElement.click();
	}
	public static void populateTextField(final WebDriver driver,By by,String string)
	{
		driver.findElement(by).sendKeys(Keys.HOME+string);
	}
	public static String getText(final WebDriver driver,By by)
	{
		String text=driver.findElement(by).getText();
		return text;
	}
	public static String getDisabledElementText(final WebDriver driver,By by)
	{
		return driver.findElement(by).getAttribute("value");
	}
	public static WebElement findWebElement(final WebDriver driver,By by)
	{
		return driver.findElement(by);
	}
	public static List<WebElement> findWebElements(final WebDriver driver,By by)
	{
		return driver.findElements(by);
	}
	public static List<WebElement> findWebElements(final WebDriver driver,List<WebElement> listElement,By by,int i)
	{
		return listElement.get(i).findElements(by);
	}
	public static void selectByVisibleText(final WebDriver driver,By by, String visibleText)
	{
		WebElement element=driver.findElement(by);
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	public static void selectByIndex(final WebDriver driver,By by, int index)
	{
		WebElement element=driver.findElement(by);
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public static String getDropDownOptionText(final WebDriver driver,By by)
	{
		return new Select(driver.findElement(by)).getFirstSelectedOption().getText();
	}
	public static void takescreenshot(String filename,final WebDriver driver ) 
	{
		try
		{
			final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
			System.setProperty(ESCAPE_PROPERTY, "false");
			String location="test-output"+File.separator+"html";
			String failureImageFileName = location+File.separator+filename+".png"; 
			//WebDriver augmentedDriver = new Augmenter().augment(driver); 
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(screenshot, new File(failureImageFileName)); 
			String userDirector = System.getProperty("user.dir") + File.separator; 
			String screenshotLocation="html"+File.separator+filename+".png";
			Reporter.log("<a href='"+screenshotLocation+"'><img src='" + screenshotLocation + "' height='400' width='800'/></a> "+"<br />"); 
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static String getSelectedTextFromDropDown(final WebDriver driver,By by)
	{
		Select select = new Select(driver.findElement(by));
		return select.getFirstSelectedOption().getText();
		
	}
	
}
