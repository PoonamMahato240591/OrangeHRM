package com.BrowserAutomation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserAutomation {

	public static void main(String[] args) {
	//System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		//ChromeDriver cd = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","./driverFiles/geckodriver.exe");
		//FirefoxDriver fd = new FirefoxDriver();
        System.setProperty("webdriver.edge.driver", "./driverFiles/MicrosoftWebDriver.exe");
        EdgeDriver edge_driver = new EdgeDriver();
		edge_driver.get("http://facebook.com");
		
		edge_driver.close();

	}

}
