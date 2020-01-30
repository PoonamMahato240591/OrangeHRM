package com.Facebookloginpage;

import org.openqa.selenium.chrome.ChromeDriver;

public class Facebookloginpage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		String url="http://www.facebook.com";
		driver.navigate().to(url);
		String expected_Facebookloginpageurl="facebook.com";
		String actual_Facebookloginpageurl=driver.getCurrentUrl();
		String expected_title="Facebook";
		String actual_title=driver.getTitle();
		System.out.println("The actual title of the web page is :  "+actual_title);
		System.out.println("The actual facebook login page url: "+actual_Facebookloginpageurl);
		if(actual_Facebookloginpageurl.contains(expected_Facebookloginpageurl) && actual_title.contains(expected_title))
		{
			System.out.println("URL matched-Pass");
		}
		else
		{
			System.out.println("URL not matched-Fail");
		}
		driver.quit();

	}

}
