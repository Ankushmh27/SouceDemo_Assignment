package com.soucedemo.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SouceDemoHomePage 
{
	public WebDriver driver;
	//Page Factory 

	@FindBy(xpath = "//select[contains(@class,'product_sort')]")
	private WebElement dropdown;

	//Initializing the Page Objects:
	public SouceDemoHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void FilterDropDownItem() throws InterruptedException 
	{
		Select select = new Select(dropdown);
		select.selectByValue("za");	
		Thread.sleep(2000);
	}
}
