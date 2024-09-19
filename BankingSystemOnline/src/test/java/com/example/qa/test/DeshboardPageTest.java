package com.example.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;
import com.example.qa.page.DashboardPage;
import com.example.qa.page.LoginPage;
@Listeners(com.example.qa.utils.ExtentListener.class)
public class DeshboardPageTest extends Base {

	LoginPage loginPage;
	DashboardPage dashboardPage;

	public DeshboardPageTest() {
		super();

	}
	ActionDriver actiondriver = new ActionDriver();
	

	@BeforeMethod
	public void browserStart() {
		setUp();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		loginPage.validateWithValidUseridValidPassword(prop.getProperty("userid"), prop.getProperty("password"));
        
	}

	@AfterMethod
	public void varifylogoutTest() 
	{
		actiondriver.sleepThread(8000);
		dashboardPage.Varifylogout();
	}
	@Test
	 public void AccountManagementTest()
	 {
		dashboardPage.AccountManagement();
	 }
	

}
