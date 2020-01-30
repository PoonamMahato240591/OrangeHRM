
	package com.TestNG;

	import org.testng.annotations.Test;

	public class Annottions1 {
		@Test(priority=1)
		public void gmailLaunch()
		{
			System.out.println("Gmail application Launch");
		}
		@Test(priority=2)
		public void logIn()
		{
			System.out.println("Gmail LogIn Successfull");
		}
		@Test(enabled=false)
		public void inbox()
		{
			System.out.println("Testing InBox functionality");
		}
		@Test(priority=4)
		public void composeMail()
		{
			System.out.println("Testing composeMail functionality");
		}

	}


