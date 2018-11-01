package com.yantra.auto.yrms.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.gargoylesoftware.htmlunit.javascript.host.media.presentation.PresentationConnection;
import com.yantra.auto.yrms.apirequest.RestTransaction;
import com.yantra.auto.yrms.driver.AutomationBase;
import com.yantra.auto.yrms.driver.CommonFunctions;
import com.yantra.auto.yrms.driver.GlobalKeys;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.driver.MongoDBConnector;

public class Userspage 
{
	GlobalSettings gs=new GlobalSettings();
	private final static String usersPageLink=GlobalSettings.getProperty(GlobalKeys.usersPageLink);
	public By usersPage=By.xpath(usersPageLink);
	final WebDriver _driver;
	WebDriverWait wait;
	public Userspage(final WebDriver driver)
	{
		this._driver=driver;
		wait=new WebDriverWait(this._driver, 10);
	}
	public void loginToUserPage() throws Exception
	{
		wait.until(ExpectedConditions.elementToBeClickable(usersPage));
		CommonFunctions.clickField(_driver, usersPage);
		Thread.sleep(5000);
	}
}
