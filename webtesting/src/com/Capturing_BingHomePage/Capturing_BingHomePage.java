package com.Capturing_BingHomePage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Capturing_BingHomePage {
	WebDriver driver=null;
	String url="https://www.bing.com";
@BeforeTest
public void setUp()
{
	System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe");
	driver = new ChromeDriver();
	driver.navigate().to(url);
	driver.manage().window().maximize();
}
@Test(priority=1)
public void bing_Screenshot() throws InterruptedException, IOException
{
	Thread.sleep(10000);
	File bingScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(bingScreenShot,new File("./Screenshot/bing1.png"));
}
}
