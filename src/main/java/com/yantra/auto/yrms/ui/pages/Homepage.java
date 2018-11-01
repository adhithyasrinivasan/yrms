package com.yantra.auto.yrms.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.yantra.auto.yrms.apirequest.RestRequest;
//import com.gargoylesoftware.htmlunit.javascript.host.media.presentation.PresentationConnection;
import com.yantra.auto.yrms.apirequest.RestTransaction;
import com.yantra.auto.yrms.driver.AutomationBase;
import com.yantra.auto.yrms.driver.CommonFunctions;
import com.yantra.auto.yrms.driver.ExcelConnectivity;
import com.yantra.auto.yrms.driver.GlobalKeys;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.driver.InputData;
import com.yantra.auto.yrms.driver.MongoDBConnector;
import com.yantra.auto.yrms.driver.util.GenerateUniqueData;

import freemarker.core._DelayedFTLTypeDescription;

public class Homepage 
{
	GlobalSettings gs=new GlobalSettings();
	private final static String usernamefield=GlobalSettings.getProperty(GlobalSettings.usernametextbox);
	private final static String username=GlobalSettings.getProperty(GlobalSettings.username);
	private final static String passwordfield=GlobalSettings.getProperty(GlobalSettings.passwordtextbox);
	private final static String password=GlobalSettings.getProperty(GlobalSettings.password);
	private final static String submitbutton=GlobalSettings.getProperty(GlobalSettings.submit_button);
	private final static String adminDetailInfo=GlobalSettings.getProperty(GlobalSettings.adminDetail);
	private final static String dailyvolume=GlobalSettings.getProperty(GlobalSettings.dailyvolume);
	private final static String dailycount=GlobalSettings.getProperty(GlobalSettings.dailycount);
	private final static String adminLink=GlobalSettings.getProperty(GlobalKeys.adminLink);
	private final static String userloginerrorfield=GlobalSettings.getProperty(GlobalSettings.loginerror);
	public By usernametext=By.id(usernamefield);
	public By passwordtext=By.id(passwordfield);
	public By submit=By.id(submitbutton);
	public By daily_volume=By.id(dailyvolume);
	public By daily_count=By.id(dailycount);
	public By admin_link=By.xpath(adminLink);
	public By ADMIN_DETAIL_LINK=By.xpath(adminDetailInfo);
	public By LOGOUT=By.linkText("Logut");
	public By LOGINERROR=By.cssSelector(userloginerrorfield);
	final WebDriver _driver;
	private String url=AutomationBase.getYrmsUrl();
	WebDriverWait wait;
	public Homepage(final WebDriver driver)
	{
		this._driver=driver;
		wait=new WebDriverWait(this._driver, 10);
	}
	public void navigatetoUrl()
	{
		_driver.get(url);
	}
	public void loginToRms() throws InterruptedException
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(usernametext));
		CommonFunctions.populateTextField(_driver,usernametext,username);
		wait.until(ExpectedConditions.presenceOfElementLocated(passwordtext));
		CommonFunctions.populateTextField(_driver,passwordtext,password);
		wait.until(ExpectedConditions.presenceOfElementLocated(submit));
		CommonFunctions.clickField(_driver,submit);
		if(ExpectedConditions.presenceOfElementLocated(By.xpath(GlobalSettings.getProperty(GlobalSettings.otp_label))) != null)
		{
			navigatetoUrl();/** need to handle otp login once deployed**/
		}
	}
	public void loginFailureCases(String user,String pass) throws InterruptedException
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(usernametext));
		CommonFunctions.populateTextField(_driver,usernametext,user);
		wait.until(ExpectedConditions.presenceOfElementLocated(passwordtext));
		CommonFunctions.populateTextField(_driver,passwordtext,pass);
		wait.until(ExpectedConditions.presenceOfElementLocated(submit));
		CommonFunctions.clickField(_driver,submit);
		String loginErrorMessage = CommonFunctions.getText(_driver, LOGINERROR);
		Assert.assertEquals(loginErrorMessage, GlobalSettings.getProperty("expectedLoginError"));
	}
	public void clickAdminLink() throws Exception
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(admin_link));
		CommonFunctions.clickField(_driver, admin_link);
	}
	public void checkTransVolume() throws Exception
	{
		Thread.sleep(1000);
		Assert.assertEquals(_driver.getCurrentUrl(),url+"/search/index");
		wait.until(ExpectedConditions.presenceOfElementLocated(daily_volume));
		String dailyvolume=CommonFunctions.getText(_driver, daily_volume);
		System.out.println("Daily transaction volume is : "+dailyvolume);
		String dailycount=CommonFunctions.getText(_driver, daily_count);
		System.out.println("Daily transaction count is : "+dailycount);
	}
	public void logout() throws Exception {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(ADMIN_DETAIL_LINK));
		CommonFunctions.clickField(_driver, ADMIN_DETAIL_LINK);
		_driver.navigate().to(url+"/logout/index");
		Assert.assertEquals(_driver.getCurrentUrl(),url+"/login/auth");
	}
}
