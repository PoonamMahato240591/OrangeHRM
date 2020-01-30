package com.OrangeHRMFunctionality;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeLoginFunctionalityWithMultipleUsers {
	
WebDriver driver=null;
String url="http://localhost/orangehrm/symfony/web/index.php/auth/login";

@BeforeTest
public void setUp() {
	System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
}
@Test
public void OrangeLogin_MultipleUsers() throws IOException
{
	String expected_LoginPage="LOGIN Panel";
	//<div id="logInPanelHeading">LOGIN Panel</div>
	String actual_LoginPage=driver.findElement(By.id("logInPanelHeading")).getText();
	if(expected_LoginPage.equals(actual_LoginPage))
			{
		System.out.println("It's a Login Page-Pass");
			}
	else
	{
		System.out.println("It is not a Login Page-Fail");
	}
FileInputStream file=new FileInputStream("./src/com/ExcelOperations/OrangeLoginList.xlsx");
XSSFWorkbook workBook=new XSSFWorkbook(file);
XSSFSheet sheet = workBook.getSheet("Sheet1");
int rowCount=sheet.getLastRowNum();
for(int i=1;i<=rowCount;i++)
{
	Row row =sheet.getRow(i);
	//<input name="txtUsername" id="txtUsername" type="text">
WebElement userName=driver.findElement(By.id("txtUsername"));
userName.clear();
userName.sendKeys(row.getCell(0).getStringCellValue());

//<input name="txtPassword" id="txtPassword" type="password" autocomplete="off">
WebElement password=driver.findElement(By.id("txtPassword"));
password.clear();
password.sendKeys(row.getCell(1).getStringCellValue());

//<input name="Submit" class="button" id="btnLogin" type="submit" value="LOGIN">
WebElement login=driver.findElement(By.id("btnLogin"));
login.click();
String expected_page="http://localhost/orangehrm/symfony/web/index.php/dashboard";
String current_WebPage=driver.getCurrentUrl();

if(current_WebPage.contains(expected_page))
{
String expected_HomePage="Admin";
//<a class="panelTrigger" id="welcome" href="#">Welcome Admin</a>
String actual_HomePage=driver.findElement(By.id("welcome")).getText(); 

if(actual_HomePage.contains(expected_HomePage))
{
	System.out.println("Login successfull-Pass");
	Cell cell=row.createCell(2);
	cell.setCellValue("Login successfull-Pass");
	driver.navigate().back();
}

else	
	{

	System.out.println("Login unsuccessfull-Fail");
	Cell cell=row.createCell(2);
	cell.setCellValue("Login unsuccessfull-Fail");

FileOutputStream file1=new FileOutputStream("./src/com/ApplicationResult/OranageHRM_LoginResult.xlsx");
workBook.write(file1);
driver.navigate().back();
}}
}}
@AfterTest
public void tearDown()
{
	driver.quit();
}
}
	



