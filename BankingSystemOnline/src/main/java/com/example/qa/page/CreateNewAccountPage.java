package com.example.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;

public class CreateNewAccountPage extends Base {

	ActionDriver actiondriver = new ActionDriver();

	@FindBy(xpath = "//input[@name='account_number']")
	WebElement accountnumber;

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstname;

	@FindBy(xpath = "//input[@name='middlename']")
	WebElement middlename;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastname;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//button[@id='generate_pass']")
	WebElement genratepassword;
	@FindBy(xpath = "//input[@name='pin']")
	WebElement pin;
	@FindBy(xpath = "//input[@name='balance']")
	WebElement beginningbalance;
	@FindBy(xpath = "//button[@class='btn btn-primary mr-2']")
	WebElement save;

	public CreateNewAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public void VarifyCreateNewAccountTest(String myaccountnumber, String myfirstname, String mymiddlename,
			String mylastname, String myemail, String mypin, String mybeginningbalance) {
		
    	actiondriver.sleepThread(4000);
		actiondriver.type(accountnumber, myaccountnumber);
		actiondriver.type(firstname, myfirstname);
		actiondriver.type(middlename, mymiddlename);
		actiondriver.type(lastname, mylastname);
		actiondriver.type(email, myemail);
		actiondriver.click(driver, genratepassword);
		actiondriver.sleepThread(2000);
		actiondriver.type(pin, mypin);
		actiondriver.scrollByVisibilityOfElement(driver, save);
		actiondriver.type(beginningbalance, mybeginningbalance);
		actiondriver.sleepThread(3000);
		actiondriver.click(driver, save);
	}

}
