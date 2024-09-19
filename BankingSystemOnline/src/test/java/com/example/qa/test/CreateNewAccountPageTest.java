package com.example.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;
import com.example.qa.page.CreateNewAccountPage;
import com.example.qa.page.DashboardPage;
import com.example.qa.page.LoginPage;

public class CreateNewAccountPageTest extends Base {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CreateNewAccountPage createnewaccountpage;
	

	public CreateNewAccountPageTest() {
		super();

	}

	ActionDriver actiondriver = new ActionDriver();

	@BeforeMethod
	public void browserStart() {
		setUp();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		createnewaccountpage=new CreateNewAccountPage();
		loginPage.validateWithValidUseridValidPassword(prop.getProperty("userid"), prop.getProperty("password"));
		dashboardPage.AccountManagement();
	}

	@AfterMethod
	public void varifylogoutTest() 
	{
		actiondriver.sleepThread(8000);
		dashboardPage.Varifylogout();
	}
	
	@Test
	public void VarifyCreateAccount()
	{
		createnewaccountpage.VarifyCreateNewAccountTest("1238456", "Sourabh", "Kumar", "Mahule","xyz@gmail.com","4321","300");
	}

}
