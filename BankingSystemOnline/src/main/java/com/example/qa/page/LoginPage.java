package com.example.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.qa.actiondriver.ActionDriver;
import com.example.qa.base.Base;

public class LoginPage extends Base {

	ActionDriver actiondriver = new ActionDriver();

	@FindBy(xpath = "//input[@name=\"username\"]")
	WebElement userName;

	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void validateWithValidUseridValidPassword(String userId, String pass) {
		actiondriver.type(userName, userId);
		actiondriver.type(password, pass);
		actiondriver.click(driver, loginButton);
	}
}
