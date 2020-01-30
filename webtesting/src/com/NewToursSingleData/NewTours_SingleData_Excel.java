package com.NewToursSingleData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_SingleData_Excel {
WebDriver driver=null;
String url="http://newtours.demoaut.com";

@BeforeTest
public void setUp()
{
	System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to(url);
	driver.manage().window().maximize();
}

@Test(priority=1)
public void userName() throws IOException {
	//<input type="text" name="userName" size="10">
	
	WebElement userName=driver.findElement(By.name("userName"));
	FileInputStream file= new FileInputStream("./src/com/ExcelOperations/newToursTravelLogin.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	   Row row=sheet.getRow(1);
	   Cell cell=row.getCell(0);
	    userName.sendKeys(cell.getStringCellValue());
}
@Test(priority=2)
public void password() throws IOException {
	//<input type="password" name="password" size="10">
	WebElement password=driver.findElement(By.name("password"));
	FileInputStream file= new FileInputStream("./src/com/ExcelOperations/newToursTravelLogin.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	   Row row=sheet.getRow(1);
	   Cell cell=row.getCell(1);
	   password.sendKeys(cell.getStringCellValue());
	   
}
@Test(priority=3)
public void login() throws IOException  {
String expected_WebPageTitle="Find";
//<input type="image" name="login" value="Login" src="/images/btn_signin.gif?osCsid=b8e9a5c442713f8044579a18b15f1b60" width="58" height="17" alt="Sign-In" border="0">
WebElement login=driver.findElement(By.name("login"));
login.click();
String actual_WebPageTitle=driver.getTitle();
if(actual_WebPageTitle.contains(expected_WebPageTitle))
{
	FileInputStream file= new FileInputStream("./src/com/ExcelOperations/newToursTravelLogin.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	Row row=sheet.getRow(1);
	Cell cell=row.createCell(2);
	cell.setCellValue("PASS");
	FileOutputStream file1=new FileOutputStream("./src/com/ExcelOperations/newToursTravelLogin.xlsx");
	workbook.write(file1);
}
else
  {

	FileInputStream file= new FileInputStream("./src/com/ExcelOperations/newToursTravelLogin.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	Row row=sheet.createRow(1);
	Cell cell=row.createCell(2);
    cell.setCellValue("FAIL");
	FileOutputStream file1=new FileOutputStream("./src/com/ExcelOperations/newToursTravelLogin.xlsx");
	workbook.write(file1);

}}
@AfterTest
public void tearDown() 
{
	driver.quit();
}
}


