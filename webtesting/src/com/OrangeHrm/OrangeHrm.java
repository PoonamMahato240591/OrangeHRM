package com.OrangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrm {

	public static void main(String[] args) {
		String url="http://localhost/orangehrm/symfony/web/index.php/auth/login";
		System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to(url);
		String expected_titleOfLoginPage ="Orange";
		System.out.println("The expected title of Login page is: "+expected_titleOfLoginPage);
		String actual_titleOfLoginPage=driver.getTitle();
		System.out.println("The actual title of the Login page is: "+actual_titleOfLoginPage);
		if(actual_titleOfLoginPage.contains(expected_titleOfLoginPage))
		{
			System.out.println("There is match-PASS");
		}
		else
		{
			System.out.println("There is no match-Fail");
		}
		//<input name="txtUsername" id="txtUsername" type="text">
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");
		//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys("Admin123");
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		WebElement Login=driver.findElement(By.id("btnLogin"));
		Login.click();
		String expected_titleofhomepage="OrangeHRM";
		System.out.println("The expected title of home page is:"+expected_titleofhomepage);
		String actual_titleofhomepage=driver.getTitle();
		System.out.println("The actual title of the home page is:"+actual_titleofhomepage);
		if(actual_titleofhomepage.contains(expected_titleofhomepage))
		{
			System.out.println("Login is successfull-PASS");
		}
		else
		{
			System.out.println("Login is unsuccessfull-FAIL");
		}
		//driver.quit();
	}

}
