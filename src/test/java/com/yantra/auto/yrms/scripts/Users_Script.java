package com.yantra.auto.yrms.scripts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.yantra.auto.yrms.driver.BaseClass;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.ui.pages.Homepage;

public class Users_Script extends BaseClass
{
	@Test(priority=0)
	public void navigateToUsersPage() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_home.clickAdminLink();
		_users.loginToUserPage();
		Thread.sleep(5000);
	}
	
}
