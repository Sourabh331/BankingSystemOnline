package com.example.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;

public class WithdrawPage extends Base{
	
ActionDriver actiondriver = new ActionDriver();
	
	@FindBy(xpath = "//input[@name=\"account_number\"]")
	WebElement accountnumber;
	
	@FindBy(xpath="//input[@name=\"balance\"]")
	WebElement withdrawbalace;
	
	@FindBy(xpath="//button [@class=\"btn btn-primary mr-2\"]")
	WebElement submit;
	@FindBy(xpath="//a [@class=\"btn btn-default\"]")
	WebElement cancel;

	public WithdrawPage() {
		PageFactory.initElements(driver, this);
	}
	
    public void VarifyWithdrawPageOptionTest(String myaccountnumber,String withdrawamount)
    {
    	actiondriver.sleepThread(2000);
    	actiondriver.click(driver, accountnumber);
    	actiondriver.type(accountnumber, myaccountnumber);
    	actiondriver.sleepThread(1000);
    	actiondriver.click(driver, withdrawbalace);
    	actiondriver.type(withdrawbalace, withdrawamount);
    	actiondriver.sleepThread(4000);
    	actiondriver.click(driver, submit);
    	
    }
}


