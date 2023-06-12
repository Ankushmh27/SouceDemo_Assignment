package com.soucedemo.PageObject;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SouceDemoBaseClass 
{
	public WebDriver driver;

	@BeforeClass
	public void Setup() 
	{	
//		//Check if parameter passed from TestNG is 'firefox'
//		if(browser.equalsIgnoreCase("firefox")){
//			//create firefox instance
//			DesiredCapabilities cap = new DesiredCapabilities();
//			cap.setPlatform(Platform.WIN11);
//			cap.setCapability(browser, true);
//			cap.setVersion("114.1");
//			//System.setProperty("webdriver.gecko.driver","E://EclipseProject//com.qa.soucedemo//Drivers//geckodriver.exe");
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		//Check if parameter passed as 'chrome'
//		else if(browser.equalsIgnoreCase("chrome")){
//			//set path to chromedriver.exe
//			System.setProperty("webdriver.chrome.driver","E://EclipseProject//com.qa.soucedemo//Drivers//chromedriver.exe");
//			//create chrome instance
//			driver = new ChromeDriver();
//		}
		System.setProperty("webdriver.chrome.driver","E://EclipseProject//com.qa.soucedemo//Drivers//chromedriver.exe");
		//create chrome instance
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterClass
	public void TearDown() 
	{
		driver.quit();
	}
}

