package com.example.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;
import com.example.qa.page.DashboardPage;
import com.example.qa.page.DepositPage;
import com.example.qa.page.LoginPage;
import com.example.qa.page.WithdrawPage;

public class  WithdrawPageTest extends Base {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	WithdrawPage withdrawpage;
	DepositPage deposWithdrawPageTestitpage;

	public WithdrawPageTest() {
		super();
	}

	ActionDriver actiondriver = new ActionDriver();

	@BeforeMethod
	public void browserstart()

	{
		setUp();
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		withdrawpage = new WithdrawPage();
		loginpage.validateWithValidUseridValidPassword(prop.getProperty("userid"), prop.getProperty("password"));
		dashboardpage.Withdraw();

	}
	@AfterMethod
	public void VarifyLogout() {
		actiondriver.sleepThread(5000);
		dashboardpage.Varifylogout();
	}
	@Test
	public void VarifyWithdrawPageOptionTest()
	{
		withdrawpage.VarifyWithdrawPageOptionTest("6231415", "1000");
	}

}
