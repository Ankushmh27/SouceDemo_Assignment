package com.SauceDemoTest;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.soucedemo.PageObject.SauceDemoLoginPage;
import com.soucedemo.PageObject.SouceDemoAddToCartPage;
import com.soucedemo.PageObject.SouceDemoBaseClass;
import com.soucedemo.PageObject.SouceDemoCheckoutPage;
import com.soucedemo.PageObject.SouceDemoHomePage;
import com.soucedemo.PageObject.SouceDemoLogoutPage;
import com.soucedemo.PageObject.SouceDemoShoppingCartPage;

public class TestClass extends SouceDemoBaseClass
{
		SauceDemoLoginPage login;
		SouceDemoHomePage filter;
		SouceDemoAddToCartPage addtocart;
		SouceDemoShoppingCartPage shopCart;
		SouceDemoCheckoutPage checkout;
		SouceDemoCheckoutPage info;
		SouceDemoLogoutPage logout;
		
		@Test(priority = 1)
		public void LoginTest() throws InterruptedException 
		{
			
			login = new SauceDemoLoginPage(driver);
			login.enterUsername("standard_user");
			Thread.sleep(2000);
			login.enterPassword("secret_sauce");
			Thread.sleep(2000);
			login.clickOnLoginBtn();
			Reporter.log("user login Successfully");
			Thread.sleep(3000);			
		}

		@Test(priority = 2)
		public void FilterItemsTest() throws InterruptedException 
		{
			filter = new SouceDemoHomePage(driver);
			filter.FilterDropDownItem();
			Reporter.log("Items filter by value z-a");
			Thread.sleep(2000);	
		}

		@Test(priority = 3)
		public void AddToCartTest() throws InterruptedException 
		{
			addtocart = new SouceDemoAddToCartPage(driver);
			addtocart.AddToCartBtn();
			Reporter.log("Items Add to cart");
			Thread.sleep(2000);	
		}

		@Test(priority = 4)
		public void SoppingCartTest() throws InterruptedException 
		{
			shopCart = new SouceDemoShoppingCartPage(driver);
			shopCart.ClickOnShoppingCartLink();
			Reporter.log("click on shopping cart link");
		}

		@Test(priority = 5)
		public void ItemCheckoutTest() throws InterruptedException 
		{
			checkout= new SouceDemoCheckoutPage(driver);
			checkout.ClickonCheckoutBtn();
			Reporter.log("Item checkout in cart");
		}

		@Test(priority = 6)
		public void FillYourInfoTest() throws InterruptedException 
		{
			info = new SouceDemoCheckoutPage(driver);
			info.EnterFname("James");
			Reporter.log("enter firstname");
			info.EnterLname("Bond");
			Reporter.log("enter lastname");
			info.EnterZipCode("");
			Reporter.log("blank Zip code");
			info.ClickOnContinueBtn();
			Reporter.log("Error: Postal Code is required");
		}

		@Test(priority = 7,dependsOnMethods = "LoginTest")
		public void LogoutTest() throws InterruptedException 
		{
			logout = new SouceDemoLogoutPage(driver);
			logout.clickOnMenuBar();
			Reporter.log("Click on MenuBar");
			Thread.sleep(2000);	
			logout.clickLogoutBtn();
			Reporter.log("Click on logout btn");
			Reporter.log("user logout succsessfully");
			Thread.sleep(2000);		
			TearDown();
		}
	}

