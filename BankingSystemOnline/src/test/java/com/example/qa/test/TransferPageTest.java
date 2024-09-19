package com.example.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;
import com.example.qa.page.DashboardPage;
import com.example.qa.page.LoginPage;
import com.example.qa.page.TransferPage;

public class TransferPageTest extends Base {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	TransferPage transferpage;

	public TransferPageTest() {
		super();

	}

	ActionDriver actiondriver = new ActionDriver();

	@AfterMethod
	public void VarifyLogout() {
		actiondriver.sleepThread(5000);
		dashboardpage.Varifylogout();
	}
	@BeforeMethod
	public void browserstart() {
 
		setUp();
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		transferpage = new TransferPage();
        loginpage.validateWithValidUseridValidPassword(prop.getProperty("userid"), prop.getProperty("password"));
        dashboardpage.Transfer();
	}
    @Test
    public void VarifyTransferPageOption()
    {
    	transferpage.VarifyTransferPageOption("6231415", "10140715", "1000");//(account number ,transfer to ac.no, transferamount)
    }
}
