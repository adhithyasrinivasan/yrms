package com.yantra.auto.yrms.ui.pages.Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.yantra.auto.yrms.driver.CommonFunctions;
import com.yantra.auto.yrms.driver.GlobalKeys;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.driver.MongoDBConnector;

public class RiskReportPage {
	GlobalSettings gs=new GlobalSettings();
	private final static String reportsLink=GlobalSettings.getProperty(GlobalKeys.reportsLink);
	private final static String riskReportsCount=GlobalSettings.getProperty(GlobalKeys.riskReportResults);
	public By REPORTSLINK=By.xpath(reportsLink);
	public By RISKREPORTSLINK=By.linkText("Risk Report");
	public By RISKRESULTS=By.xpath(riskReportsCount);
	final WebDriver _driver;
	WebDriverWait wait;
	public RiskReportPage(final WebDriver driver)
	{
		this._driver=driver;
		wait=new WebDriverWait(this._driver, 10);
	}
	public void navigateToRiskReportPage() throws InterruptedException
	{	
		wait.until(ExpectedConditions.presenceOfElementLocated(REPORTSLINK));
		CommonFunctions.clickField(_driver, REPORTSLINK);
		wait.until(ExpectedConditions.presenceOfElementLocated(RISKREPORTSLINK));
		CommonFunctions.clickField(_driver, RISKREPORTSLINK);
		wait.until(ExpectedConditions.presenceOfElementLocated(RISKRESULTS));
		String riskCount=CommonFunctions.getText(_driver, RISKRESULTS);
		String[] riskCountArray = riskCount.split(" ");
		riskCount=riskCountArray[0];
		long dbCount=getDbRiskCount();
		Assert.assertEquals(Long.parseLong(riskCount), dbCount);
		
	}
	private long getDbRiskCount()
	{
		long count = MongoDBConnector.database.getCollection("transactionRiskReport").count();
		return count;
	}
}