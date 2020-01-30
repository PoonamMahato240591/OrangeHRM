
package com.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations2 {
	@BeforeTest
	public void gmailLaunch()
	{
		System.out.println("Gmail application Launch");
	}
	@Test(priority=1)
	public void logIn()
	{
		System.out.println("Gmail LogIn Successfull");
	}
	@Test(priority=2)
	public void inbox()
	{
		System.out.println("Testing InBox functionality");
	}
	@Test(enabled=false)
	public void composeMail()
	{
		System.out.println("Testing composeMail functionality");
	}
	@Test(priority=3)
	public void sendMail() {
		System.out.println("Testing sent mail functionality");
	}
@AfterTest
public void applicationClose()
{
	System.out.println("Gmail application close");
}
}


