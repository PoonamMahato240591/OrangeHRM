package com.NewTours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours_LogInTest {

	public static void main(String[] args) {
		String url="http://newtours.demoaut.com";
		WebDriver driver=null;
		System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(url);
		//<input type="text" name="userName" size="10">
		WebElement user=driver.findElement(By.name("userName"));
		user.sendKeys("tutorial");
		//<input type="password" name="password" size="10">
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("srini");
		//<input type="image" name="login" value="Login" src="/images/btn_signin.gif?osCsid=9fdcf6618d8458a2f307f5c76fabfb14" width="58" height="17" alt="Sign-In" border="0">
       WebElement SignIn=driver.findElement(By.name("login"));
       SignIn.click();
       String expected_HomePageTitle="Find";
       System.out.println("The expected Title of the new tours home page is: "+expected_HomePageTitle);
       String actual_webPageTitle=driver.getTitle();
       System.out.println("The actual title of the new tours web page is:"+actual_webPageTitle);
       if(actual_webPageTitle.contains(expected_HomePageTitle))
       {
    	   System.out.println("LogIn is successfull-Pass");
       }
       else
       {
    	   System.out.println("LogIn is Unsuccessfull-Fail");
       }
       driver.quit();
		
	}

}
