package com.yantra.auto.yrms.ui.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.yantra.auto.yrms.apirequest.RMSRequest;
import com.yantra.auto.yrms.apirequest.RestRequest;
import com.yantra.auto.yrms.driver.BaseClass;
import com.yantra.auto.yrms.driver.CommonFunctions;
import com.yantra.auto.yrms.driver.GlobalKeys;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.driver.MongoDBConnector;

import junit.framework.AssertionFailedError;

public class TransactionDocument 
{
	GlobalSettings gs=new GlobalSettings();
	public final static String transactionDocPage=GlobalSettings.getProperty(GlobalKeys.transactionDocumentPageLink);
	public final static String totalResults=GlobalSettings.getProperty(GlobalKeys.totalResults);
	public final static String transactionDocumentTableRows=GlobalSettings.getProperty(GlobalKeys.transactionDocumentTableRows);
	public final static String transactionDocumentTableHeader=GlobalSettings.getProperty(GlobalKeys.transactionDocumentTableHeader);
	public By transactionDocPageLink=By.xpath(transactionDocPage);
	public By totalResultCount=By.xpath(totalResults);
	public By TRANSACTIONDOCUMENTTABLEHEADER=By.xpath(transactionDocumentTableHeader);
	public By TRANSACTIONDOCUMENTROWS=By.xpath(transactionDocumentTableRows);
	public By RISKREPORTTRANSACTIONTYPE=By.xpath(GlobalSettings.getProperty(GlobalKeys.riskReportTransactionType));
	public By RISKREPORTSCORE=By.xpath(GlobalSettings.getProperty(GlobalKeys.riskReportScore));
	public By RISKREPORTDETAIL=By.xpath(GlobalSettings.getProperty(GlobalKeys.riskReportDetail));
	final WebDriver _driver;
	WebDriverWait wait;
	public TransactionDocument(final WebDriver driver)
	{
		this._driver=driver;
		wait=new WebDriverWait(_driver, 1000);
	}
	public void loginToTransactionDocument()
	{
		wait.until(ExpectedConditions.elementToBeClickable(transactionDocPageLink));
		CommonFunctions.clickField(_driver, transactionDocPageLink);
	}
	private Long getTotalTransactionCountFromDB()
	{
		MongoDBConnector.connectMongoDb();
		Long totalTransactionCount=MongoDBConnector.database.getCollection("transactionDocument").count();
		return totalTransactionCount;
	}
	public void checkTotalTransactionCount() 
	{
		String totalFromDb=getTotalTransactionCountFromDB().toString();
		String[] totalResultFromUi=CommonFunctions.getText(_driver, totalResultCount).split(" ");
		String totalResult=totalResultFromUi[0];
		org.testng.Assert.assertEquals(totalResult,totalFromDb);
		System.out.println(totalFromDb);
	}
	public void getTransactionDocuments() throws InterruptedException
	{
		String url=_driver.getCurrentUrl();
		String asset[]=url.split("#");
		String newUrl=asset[0]+"?format=&max=50&sort=id&order=desc";
		_driver.navigate().to(newUrl);
		List<WebElement> documentList=_driver.findElements(By.xpath(".//*[@id='list-transactionDocument']/table/tbody/tr"));
		//RestRequest.formRestRequest();
		for(int i=0;i<documentList.size();i++)
		{
			List<WebElement> documentEntry=documentList.get(i).findElements(By.tagName("td"));
			List<WebElement> columnText=documentEntry.get(3).findElements(By.tagName("p"));
			System.out.println(columnText.get(0).getText());
			if(columnText.get(0).getText().equalsIgnoreCase("100120840700000001001"))
			{
				int rowCount=i+1;
				By documentLink=By.xpath(".//*[@id='list-transactionDocument']/table/tbody/tr["+rowCount+"]/td[1]/a");
				WebElement transactionDocumentLink=CommonFunctions.findWebElement(_driver, documentLink);
				transactionDocumentLink.click();
				break;
			}
		}
	}
	/*public void checkRiskScore(String riskScoreFromData)
	{
		String url=_driver.getCurrentUrl();
		String asset[]=url.split("#");
		String newUrl=asset[0]+"?format=&max=50&sort=id&order=desc";
		_driver.navigate().to(newUrl);
	}*/
	public void navigateToTransactionRiskReportPage(String riskScore) throws InterruptedException
	{
		String url=_driver.getCurrentUrl();
		String asset[]=url.split("#");
		String newUrl=asset[0]+"?format=&max=50&sort=id&order=desc";
		_driver.navigate().to(newUrl);
		List<WebElement> documentList=CommonFunctions.findWebElements(_driver, TRANSACTIONDOCUMENTROWS);
		for(int i=0;i<documentList.size();i++)
		{
			List<WebElement> documentEntry=documentList.get(i).findElements(By.tagName("td"));
			WebElement masterAccountNumber=documentEntry.get(2).findElements(By.tagName("p")).get(0);
			try {Assert.assertEquals(masterAccountNumber.getText(), RMSRequest.maccountInputData.get(0).get(0));}
			catch(AssertionError e){CommonFunctions.takescreenshot("TRANSACTIONMASTERACCOUNTNUMBERASSERTFAILED", _driver);throw e;}
			WebElement tableHeader = _driver.findElement(TRANSACTIONDOCUMENTTABLEHEADER);
			String participantRiskHeader = tableHeader.findElements(By.tagName("th")).get(4).getText();
			System.out.println(participantRiskHeader);
			int riskScoreTableTagNumber=4;
			if(participantRiskHeader.equalsIgnoreCase("Participants")){riskScoreTableTagNumber=5;}
			WebElement riskScoreLink=documentEntry.get(riskScoreTableTagNumber).findElement(By.tagName("a"));
			try {Assert.assertEquals(riskScoreLink.getText(), riskScore);}
			catch(AssertionError e){CommonFunctions.takescreenshot("TRANSACTIONRISKASSERTFAILED", _driver);throw e;}
			if(riskScoreLink.getText().equalsIgnoreCase(riskScore))
			{
				CommonFunctions.clickElement(_driver, riskScoreLink);
				break;
			}
		}
	}
	public void checkRiskReportDetails(String riskScore,String ruleName,String transactionType)
	{
		SoftAssert softAssert = new SoftAssert();
		try
		{
			softAssert.assertEquals(CommonFunctions.getText(_driver, RISKREPORTTRANSACTIONTYPE),transactionType);
			String riskReportDetailList[]=CommonFunctions.getText(_driver, RISKREPORTDETAIL).split("\n");
			List<String> array=new ArrayList<String>();
			for(String riskReportDetail:riskReportDetailList)
			{
				array.add(riskReportDetail.split("=")[0]);
			}
			String isThere=null;
			for(String s : array)
			{
				isThere="not present";
				while(isThere.equalsIgnoreCase("not present"))
				{
					if(s.equalsIgnoreCase(ruleName))
						isThere=s;
						break;
				}
			}
			Assert.assertEquals(isThere,ruleName);
			String riskReportScore=CommonFunctions.getText(_driver, RISKREPORTSCORE);
			softAssert.assertEquals(riskReportScore, riskScore);
			softAssert.assertAll();
		}
		catch(AssertionError e)
		{
			CommonFunctions.takescreenshot("RiskScoreReportFailed", _driver);
			throw e;
		}
	}
}
