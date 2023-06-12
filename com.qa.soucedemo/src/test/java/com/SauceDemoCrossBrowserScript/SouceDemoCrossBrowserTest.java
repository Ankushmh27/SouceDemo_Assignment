package com.SauceDemoCrossBrowserScript;

import java.time.Duration;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.soucedemo.PageObject.SauceDemoLoginPage;
import com.soucedemo.PageObject.SouceDemoLogoutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SouceDemoCrossBrowserTest 
{
	public WebDriver driver;

	@Test(priority = 1)
	@Parameters("browser")
	public void Setup(String browser) 
	{	
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setPlatform(Platform.WIN11);
			cap.setCapability(browser, true);
			cap.setVersion("114.1");
			//System.setProperty("webdriver.gecko.driver","E://EclipseProject//com.qa.soucedemo//Drivers//geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","E://EclipseProject//com.qa.soucedemo//Drivers//chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		driver.get("https://www.saucedemo.com/");	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority = 2)
	public void LoginTest() throws InterruptedException 
	{
		SauceDemoLoginPage login = new SauceDemoLoginPage(driver);
		login.enterUsername("standard_user");
		Thread.sleep(2000);
		login.enterPassword("secret_sauce");
		Thread.sleep(2000);
		login.clickOnLoginBtn();
		Reporter.log("user login Successfully");
		Thread.sleep(3000);			
	}
	@Test(priority = 3,dependsOnMethods = "LoginTest")
	public void LogoutTest() throws InterruptedException 
	{
		SouceDemoLogoutPage logout = new SouceDemoLogoutPage(driver);
		logout.clickOnMenuBar();
		Reporter.log("Click on MenuBar");
		Thread.sleep(2000);	
		logout.clickLogoutBtn();
		Reporter.log("Click on logout btn");
		Reporter.log("user logout succsessfully");
		Thread.sleep(2000);			
	}
	@AfterTest
	public void TearDown() 
	{
		driver.quit();
	}
}




