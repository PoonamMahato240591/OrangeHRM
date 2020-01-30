package com.NewTourRegistrationDetails;

import java.io.FileInputStream;

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

public class NewTourRegistrationDetails {
WebDriver driver=null;
String url="http://newtours.demoaut.com/";

@BeforeTest
public void setUp() {
	System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe");
	driver= new ChromeDriver();
	driver.navigate().to(url);
	driver.manage().window().maximize();
	
}

@Test
public void registrationPage() throws IOException, InterruptedException {
	//<a href="mercuryregister.php">REGISTER</a>
	WebElement register=driver.findElement(By.linkText("REGISTER"));
	register.click();
	
	FileInputStream file=new FileInputStream("./src/com/ExcelOperations/newToursTravelRegistrationDetails.xlsx");
    XSSFWorkbook workBook = new XSSFWorkbook(file);
    XSSFSheet sheet=workBook.getSheet("Sheet1");
    Row row=sheet.getRow(1);
    
    //<input maxlength="60" name="firstName" size="20">
    WebElement firstName=driver.findElement(By.name("firstName"));
    firstName.sendKeys(row.getCell(0).getStringCellValue());
    
    //<input maxlength="60" name="lastName" size="20">
    WebElement lastName=driver.findElement(By.name("lastName"));
    lastName.sendKeys(row.getCell(1).getStringCellValue());
    
    //<input maxlength="20" name="phone" size="15">
    WebElement phone=driver.findElement(By.name("phone"));
   long reg_phone=(long)row.getCell(2).getNumericCellValue();
    
    String registration_phone=Long.toString(reg_phone);
    phone.sendKeys(registration_phone);
    
    //<input name="userName" id="userName" size="35" maxlength="64">
    WebElement email=driver.findElement(By.id("userName"));
    String reg_email=row.getCell(3).getStringCellValue();
    email.sendKeys(reg_email);
    
    //<input maxlength="60" name="address1" size="40">
    WebElement address=driver.findElement(By.name("address1"));
    String reg_address=row.getCell(4).getStringCellValue();
    address.sendKeys(reg_address);
    
    //<input maxlength="60" name="city" size="15">
    WebElement city=driver.findElement(By.name("city"));
    String reg_city=row.getCell(5).getStringCellValue();
    city.sendKeys(reg_city);
    
    //<input maxlength="40" name="state">
    WebElement state=driver.findElement(By.name("state"));
    String reg_state=row.getCell(6).getStringCellValue();
    state.sendKeys(reg_state);
    
    //<input maxlength="20" name="postalCode" size="15">
    WebElement postalCode=driver.findElement(By.name("postalCode"));
    long reg_code=(long)row.getCell(7).getNumericCellValue();
    String registration_code=Long.toString(reg_code);
    postalCode.sendKeys(registration_code);
    
    //<select name="country" size="1">
    WebElement country=driver.findElement(By.name("country"));
    String reg_country=row.getCell(8).getStringCellValue();
    country.sendKeys(reg_country);
    
    //<input name="email" id="email" size="20" maxlength="60">
    WebElement userName=driver.findElement(By.id("email"));
    String reg_userName=row.getCell(9).getStringCellValue();
    System.out.println(reg_userName);
    userName.sendKeys(reg_userName);
    
    //<input maxlength="60" name="password" size="20" type="password">
    WebElement password=driver.findElement(By.name("password"));
    String reg_password=row.getCell(10).getStringCellValue();
    password.sendKeys(reg_password);
    
    //<input maxlength="60" name="confirmPassword" size="20" type="password">
    WebElement confirmPassword=driver.findElement(By.name("confirmPassword"));
    String reg_confirmPassword=row.getCell(11).getStringCellValue();
    confirmPassword.sendKeys(reg_confirmPassword);
    
    //<input type="image" name="register" src="/images/forms/submit.gif" width="60" height="23" border="0">
    WebElement submit=driver.findElement(By.name("register"));
    submit.click();
    
    //<b> Note: Your user name is poonam12.</b>
    WebElement registrationUserName=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b"));
    String actual_userName=registrationUserName.getText();
    System.out.println(actual_userName);
   
  Cell cell=row.createCell(12);

    if((actual_userName).contains(reg_userName))
    {
    	System.out.println("PASS");
    	
    	cell.setCellValue("PASS");
    }
    else {
    	System.out.println("FAIL");

    	cell.setCellValue("FAIL");
    }
FileOutputStream file1=new FileOutputStream("./src/com/ApplicationResult/newToursTravelRegistrationDetailsResult.xlsx");
workBook.write(file1);
Thread.sleep(10000);
}
@AfterTest
public void tearDown() {
driver.quit();
}
}


	


