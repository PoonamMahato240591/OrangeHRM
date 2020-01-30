package com.RadioButton_Function;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Radio_Button_Status_Validation {
	WebDriver driver=null;
	String url="http://www.echoecho.com/htmlforms10.htm";
	File linkScreenShot=null;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe" );
		driver= new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void radioButton_Block1() throws InterruptedException {
		///html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td

WebElement block=driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));
//<input type="radio" name="group1" value="Milk">
//<input type="radio" name="group1" value="Butter" checked="">
//<input type="radio" name="group1" value="Cheese">
//<input type="radio" name="group2" value="Water">
//<input type="radio" name="group2" value="Beer">
//<input type="radio" name="group2" value="Beer">
List<WebElement>radioButton_list=block.findElements(By.name("group1"));
int radioButton_listCount=radioButton_list.size();
for(int i=0;i<radioButton_listCount;i++)
{
	
     for(int j=0;j<radioButton_listCount;j++)
    	 {
    	 String ButtonList=radioButton_list.get(j).getAttribute("value");
    		
	 radioButton_list.get(j).click();
	 System.out.println(ButtonList+" -"+radioButton_list.get(i).isSelected());
     }
	}
	}
@Test(priority=2)
public void radioButton_Block2() {
	WebElement block=driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));
	//<input type="radio" name="group1" value="Milk">

	//<input type="radio" name="group1" value="Cheese">
	//<input type="radio" name="group2" value="Water">
	//<input type="radio" name="group2" value="Beer">
	
	List<WebElement>radioButton_list=block.findElements(By.name("group2"));
	int radioButton_listCount=radioButton_list.size();
	for(int i=0;i<radioButton_listCount;i++)
	{
		
	     for(int j=0;j<radioButton_listCount;j++)
	    	 {
	    	 String ButtonList=radioButton_list.get(j).getAttribute("value");
	    		
		 radioButton_list.get(j).click();
		 System.out.println(ButtonList+" -"+radioButton_list.get(i).isSelected());
	     }
}
}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	}

