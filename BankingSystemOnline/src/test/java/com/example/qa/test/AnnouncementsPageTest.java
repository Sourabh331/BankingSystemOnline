package com.example.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;
import com.example.qa.page.AnnouncementsPage;
import com.example.qa.page.DashboardPage;
import com.example.qa.page.LoginPage;

public class AnnouncementsPageTest extends Base {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	AnnouncementsPage announcementpage;
	
	public AnnouncementsPageTest()
	{
		super();
	}
	ActionDriver actiondriver = new ActionDriver();
	
    @BeforeMethod
    public void browserstart()
    {
    	setUp();
    	loginpage = new LoginPage();
    	dashboardpage = new DashboardPage();
    	announcementpage = new AnnouncementsPage();
    	loginpage.validateWithValidUseridValidPassword(prop.getProperty("userid"),prop.getProperty("password"));
    	dashboardpage.AnnouncementPage();
    	
    	
    }
	@AfterMethod
	public void varifylogoutTest() 
	{
		actiondriver.sleepThread(8000);
		dashboardpage.Varifylogout();
	}
		
    @Test
    public void VerifyAnnouncementsPageOption()
    {
    	announcementpage.VerifyAnnouncementsPageOption("Search Value");
    }
    
	
	
}

