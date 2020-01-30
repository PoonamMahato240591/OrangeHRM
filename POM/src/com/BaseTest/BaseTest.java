package com.BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	// Global Declaration
	public	WebDriver driver = null;
	public String url="http://newtours.demoaut.com";
		
		@BeforeMethod
		public void setUp()
		{		
	System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.navigate().to(url);
			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}



}
