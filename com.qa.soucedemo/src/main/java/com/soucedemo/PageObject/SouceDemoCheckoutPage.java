package com.soucedemo.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SouceDemoCheckoutPage 
{
	public WebDriver driver;

	//Page Factory 
	@FindBy(id = "checkout")
	private WebElement checkout;

	@FindBy(id = "first-name")
	private WebElement Fname;

	@FindBy(id = "last-name")
	private WebElement Lname;

	@FindBy(id = "postal-code")
	private WebElement Zip;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	//Initializing the Page Objects:
	public SouceDemoCheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickonCheckoutBtn() throws InterruptedException
	{
		checkout.click();
		Thread.sleep(2000);	
	}

	public void EnterFname(String fName) throws InterruptedException 
	{
		Fname.sendKeys(fName);
		Thread.sleep(1000);	
	}

	public void EnterLname(String lName) throws InterruptedException 
	{
		Lname.sendKeys(lName);
		Thread.sleep(1000);	
	}

	public void EnterZipCode(String zip) throws InterruptedException 
	{
		Zip.sendKeys(zip);
		Thread.sleep(3000);	
	}
	public void ClickOnContinueBtn() throws InterruptedException 
	{
		continueBtn.click();
		Thread.sleep(5000);	
	}
}
