package com.example.qa.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;

public class TransactionsPage extends Base{
	
	ActionDriver actiondriver = new ActionDriver();
	
	@FindBy(xpath="//select[@name=\"indi-list_length\"]")
	WebElement show;
	
	@FindBy(xpath="//input[@class=\"form-control form-control-sm\"]")
	WebElement searchtext;
	@FindBy(xpath="(//a[@class=\"page-link\"])[4]")
	WebElement nextpage;
	@FindBy(xpath="//a[@aria-controls=\"indi-list\"and @data-dt-idx=\"0\"]")
	WebElement previouspage;
	@FindBy(xpath="//div[@class=\"dataTables_filter\" and  @id=\"indi-list_filter\"]")
	WebElement surfaceclick;

	public TransactionsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void VarifyTransactionsPageOption(String abcdef)
	{
		actiondriver.sleepThread(1000);
		actiondriver.click(driver, show);
		actiondriver.sleepThread(1000);
		actiondriver.selectByIndex(show, 0);
		actiondriver.click(driver, show);
		actiondriver.click(driver, searchtext);
		actiondriver.type(searchtext, abcdef);
		searchtext.sendKeys(Keys.ENTER);
		actiondriver.sleepThread(1000);
		searchtext.clear();
		
		actiondriver.click(driver, searchtext);
		actiondriver.scrollByVisibilityOfElement(driver, nextpage);
		actiondriver.click(driver, nextpage);
		actiondriver.sleepThread(5000);
		actiondriver.scrollByVisibilityOfElement(driver, previouspage);
		actiondriver.click(driver, previouspage);
		
	}
	
	
	
	
}
