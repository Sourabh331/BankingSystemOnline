package com.example.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;

public class DashboardPage extends Base {

	ActionDriver actiondriver = new ActionDriver();

	@FindBy(xpath = "//span[contains(text(),'Adminstrator Admin')]")
	WebElement AdminstratorAdmin;

	@FindBy(xpath = "//a[@href=\"http://localhost/banking//classes/Login.php?f=logout\"]")
	WebElement logoutButton;

	@FindBy(xpath = "//i[@class=\"nav-icon fas fa-id-card\"]")
	WebElement accountmanagement;

	@FindBy(xpath = "//i[@class=\"far fa-circle nav-icon\"]")
	WebElement newaccount;

	@FindBy(xpath = "//li/a[@href=\"./?page=accounts\"]/i[@class=\"far fa-circle nav-icon\"]")
	WebElement manageaccount;
	@FindBy(xpath = "//i[@class=\"nav-icon fas fa-th-list\"]")
	WebElement transaction;
	@FindBy(xpath = "(//i[@class=\"far fa-circle nav-icon\"])[3]")
	WebElement transactions;
	@FindBy(xpath = "(//i[@class=\"far fa-circle nav-icon\"])[4]")
	WebElement deposit;
	@FindBy(xpath = "(//i[@class=\"far fa-circle nav-icon\"])[5]")
	WebElement withdraw;
	@FindBy(xpath = "(//i[@class=\"far fa-circle nav-icon\"])[6]")
	WebElement transfer;
	@FindBy(xpath = "//i[@class=\"nav-icon fas fa-bullhorn\"]")
	WebElement Announcements;
	@FindBy(xpath = "//i[@class=\"nav-icon fas fa-cogs\"]")
	WebElement settings;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public void Varifylogout() {
		actiondriver.click(driver, AdminstratorAdmin);
		actiondriver.click(driver, logoutButton);
		driver.close();
	}

	public void AccountManagement() {
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, accountmanagement);
		actiondriver.click(driver, newaccount);
		actiondriver.sleepThread(4000);
		
	}

	public void ManageAccount() {
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, accountmanagement);
		actiondriver.sleepThread(3000);
		actiondriver.click(driver, manageaccount);
	}

	public void Transactions() {
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, transaction);
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, transactions);

	}

	public void Deposit() {
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, transaction);
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, deposit);

	}

	public void Withdraw() {
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, transaction);
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, withdraw);

	}

	public void Transfer() {
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, transaction);
		actiondriver.sleepThread(2000);
		actiondriver.click(driver, transfer);

	}

	public void AnnouncementPage() {
       actiondriver.sleepThread(1000);
       actiondriver.click(driver, Announcements);
             
	}
	public void Settings() {
	       actiondriver.sleepThread(1000);
	       actiondriver.click(driver, settings);
	             
		}

}
