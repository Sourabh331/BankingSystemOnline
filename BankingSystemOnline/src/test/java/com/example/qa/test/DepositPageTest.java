package com.example.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;
import com.example.qa.page.DashboardPage;
import com.example.qa.page.DepositPage;
import com.example.qa.page.LoginPage;

public class DepositPageTest extends Base {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	DepositPage depositpage;

	public DepositPageTest() {
		super();
	}

	ActionDriver actiondriver = new ActionDriver();

	@BeforeMethod
	public void browserstart()

	{
		setUp();
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		depositpage = new DepositPage();
		loginpage.validateWithValidUseridValidPassword(prop.getProperty("userid"), prop.getProperty("password"));
		dashboardpage.Deposit();

	}
	@AfterMethod
	public void varifylogoutTest() 
	{
		actiondriver.sleepThread(8000);
		dashboardpage.Varifylogout();
	}
	
	@Test
	public void VarifyDepositPageOption()
	{
		depositpage.VarifyDepositPageOption("6231415","3000");
	}

}