package com.yantra.auto.yrms.ui.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.bson.Document;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.yantra.auto.yrms.apirequest.RMSRequest;
import com.yantra.auto.yrms.driver.AutomationBase;
import com.yantra.auto.yrms.driver.CommonFunctions;
import com.yantra.auto.yrms.driver.GlobalKeys;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.driver.InputData;
import com.yantra.auto.yrms.driver.MongoDBConnector;
import com.yantra.auto.yrms.driver.util.GenerateUniqueData;

public class RulesPage 
{
	private WebDriver _driver;
	private WebDriverWait wait;
	private final static String rulesLink=GlobalSettings.getProperty(GlobalKeys.rulesLink);
	private final static String rulesListLink=GlobalSettings.getProperty(GlobalKeys.rulesListLink);
	private final static String newRuleLink=GlobalSettings.getProperty(GlobalKeys.newRuleLink);
	private final static String ruleNameField=GlobalSettings.getProperty(GlobalKeys.ruleNameField);
	private final static String statusDropDown=GlobalSettings.getProperty(GlobalKeys.ruleStatus);
	private final static String typeDropDown=GlobalSettings.getProperty(GlobalKeys.type);
	private final static String transactionTypeDropDown=GlobalSettings.getProperty(GlobalKeys.transactionType);
	private final static String riskPriority=GlobalSettings.getProperty(GlobalKeys.priority);
	private final static String riskOperator=GlobalSettings.getProperty(GlobalKeys.operator);
	private final static String riskOperatorValues=GlobalSettings.getProperty(GlobalKeys.values);
	private final static String riskScoreField=GlobalSettings.getProperty(GlobalKeys.riskScore);
	private final static String createButton=GlobalSettings.getProperty(GlobalKeys.createRule);
	private final static String createAssertText=GlobalSettings.getProperty(GlobalKeys.createRuleAssertText);
	private final static String updateButton=GlobalSettings.getProperty(GlobalKeys.updateButton);
	public By RULESLINK=By.xpath(rulesLink);
	public By RULESLIST_LINK=By.xpath(rulesListLink);
	public By NEWRULELINK=By.xpath(newRuleLink);
	public By RULENAME=By.id(ruleNameField);
	public By STATUS=By.id(statusDropDown);
	public By TYPE=By.id(typeDropDown);
	public By TRANSACTIONTYPE=By.id(transactionTypeDropDown);
	public By PRIORITY=By.id(riskPriority);
	public By OPERATOR=By.id(riskOperator);
	public By VALUES=By.id(riskOperatorValues);
	public By RISKSCORE=By.id(riskScoreField);
	public By CREATE=By.id(createButton);
	public By CREATEASSERT=By.className(createAssertText);
	public By UPDATEBUTTON=By.name(updateButton);
	private String rmsUrl;
	public RulesPage(WebDriver driver) 
	{
		this._driver = driver;
		wait=new WebDriverWait(this._driver,10 );
		rmsUrl=AutomationBase.getYrmsUrl();
		RMSRequest.loadData();
	}
	public void navigateToRulesPage()
	{
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(RULESLIST_LINK));
		CommonFunctions.clickField(_driver, RULESLIST_LINK);
		String pageHeader=CommonFunctions.getText(_driver, By.xpath(GlobalSettings.getProperty(GlobalKeys.rulesPageHeader)));
		try{Assert.assertEquals(pageHeader,"Rule List");}
		catch(AssertionError e){CommonFunctions.takescreenshot("RuleListFailed", _driver);throw e;}
	}
	public void navigateToAddRulePage()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(NEWRULELINK));
		CommonFunctions.clickField(_driver, NEWRULELINK);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(GlobalSettings.getProperty(GlobalKeys.addRulePageHeader))));
		String pageHeader=CommonFunctions.getText(_driver,By.xpath(GlobalSettings.getProperty(GlobalKeys.addRulePageHeader)));
		try { Assert.assertEquals(pageHeader, "Create Rule"); } 
		catch(AssertionError e){CommonFunctions.takescreenshot("NavigateRulePageFailed", _driver);throw e;}
	}
	public void addRule(String name,String transactionType,String type,String priority,String riskValue,String riskScore) throws InterruptedException
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(GlobalSettings.getProperty(GlobalKeys.addRulePageHeader))));
		String pageHeader=CommonFunctions.getText(_driver,By.xpath(GlobalSettings.getProperty(GlobalKeys.addRulePageHeader)));
		try { Assert.assertEquals(pageHeader, "Create Rule"); } 
		catch(AssertionError e){CommonFunctions.takescreenshot("AddRulePageFailed", _driver);throw e;}
		CommonFunctions.populateTextField(_driver, RULENAME, name);/**filling rule name**/
		CommonFunctions.selectByVisibleText(_driver, STATUS, "ACTIVE");/**selecting status**/
		CommonFunctions.selectByVisibleText(_driver, TRANSACTIONTYPE, transactionType);/**selecting transaction Type**/
		CommonFunctions.selectByVisibleText(_driver, TYPE, type);/**selecting type**/
		CommonFunctions.selectByVisibleText(_driver, PRIORITY, priority);/**selecting type**/
		CommonFunctions.selectByVisibleText(_driver, OPERATOR, "EQUAL_TO");/**selecting rule operator**/
		CommonFunctions.populateTextField(_driver, VALUES, riskValue);/**setting rule value**/
		if(CommonFunctions.getDropDownOptionText(_driver, PRIORITY).equalsIgnoreCase("CUSTOM"))
		{
			CommonFunctions.populateTextField(_driver, RISKSCORE, riskScore);
		}
		int ruleId=getNextRuleIdFromDb();
		ruleId=ruleId+1;
		String createAssertText="Rule "+ruleId+" created"; 
		CommonFunctions.clickField(_driver, CREATE); /**Creating rule**/
		wait.until(ExpectedConditions.presenceOfElementLocated(CREATEASSERT));
		try{Assert.assertEquals(CommonFunctions.getText(_driver, CREATEASSERT), createAssertText);}
		catch (AssertionError e) {CommonFunctions.takescreenshot("RuleCreationFailed", _driver);throw e; } 
	}
	public void disableRule(String ruleName)
	{
		String ruleId=getRuleIdFromDb(ruleName);
		String ruleEditUrl=rmsUrl+"/rule/edit/"+ruleId;
		_driver.navigate().to(ruleEditUrl);
		String ruleNameAssert=CommonFunctions.getDisabledElementText(_driver, RULENAME);
		try{Assert.assertEquals(ruleNameAssert,ruleName);}
		catch (AssertionError e) {CommonFunctions.takescreenshot("DisableRule"+ruleName+"Failed", _driver);throw e;}
		try{Assert.assertEquals(CommonFunctions.getDropDownOptionText(_driver, STATUS),"ACTIVE");}
		catch (AssertionError e) {CommonFunctions.takescreenshot("DisableRule"+ruleName+"Failed", _driver);throw e;}
		CommonFunctions.selectByVisibleText(_driver, STATUS, "DISABLED");
		CommonFunctions.clickField(_driver, UPDATEBUTTON);
		String updateAssertText="Rule "+ruleId+" updated";
		try{Assert.assertEquals(CommonFunctions.getText(_driver, CREATEASSERT), updateAssertText);}
		catch (AssertionError e) {CommonFunctions.takescreenshot("DisableRule"+ruleName+"Failed", _driver);throw e; }
		try{Assert.assertEquals(CommonFunctions.getDropDownOptionText(_driver, STATUS), "DISABLED");}
		catch (AssertionError e) {CommonFunctions.takescreenshot("DisableRule"+ruleName+"Failed", _driver);throw e; }
	}
	public void clickRulesLink()
	{
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(RULESLINK));
		CommonFunctions.clickField(_driver, RULESLINK);
	}
	public String getRuleIdFromDb(String name)
	{
		String id=null;
		String ruleName;
		FindIterable<Document> rulesCollection = MongoDBConnector.database.getCollection("rule").find();
		for(Document document : rulesCollection)
		{
			ruleName=document.getString("name");
			if(ruleName.equalsIgnoreCase(name))
			{
				id=document.getLong("_id").toString();
				break;
			}
		}
		return id;
	}
	public int getNextRuleIdFromDb()
	{
		Integer id=null;
		String ruleName;
		FindIterable<Document> rulesCollection = MongoDBConnector.database.getCollection("rule.next_id").find();
		for(Document document : rulesCollection)
		{
			id=document.getInteger("next_id");
			break;
		}
		return id;
	}
	
	public String getUniqueRuleName(String type)
	{
		String ruleName=null;
		while(ruleName==null)
		{
			ruleName=RandomStringUtils.randomAlphanumeric(5);
			ruleName=type+"_AUTO_RULE_"+ruleName;
			if(GenerateUniqueData.checkRuleName(ruleName))
				ruleName=null;
		}
		return ruleName;
		
	}
	
}
