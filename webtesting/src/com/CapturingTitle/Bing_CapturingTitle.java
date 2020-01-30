package com.CapturingTitle;

import org.openqa.selenium.chrome.ChromeDriver;

public class Bing_CapturingTitle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String url="http://www.bing.com";
		//driver.get(url);
		driver.navigate().to(url);
	String actual_BingHomePageTittle=driver.getTitle();
System.out.println("The tittle of the web page is: "+actual_BingHomePageTittle);
driver.quit();
String expected_BingHomePageTittle="bing";
if(actual_BingHomePageTittle.equals(expected_BingHomePageTittle))
{
	System.out.println("The actual result is equal to the expected result");
	
}
else
{
	System.out.println("The actual result is not equal to the expected result");
}
	}

}
