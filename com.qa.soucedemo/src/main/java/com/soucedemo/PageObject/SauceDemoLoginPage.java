package com.soucedemo.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLoginPage  
{
	public WebDriver driver;

	//Page Factory 
	@FindBy(id ="user-name")
	private WebElement username;

	@FindBy(id ="password")
	private WebElement password;

	@FindBy(id="login-button")
	private WebElement loginBtn;

	//Initializing the Page Objects:
	public SauceDemoLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String Username)
	{
		username.sendKeys(Username);		
	}
	public void enterPassword(String Password) 
	{
		password.sendKeys(Password);
	}

	public void clickOnLoginBtn() 
	{
		loginBtn.click();
	}

	public void ClearCredential() 
	{
		username.clear();
		password.clear();
	}




}
