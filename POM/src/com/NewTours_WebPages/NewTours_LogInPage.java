package com.NewTours_WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTours_LogInPage {
	
	// Object Repository Class
	
	// <a href="mercurysignon.php">SIGN-ON</a>
	//WebElement signOn=driver.findElement(By.linkText("SIGN-ON"));
	
	@FindBy(linkText="SIGN-ON")	
	WebElement signOn;
	
	public void SignOn()
	{
		signOn.click();
	}
	
	// <a href="mercuryregister.php">REGISTER</a>
	@FindBy(linkText="REGISTER")	
	WebElement Register;
	
	public void register()
	{
		Register.click();
	}
	
	@FindBy(name="userName")	
	WebElement UserName;
	
	@FindBy(name="password")	
	WebElement Password;

	@FindBy(name="login")	
	WebElement signIn;
	
	public void findAFlight(String userName,String password)
	{
		UserName.clear();
		UserName.sendKeys(userName);
		
		Password.clear();
		Password.sendKeys(password);
		signIn.click();
	}
	
	
	

	
	
	
	
	
	
}
