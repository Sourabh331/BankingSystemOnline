package com.example.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;

public class SettingsPage extends Base{
	 
	 ActionDriver actiondriver = new ActionDriver();
	 
	 @FindBy(xpath="//input[@name=\"name\"]")
	 WebElement systemname;
	 
	 @FindBy(xpath="//input[@name=\"short_name\"]")
	 WebElement systemshortname;
	 
	 @FindBy(xpath="//div[@class=\"note-editable card-block\"]")
	 WebElement aboutus;

	 public SettingsPage() {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void VarifyPageOption(String name,String shortname,String note) {
		 
		 actiondriver.implicitWait(driver, 5);
		 actiondriver.click(driver, systemname);
		 actiondriver.type(systemname, name);
		 actiondriver.click(driver, systemshortname);
		 actiondriver.click(driver, aboutus);
		 actiondriver.type(aboutus, note);
	 }
}
