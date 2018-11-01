package com.yantra.auto.yrms.scripts;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.yantra.auto.yrms.driver.AutomationBase;
import com.yantra.auto.yrms.driver.BaseClass;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.driver.InputData;
import com.yantra.auto.yrms.ui.pages.Homepage;

public class HomePage_Script extends BaseClass
{
	@Test(priority=0,testName="TEST_LOAD_URL_YES")
	public void testLoadUrl()
	{
		_home.navigatetoUrl();
	}
	@Test(priority=1,testName="TEST_LOGIN_YES")
	public void login() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_home.logout();
	}
	@Test(priority=3,testName="TEST_CHECK_TOTALTRANSACTIONS_YES")
	public void totalTransactionData() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_home.checkTransVolume();
		_home.logout();
	}
	@Test(priority=2,testName="TEST_LOGIN_FAILURE_YES")
	public void testLoginFailure() throws Exception
	{
		List<List<String>> userList = InputData.data.get("USERS_LIST");
		for(List<String> users:userList)
		{
			_home.navigatetoUrl();
			_home.loginFailureCases(users.get(0),users.get(1));
		}
	}
}
