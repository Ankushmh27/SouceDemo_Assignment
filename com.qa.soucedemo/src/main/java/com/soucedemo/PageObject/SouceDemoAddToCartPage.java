package com.soucedemo.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SouceDemoAddToCartPage 
{
	public WebDriver driver;
	//Page Factory 

	@FindBy(xpath = "//button[contains(@name,'add-to-cart-sauce-labs-ba')]")
	private WebElement addToCartBtn;

	//Initializing the Page Objects:
	public SouceDemoAddToCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void AddToCartBtn () throws InterruptedException 
	{
		addToCartBtn.click();
		Thread.sleep(2000);		
	}

}
