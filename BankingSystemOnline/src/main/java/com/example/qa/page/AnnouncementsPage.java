package com.example.qa.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;

public class AnnouncementsPage extends Base {

	ActionDriver actiondriver = new ActionDriver();

	@FindBy(xpath = "//select[@class=\"custom-select custom-select-sm form-control form-control-sm\"]")
	WebElement show;// (dropdown menu)

	@FindBy(xpath = "//input[@class=\"form-control form-control-sm\"]")
	WebElement searchbar;// searchbar input

	@FindBy(xpath = "//button[@class=\"btn btn-flat btn-default btn-sm dropdown-toggle dropdown-icon\"][1]")
	WebElement action;// (click to edit and delete)

	@FindBy(xpath = "(//a[@class=\"dropdown-item edit_data\"])[1]")
	WebElement edit;// perform click to verify edit

	@FindBy(xpath = "(//a[@class=\"dropdown-item delete_data\"])[1]")
	WebElement delete;// perform click to verify delete
	@FindBy(xpath="//button[@id=\"confirm\"]")
	WebElement alertconfirm;
	@FindBy(xpath="(//button[@type='button' and @class='btn btn-secondary' and @data-dismiss='modal'])[1]")
	WebElement alertcancle;
	@FindBy (xpath="//a[@class=\"btn btn-flat btn-primary\"]")
	WebElement createnew;
	

	public AnnouncementsPage() {
		PageFactory.initElements(driver, this);
	}

	public void VerifyAnnouncementsPageOption(String searchvalue) {
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, show);
		actiondriver.sleepThread(1000);
		actiondriver.selectByIndex(show, 2);
		actiondriver.sleepThread(2000);
		actiondriver.type(searchbar, searchvalue);
		searchbar.sendKeys(Keys.ENTER);
		actiondriver.sleepThread(2000);		
		searchbar.clear();
		actiondriver.sleepThread(1000);
		actiondriver.click(driver, searchbar);
		actiondriver.click(driver, action);
		actiondriver.click(driver, edit);
		actiondriver.sleepThread(2000);
		driver.navigate().back();// perform to return action option
		
		actiondriver.sleepThread(3000);
		actiondriver.click(driver, action);
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, delete);
		actiondriver.sleepThread(2000);
		actiondriver.isAlertPresent(driver);
		//actiondriver.click(driver, alertconfirm);(can use for confirm)
		actiondriver.click(driver, alertcancle);
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, createnew);
		actiondriver.sleepThread(2000);
		driver.navigate().back();
		
		
		{
			System.out.println("Test is Completed");
		}
		
	}

}
