package com.NewTour_MultipleData_Login;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class NewTour_Multiple_DataLogin {
	WebDriver driver=null;
	String url="http://newtours.demoaut.com";
	

@BeforeTest
public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
@Test
public void multiple_Values_Login() throws IOException {
//<input type="text" name="userName" size="10">
FileInputStream file= new FileInputStream("./src/com/ExcelOperations/multipleLoginFornewTour.xlsx");
XSSFWorkbook workbook = new XSSFWorkbook(file);
XSSFSheet sheet=workbook.getSheet("Sheet1");
int rowCount=sheet.getLastRowNum();
		
for(int i=1;i<=rowCount;i++)
  {
	WebElement userName=driver.findElement(By.name("userName"));
	Row row=sheet.getRow(i);
	Cell cell=row.getCell(0);
	String user_Name=cell.getStringCellValue();
	System.out.println(user_Name);
	userName.clear();
	userName.sendKeys(user_Name);
			
//<input type="password" name="password" size="10">
			
WebElement password=driver.findElement(By.name("password"));
Row row1=sheet.getRow(i);
Cell cell1=row1.getCell(1);
String password_Data=cell1.getStringCellValue();
System.out.println(password_Data);
password.clear();
password.sendKeys(password_Data);
									
String expected_WebPageTitle="Find";
//<input type="image" name="login" value="Login" src="/images/btn_signin.gif?osCsid=b8e9a5c442713f8044579a18b15f1b60" width="58" height="17" alt="Sign-In" border="0">
WebElement login=driver.findElement(By.name("login"));
login.click();
String actual_WebPageTitle=driver.getTitle();
System.out.println("Webpage title:"+actual_WebPageTitle);
if(actual_WebPageTitle.contains(expected_WebPageTitle))
{

	Row row2=sheet.getRow(i);
	Cell result=row2.createCell(2);
	result.setCellValue("PASS");
	FileOutputStream file3=new FileOutputStream("./src/com/ExcelOperations/multipleLoginFornewTour.xlsx");
	workbook.write(file3);
	
}
else
  {

	Row row2=sheet.getRow(i);
	Cell result=row.createCell(2);
	result.setCellValue("FAIL");
	FileOutputStream file3=new FileOutputStream("./src/com/ExcelOperations/multipleLoginFornewTour.xlsx");
	workbook.write(file3);

	
}
driver.navigate().back();
}
		
		}
	
@AfterTest
public void tearDown()
	{
		driver.quit();
	}
}

	


		
	

