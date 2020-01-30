package com.Capturing_All_Links;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Capturing_All_Links_Of_NewTour {
WebDriver driver=null;
String url="http://newtours.demoaut.com";
File linkScreenShot=null;

@BeforeTest
public void setUp() {
	System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe" );
	driver= new ChromeDriver();
	driver.navigate().to(url);
	driver.manage().window().maximize();
}
@Test
public void links() throws InterruptedException, IOException {
	List<WebElement>links=driver.findElements(By.tagName("a"));
	int linksCount = links.size();
	System.out.println("The total number of links in Newtours Login Page are :"+linksCount);
	for(int i=0;i<linksCount;i++)
	{
		String linkName=links.get(i).getText();
		System.out.println(i+""+linkName);
		 links.get(i).click();
		System.out.println(driver.getTitle());
		System.out.println();	
	     linkScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(linkScreenShot,new File("./Screenshot/"+linkName+".png"));
				
		Thread.sleep(10000);	
		driver.navigate().back();
		links=driver.findElements(By.tagName("a"));
		
		}
 
}
@AfterTest
public void tearDown()
{
	driver.quit();
}
}
