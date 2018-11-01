package com.yantra.auto.yrms.scripts;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yantra.auto.yrms.apirequest.RMSRequest;
import com.yantra.auto.yrms.apirequest.RestService;
import com.yantra.auto.yrms.apirequest.RestTransaction;
import com.yantra.auto.yrms.data.MainRequest;
import com.yantra.auto.yrms.driver.BaseClass;
import com.yantra.auto.yrms.driver.CommonFunctions;
import com.yantra.auto.yrms.driver.util.DateUtil;
import com.yantra.auto.yrms.driver.util.GenerateUniqueData;
import com.yantra.auto.yrms.driver.util.GetMachineFingerprint;

public class RulesPage_Script extends BaseClass
{
	@Test(priority=0,testName="NAVIGATE_TO_RULE_LIST_YES")
	public void testNavigateToRulesPage() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_home.logout();
	}
	@Test(priority=1,testName="NAVIGATE_TO_ADD_RULE_PAGE_YES")
	public void testNavigateToAddRulePage() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		_home.logout();
	}
	@Test(priority=2,testName="TEST_MASTER_HOLDER_NAME_RULE_YES")
	public void testMasterHolderNameRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MHolderName");
		String riskScore="175";
		_rulesPage.addRule(ruleName,"ALL","MASTER HOLDER NAME","CUSTOM",RMSRequest.maccountInputData.get(0).get(9),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=3,testName="TEST_SECONDARY_HOLDER_NAME_RULE_YES")
	public void testSecondaryHolderNameRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SHolderName");
		String riskScore="176";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY HOLDER NAME","CUSTOM",RMSRequest.saccountInputData.get(0).get(22),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=4,testName="TEST_MASTER_HOLDER_ID_RULE_YES")
	public void testMasterHolderIDRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MHolderID");
		String riskScore="177";
		_rulesPage.addRule(ruleName,"ALL","MASTER HOLDER ID","CUSTOM",RMSRequest.maccountInputData.get(0).get(8),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=5,testName="TEST_SECONDARY_HOLDER_ID_RULE_YES")
	public void testSecondaryHolderIDRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SHolderID");
		String riskScore="178";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY HOLDER ID","CUSTOM",RMSRequest.saccountInputData.get(0).get(11),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=6,testName="TEST_MASTER_HOLDER_DOB_RULE_YES") 
	public void testMasterDOBRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MHolderDOB");
		String riskScore="179";
		_rulesPage.addRule(ruleName,"ALL","MASTER DATE OF BIRTH","CUSTOM",RMSRequest.maccountInputData.get(0).get(15),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=7,testName="TEST_MASTER_HOLDER_DOE_RULE_YES") 
	public void testMasterDOERule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MHolderDOE");
		String riskScore="180";
		_rulesPage.addRule(ruleName,"ALL","MASTER DATE OF ESTABLISHMENT","CUSTOM",RMSRequest.maccountInputData.get(0).get(12),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=8,testName="TEST_SECONDARY_HOLDER_DOB_RULE_YES") 
	public void testSecondaryDOBRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SHolderDOB");
		String riskScore="181";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY DATE OF BIRTH","CUSTOM",RMSRequest.saccountInputData.get(0).get(8),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=9,testName="TEST_SECONDARY_HOLDER_DOE_RULE_YES") 
	public void testSecondaryDOERule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SHolderDOE");
		String riskScore="182";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY DATE OF ESTABLISHMENT","CUSTOM",RMSRequest.saccountInputData.get(0).get(13),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=10,testName="TEST_MACHINE_IP_RULE_YES") 
	public void testMFPIPRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MFPIP");
		String riskScore="183";
		_rulesPage.addRule(ruleName,"ALL","MFP IP ADDRESS","CUSTOM",GetMachineFingerprint.getMachineAddress("ipaddress"),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=11,testName="TEST_MACHINE_MAC_RULE_YES") 
	public void testMFPMACRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MFPMAC");
		String riskScore="184";
		_rulesPage.addRule(ruleName,"ALL","MFP MAC ADDRESS","CUSTOM",GetMachineFingerprint.getMachineAddress("macaddress"),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=12,testName="TEST_TRANSACTION_NUMBER_RULE_YES") 
	public void testTransactionNumberRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("TransNumber");
		String riskScore="185";
		_rulesPage.addRule(ruleName,"ALL","TRANSACTION NUMBER","CUSTOM",RMSRequest.transactionInputData.get(0).get(5),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=13,testName="TEST_TRANSACTION_CODE_RULE_YES") 
	public void testTransactionCodeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("TransCode");
		String riskScore="186";
		_rulesPage.addRule(ruleName,"ALL","TRANSACTION CODE","CUSTOM",RMSRequest.transactionInputData.get(0).get(2),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=14,testName="TEST_SETTLEMENT_TYPE_RULE_YES") 
	public void testSettlementTypeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SettlementType");
		String riskScore="187";
		_rulesPage.addRule(ruleName,"ALL","SETTLEMENT TYPE","CUSTOM",RMSRequest.transactionInputData.get(0).get(7),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=15,testName="TEST_PROCESSING_CODE_RULE_YES") 
	public void testProcessingCodeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("ProcessCode");
		String riskScore="188";
		_rulesPage.addRule(ruleName,"ALL","PROCESSING CODE","CUSTOM",RMSRequest.transactionInputData.get(0).get(9),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=16,testName="TEST_ORIGIN_COUNTRY_CODE_RULE_YES") 
	public void testOriginCountryCodeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("OriginCode");
		String riskScore="189";
		_rulesPage.addRule(ruleName,"ALL","ORIGIN COUNTRY CODE","CUSTOM",RMSRequest.transactionInputData.get(0).get(10),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=17,testName="TEST_RECEIVING_COUNTRY_CODE_RULE_YES") 
	public void testReceivingCountryCodeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("ReceivingCode");
		String riskScore="190";
		_rulesPage.addRule(ruleName,"ALL","RECEIVING COUNTRY CODE","CUSTOM",RMSRequest.transactionInputData.get(0).get(11),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=18,testName="TEST_MASTER_HOLDER_CITY_RULE_YES") 
	public void testMasterHolderCityRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MHCity");
		String riskScore="191";
		_rulesPage.addRule(ruleName,"ALL","MASTER HOLDER CITY","CUSTOM",RMSRequest.maccountInputData.get(0).get(19),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=19,testName="TEST_MASTER_HOLDER_STATE_RULE_YES") 
	public void testMasterHolderStateRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MHState");
		String riskScore="192";
		_rulesPage.addRule(ruleName,"ALL","MASTER HOLDER STATE","CUSTOM",RMSRequest.maccountInputData.get(0).get(20),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=20,testName="TEST_MASTER_HOLDER_ZIPCODE_RULE_YES") 
	public void testMasterHolderZipCodeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MHZipCode");
		String riskScore="193";
		_rulesPage.addRule(ruleName,"ALL","MASTER HOLDER ZIPCODE","CUSTOM",RMSRequest.maccountInputData.get(0).get(21),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=21,testName="TEST_MASTER_HOLDER_COUNTRYCODE_RULE_YES") 
	public void testMasterHolderCountryCodeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MHCountryCode");
		String riskScore="194";
		int countryCode=DateUtil.getNumericCountryCode(RMSRequest.maccountInputData.get(0).get(22));
		_rulesPage.addRule(ruleName,"ALL","MASTER HOLDER COUNTRYCODE","CUSTOM",String.valueOf(countryCode),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=22,testName="TEST_SECONDARY_HOLDER_CITY_RULE_YES") 
	public void testSecondaryHolderCityRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SHCity");
		String riskScore="195";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY HOLDER CITY","CUSTOM",RMSRequest.saccountInputData.get(0).get(18),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=23,testName="TEST_SECONDARY_HOLDER_STATE_RULE_YES") 
	public void testSecondaryHolderStateRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SHState");
		String riskScore="196";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY HOLDER STATE","CUSTOM",RMSRequest.saccountInputData.get(0).get(19),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=24,testName="TEST_SECONDARY_HOLDER_ZIPCODE_RULE_YES") 
	public void testSecondaryHolderZipCodeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SHZipCode");
		String riskScore="197";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY HOLDER ZIPCODE","CUSTOM",RMSRequest.saccountInputData.get(0).get(20),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=25,testName="TEST_SECONDARY_HOLDER_COUNTRYCODE_RULE_YES") 
	public void testSecondaryHolderCountryCodeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SHCountryCode");
		String riskScore="198";
		int countryCode=DateUtil.getNumericCountryCode(RMSRequest.saccountInputData.get(0).get(21));
		_rulesPage.addRule(ruleName,"ALL","SECONDARY HOLDER COUNTRYCODE","CUSTOM",String.valueOf(countryCode),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=26,testName="TEST_MASTER_ACCOUNT_NUMBER_RULE_YES") 
	public void testMasterAccountNumberRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MAccNumber");
		String riskScore="199";
		_rulesPage.addRule(ruleName,"ALL","MASTER ACCOUNT NUMBER","CUSTOM",RMSRequest.maccountInputData.get(0).get(0),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=27,testName="TEST_MASTER_ACCOUNT_TYPE_RULE_YES") 
	public void testMasterAccountTypeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MAccType");
		String riskScore="200";
		_rulesPage.addRule(ruleName,"ALL","MASTER ACCOUNT TYPE","CUSTOM",RMSRequest.maccountInputData.get(0).get(1),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=28,testName="TEST_MASTER_ACCOUNT_STATUS_RULE_YES") 
	public void testMasterAccountStatusRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MAccStatus");
		String riskScore="201";
		_rulesPage.addRule(ruleName,"ALL","MASTER ACCOUNT STATUS","CUSTOM",RMSRequest.maccountInputData.get(0).get(25),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=29,testName="TEST_MASTER_CURRENCY_CODE_RULE_YES") 
	public void testMasterCurrencyCodeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MAccCurrencyCode");
		String riskScore="202";
		_rulesPage.addRule(ruleName,"ALL","MASTER CURRENCY CODE","CUSTOM",RMSRequest.maccountInputData.get(0).get(2),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=30,testName="TEST_SECONDARY_ACCOUNT_NUMBER_RULE_YES") 
	public void testSecondaryAccountNumberRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SAcctNumber");
		String riskScore="203";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY ACCOUNT NUMBER","CUSTOM",RMSRequest.saccountInputData.get(0).get(1),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=31,testName="TEST_SECONDARY_ACCOUNT_TYPE_RULE_YES") 
	public void testSecondaryAccountTypeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SAcctType");
		String riskScore="204";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY ACCOUNT TYPE","CUSTOM",RMSRequest.saccountInputData.get(0).get(4),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=32,testName="TEST_SECONDARY_ACCOUNT_STATUS_RULE_YES") 
	public void testSecondaryAccountStatusRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SAcctStatus");
		String riskScore="205";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY ACCOUNT STATUS","CUSTOM",RMSRequest.saccountInputData.get(0).get(25),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=33,testName="TEST_SECONDARY_CURRENCY_CODE_RULE_YES") 
	public void testSecondaryAccountCurrencyCodeRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SCurrencyCode");
		String riskScore="206";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY CURRENCY CODE","CUSTOM",RMSRequest.saccountInputData.get(0).get(2),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=34,testName="TEST_MASTER_RUNNING_BALANCE_RULE_YES") 
	public void testMasterAccountRunningBalanceRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MRunningBalance");
		String riskScore="207";
		_rulesPage.addRule(ruleName,"ALL","MASTER RUNNING BALANCE","CUSTOM",RMSRequest.maccountInputData.get(0).get(26),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=35,testName="TEST_MASTER_TRIAL_BALANCE_RULE_YES") 
	public void testMasterAccountTrialBalanceRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MTrialBalance");
		String riskScore="208";
		_rulesPage.addRule(ruleName,"ALL","MASTER TRIAL BALANCE","CUSTOM",RMSRequest.maccountInputData.get(0).get(27),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=36,testName="TEST_MASTER_HOLD_BALANCE_RULE_YES") 
	public void testMasterAccountHoldBalanceRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("MHoldBalance");
		String riskScore="209";
		_rulesPage.addRule(ruleName,"ALL","MASTER HOLD BALANCE","CUSTOM",RMSRequest.maccountInputData.get(0).get(28),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=37,testName="TEST_SECONDARY_RUNNING_BALANCE_RULE_YES") 
	public void testSecondaryAccountRunningBalanceRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SRunningBalance");
		String riskScore="210";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY RUNNING BALANCE","CUSTOM",RMSRequest.saccountInputData.get(0).get(26),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=38,testName="TEST_SECONDARY_TRIAL_BALANCE_RULE_YES") 
	public void testSecondaryAccountTrialBalanceRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("STrialBalance");
		String riskScore="211";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY TRIAL BALANCE","CUSTOM",RMSRequest.saccountInputData.get(0).get(27),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=39,testName="TEST_SECONDARY_HOLD_BALANCE_RULE_YES") 
	public void testSecondaryAccountHoldBalanceRule() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("SHoldBalance");
		String riskScore="212";
		_rulesPage.addRule(ruleName,"ALL","SECONDARY HOLD BALANCE","CUSTOM",RMSRequest.saccountInputData.get(0).get(28),riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=40,testName="TEST_DORMANT_ACCOUNT_RULE_YES") 
	public void testDormantAccount() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("DormantAcc");
		String riskScore="213";
		MainRequest request=RMSRequest.formRawRequest();
		request.setTransactionDateTime(DateUtil.getCurrentMilliTime());
		String before=RMSRequest.mapper.writeValueAsString(request);
		try{RestTransaction.initiateYrmsQueueTransaction(before);} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.addRule(ruleName,"ALL","DORMANT_ACCOUNT","CUSTOM","2",riskScore);
		request.setTransactionDateTime(DateUtil.addDaysToTime(3));
		String after=RMSRequest.mapper.writeValueAsString(request);
		try{RestTransaction.initiateYrmsQueueTransaction(after);} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	@Test(priority=41,testName="TEST_TLIMITS_RULE_YES") 
	public void testTLimits() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_rulesPage.clickRulesLink();
		_rulesPage.navigateToRulesPage();
		_rulesPage.navigateToAddRulePage();
		String ruleName=_rulesPage.getUniqueRuleName("TLimits");
		String riskScore="214";
		_rulesPage.addRule(ruleName,"ALL","TLIMITS","CUSTOM","0-100",riskScore);
		try{RestTransaction.initiateYrmsQueueTransaction();} catch(Exception e) {e.printStackTrace();throw e;}
		_rulesPage.disableRule(ruleName);
		_transactionDocument.loginToTransactionDocument();
		_transactionDocument.navigateToTransactionRiskReportPage(riskScore);
		_transactionDocument.checkRiskReportDetails(riskScore,ruleName,RMSRequest.transactionInputData.get(0).get(0));
		_home.logout();
	}
	
}
