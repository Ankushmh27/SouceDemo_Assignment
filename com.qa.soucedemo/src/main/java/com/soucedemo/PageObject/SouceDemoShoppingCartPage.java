package com.soucedemo.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SouceDemoShoppingCartPage 
{
	public WebDriver driver;

	//Page Factory 
	@FindBy(xpath = "//a[contains(@class,'shop')]")
	private WebElement shopCartLink;

	//Initializing the Page Objects:
	public SouceDemoShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickOnShoppingCartLink() throws InterruptedException
	{
		shopCartLink.click();
		Thread.sleep(2000);
	}
}
