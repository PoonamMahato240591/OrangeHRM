package com.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomatingFacebook {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String url="http://facebook.com";
		driver.navigate().to(url);
		//<input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="royal_email">
        //driver.findElement(By.id("email")).sendKeys("poonam.jnk@gmail.com");
        //<input type="password" class="inputtext login_form_input_box" name="pass" id="pass" data-testid="royal_pass">
        //driver.findElement(By.id("pass")).sendKeys("anything");
        //<input value="Log In" aria-label="Log In" data-testid="royal_login_button" type="submit" id="u_0_b">
        //driver.findElement(By.id("u_0_b")).click();
        driver.quit();
	}

}
