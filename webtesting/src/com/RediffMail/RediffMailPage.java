package com.RediffMail;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RediffMailPage {
WebDriver driver=null;
String url="https://www.rediffmail.com";


@BeforeTest
public void setUp() {
	System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe" );
	driver= new ChromeDriver();
	driver.navigate().to(url);
	driver.manage().window().maximize();
}
@Test
public void rediffMail()
{
	//<a href="http://register.rediff.com/register/register.php?FormName=user_details" title="Create Rediffmail Account">Create Account</a>
	WebElement rediff_CreateAccount=driver.findElement(By.linkText("Create Account"));
	rediff_CreateAccount.click();
	WebElement create_AccountPage=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[1]/td"));
	String actual_WebPage=create_AccountPage.getText();
	System.out.println(actual_WebPage);
	String expected_RediffCreatePage="Create";
	
	
	if(actual_WebPage.contains(expected_RediffCreatePage))
	{
		System.out.println("PASS");
	
	//<input type="text" onblur="fieldTrack(this);" name="namebcfc0457" value="" style="width:185px;" maxlength="61">
	WebElement fullName_Input=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input"));
	fullName_Input.sendKeys("Poonam");
	}
	else
	{
		System.out.println("FAIL");
	}
}	
     @AfterTest
      public void tearDown() {
    	  driver.quit();
     }
	
}

