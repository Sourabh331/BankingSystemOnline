package com.example.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;

public class TransferPage extends Base {

	ActionDriver actiondriver = new ActionDriver();

	@FindBy(xpath = "//input[@name=\"account_number\"]")
	WebElement accountnumber;

	@FindBy(xpath = "//input[@name=\"transfer_number\"]")
	WebElement transferto;
	@FindBy(xpath = "//input[@name=\"balance\"]")
	WebElement transferbalance;
	@FindBy(xpath="//button[@class=\"btn btn-primary mr-2\"]")
    WebElement submit;
	@FindBy(xpath="//a[@class=\"btn btn-default\"]")
    WebElement cancel;

	public TransferPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void VarifyTransferPageOption(String myaccountnumber, String transfertoac,String transferamount)
	{   
		   actiondriver.implicitWait(driver, 8);
	       actiondriver.click(driver, accountnumber);
	       actiondriver.type(accountnumber, myaccountnumber);
	       actiondriver.click(driver, transferto);
	       actiondriver.type(transferto, transfertoac);
	       actiondriver.click(driver, transferbalance);
	       actiondriver.type(transferbalance, transferamount);
//	       actiondriver.sleepThread(3000);//(only to see deatils)
	       actiondriver.click(driver, submit);
	      
	       
	       
	}
}
