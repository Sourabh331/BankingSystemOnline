package com.example.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;
import com.example.qa.page.DashboardPage;
import com.example.qa.page.LoginPage;

public class LoginPageTest extends Base {

	LoginPage loginPage;
    DashboardPage dashboard;
    
	public LoginPageTest() {
		super();
	}
	
    ActionDriver  actiondriver = new ActionDriver();
    
	@BeforeMethod
	public void browserStart() {
		setUp();
		loginPage = new LoginPage();
	}
//	@AfterMethod
//	public void varifylogoutTest() 
//	{
//		actiondriver.sleepThread(8000);
//		dashboard.Varifylogout();
//	}
	
	@Test
	public void validateWithValidUseridValidPasswordTest() {
		loginPage.validateWithValidUseridValidPassword(prop.getProperty("userid"), prop.getProperty("password"));
	}

}
