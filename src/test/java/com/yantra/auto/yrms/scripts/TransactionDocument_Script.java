package com.yantra.auto.yrms.scripts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import junit.framework.AssertionFailedError;

import com.yantra.auto.yrms.driver.AutomationBase;
import com.yantra.auto.yrms.driver.BaseClass;
import com.yantra.auto.yrms.driver.CommonFunctions;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.ui.pages.Homepage;

public class TransactionDocument_Script extends BaseClass
{
	@Test(priority=0,enabled=true,testName="NAVIGATE_TO_TRANSACTIONDOCUMENT_PAGE_YES")
	public void navigateToTransactionDocument() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_transactionDocument.loginToTransactionDocument();
		Thread.sleep(5000);
		_transactionDocument.getTransactionDocuments();
	}
	@Test(priority=1,enabled=true,testName="CHECK_TRANSACTION_COUNT_YES")
	public void checkTotalTransactionCount() throws Exception
	{
		try
		{
		_home.navigatetoUrl();
		_home.loginToRms();
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.checkTotalTransactionCount();
		}
		catch(AssertionError e)
		{
			CommonFunctions.takescreenshot("TotalTransactionCountMismatch", AutomationBase.driver);
			throw e;
		}
		catch(Exception e)
		{
			System.out.println("Normal Exception"+e);
			throw e;
		}
		
		
		
	}
	
}
