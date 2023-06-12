package com.soucedemo.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SouceDemoLogoutPage 
{
	public WebDriver driver;

	@FindBy(xpath = "//button[contains(@id,'react-burger-m')]")
	private WebElement menubar;
	
	@FindBy(xpath = "//a[contains(@id,'logout')]")
	private WebElement logoutbtn;

	public SouceDemoLogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickOnMenuBar() throws InterruptedException 
	{
		menubar.click();
		Thread.sleep(2000);	
	}
	public void clickLogoutBtn() throws InterruptedException 
	{
		logoutbtn.click();
		Thread.sleep(2000);	
	}
}
