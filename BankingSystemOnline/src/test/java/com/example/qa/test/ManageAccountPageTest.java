package com.example.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;
import com.example.qa.page.DashboardPage;
import com.example.qa.page.LoginPage;
import com.example.qa.page.ManageAccountPage;


public class ManageAccountPageTest extends Base{

	LoginPage loginpage;
	DashboardPage dashboardpage;
	ManageAccountPage manageaccountpage;
	
	public ManageAccountPageTest()
	{
		super();
	}
	ActionDriver actiondriver = new ActionDriver();
	
	@AfterMethod
	public void VarifyLogout() {
		actiondriver.sleepThread(5000);
		dashboardpage.Varifylogout();
	}
    @BeforeMethod
    public void browserstart()
    {
    	setUp();
    	loginpage = new LoginPage();
    	dashboardpage = new DashboardPage();
    	manageaccountpage = new ManageAccountPage();
    	loginpage.validateWithValidUseridValidPassword(prop.getProperty("userid"),prop.getProperty("password"));
    	dashboardpage.ManageAccount();
    	
    }
    @Test
    public void VerifyManageAccountPageOptionTest()
    {
    	manageaccountpage.VerifyPageOption("searchvalue");
    }
	
	
}
