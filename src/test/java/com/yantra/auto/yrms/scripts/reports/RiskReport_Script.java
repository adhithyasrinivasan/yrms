package com.yantra.auto.yrms.scripts.reports;

import org.testng.annotations.Test;

import com.yantra.auto.yrms.driver.BaseClass;
import com.yantra.auto.yrms.driver.CommonFunctions;

public class RiskReport_Script extends BaseClass {

	@Test(priority=0)
	public void testRiskReport() throws Exception 
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		try{		_riskReportPage.navigateToRiskReportPage(); 	}
		catch (AssertionError e) { CommonFunctions.takescreenshot("RISKREPORTPAGE", driver); throw e;}
		_home.logout();
	}
}
