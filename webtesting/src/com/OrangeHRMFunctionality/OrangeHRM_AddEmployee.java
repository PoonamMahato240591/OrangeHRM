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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHRM_AddEmployee {
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
		
@Test(priority=1)
public void AddEmployee() throws IOException
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
FileInputStream file=new FileInputStream("./src/com/ExcelOperations/Single UserName_orange.xlsx");
XSSFWorkbook workBook=new XSSFWorkbook(file);
XSSFSheet sheet = workBook.getSheet("Sheet1");
Row row =sheet.getRow(1);
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

String expected_HomePage="Admin";
//<a class="panelTrigger" id="welcome" href="#">Welcome Admin</a>
String actual_HomePage=driver.findElement(By.id("welcome")).getText(); 

if(actual_HomePage.contains(expected_HomePage))
{
	System.out.println("Login successfull-Pass");
	
}
else {
	System.out.println("Login unsuccessfull-Fail");	
}	

//<a href="/orangehrm/symfony/web/index.php/pim/viewPimModule" id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>
WebElement PIM=driver.findElement(By.id("menu_pim_viewPimModule"));
PIM.click();

//<a id="menu_pim_addEmployee" href="/orangehrm/symfony/web/index.php/pim/addEmployee">Add Employee</a>
	WebElement addEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
	//addEmployee.click();
	Actions act= new Actions(driver);
	act.moveToElement(addEmployee).click().perform();
 String expected_page="Add Employee";
 
 //  //*[@id="content"]/div/div[1]/h1
 WebElement actual_Page=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1"));
 String actual_Webpage=actual_Page.getText();
 
 if(actual_Webpage.equals(expected_page))
{
	System.out.println("PASS");
}
else
{
	System.out.println("FAIL");
}
}
@Test(priority=2)
public void export_EmployeeId() throws IOException, InterruptedException
{
	FileInputStream file=new FileInputStream("./src/com/ExcelOperations/Add_Employee_Orange.xlsx");
	XSSFWorkbook workBook=new XSSFWorkbook(file);
	XSSFSheet sheet = workBook.getSheet("Sheet1");
	int rowCount=sheet.getLastRowNum();
	for(int i=1;i<=rowCount;i++)
	{
		 Row row=sheet.getRow(i);
		// <input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
	WebElement addEmployee_FirstName=driver.findElement(By.id("firstName"));
	addEmployee_FirstName.clear();
	addEmployee_FirstName.sendKeys(row.getCell(0).getStringCellValue());
	String employee_FirstName=addEmployee_FirstName.getAttribute("value");
	
	//<input class="formInputText" maxlength="30" type="text" name="middleName" id="middleName">
	WebElement addEmployee_MiddleName=driver.findElement(By.id("middleName"));
	addEmployee_MiddleName.clear();
	addEmployee_MiddleName.sendKeys(row.getCell(1).getStringCellValue());
	String employee_MiddleName=addEmployee_MiddleName.getAttribute("value");
	
	
	//<input class="formInputText" maxlength="30" type="text" name="lastName" id="lastName">
	WebElement addEmployee_LastName=driver.findElement(By.id("lastName"));
	addEmployee_LastName.clear();
	addEmployee_LastName.sendKeys(row.getCell(2).getStringCellValue());
	String employee_LastName=addEmployee_LastName.getAttribute("value");
	//<input class="formInputText valid" maxlength="10" type="text" name="employeeId" value="0032" id="employeeId">
	WebElement addEmployee_Id=driver.findElement(By.id("employeeId"));
	String employee_Id=addEmployee_Id.getAttribute("value");
	System.out.println(employee_Id);
	
	Cell cell=row.createCell(3);
	cell.setCellValue(employee_Id);
	
	//<input type="button" class="" id="btnSave" value="Save">
	WebElement save=driver.findElement(By.id("btnSave"));
	save.click();
	//Thread.sleep(10000);

	//Thread.sleep(10000);
	
	//<input value="Satya" type="text" name="personal[txtEmpFirstName]" class="block default editable" maxlength="30" title="First Name" id="personal_txtEmpFirstName" disabled="disabled">	
	WebElement personal_FirstName=driver.findElement(By.id("personal_txtEmpFirstName"));
	String personalDetails_FirstName=personal_FirstName.getAttribute("value");
	
	if(personalDetails_FirstName.equals(employee_FirstName))
	{
		System.out.println("First Name-PASS");
	}
	else
	{
		System.out.println("First Name-FAIL");
}
	
//<input value="Teja" type="text" name="personal[txtEmpMiddleName]" class="block default editable" maxlength="30" title="Middle Name" id="personal_txtEmpMiddleName" disabled="disabled">
	WebElement personal_MiddleName=driver.findElement(By.id("personal_txtEmpMiddleName"));
	String personalDetails_MiddleName=personal_MiddleName.getAttribute("value");
	
	if(personalDetails_MiddleName.equals(employee_MiddleName))
	{
		System.out.println("Middle Name-PASS");
	}
	else
	{
		System.out.println("Middle Name-FAIL");
}
	
	WebElement personal_LastName=driver.findElement(By.id("personal_txtEmpLastName"));
	String personalDetails_LastName=personal_LastName.getAttribute("value");
	
	if(personalDetails_LastName.equals(employee_LastName))
	{
		System.out.println("Last Name-PASS");
	}
	else
	{
		System.out.println("Last Name-FAIL");
}
//<input value="0039" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable" id="personal_txtEmployeeId" disabled="disabled">

	WebElement personal_EmployeeId=driver.findElement(By.id("personal_txtEmployeeId"));
	String personalDetails_EmployeeId=personal_EmployeeId.getAttribute("value");
	
	if(personalDetails_EmployeeId.equals(employee_Id))
	{
		System.out.println("Employee_Id -PASS");
		Cell cell1=row.createCell(4);
		cell1.setCellValue("Employee_Id -PASS");
	}
	else
	{
		System.out.println("Employee_Id-FAIL");
		Cell cell1=row.createCell(4);
		cell1.setCellValue("Employee_Id-FAIL");
	}
	
	FileOutputStream file1=new FileOutputStream("./src/com/ApplicationResult/AddEmployeeId_result.xlsx");
	workBook.write(file1);
	
	Thread.sleep(10000);
	driver.navigate().back();
	Thread.sleep(10000);
	}
	WebElement	welcome_Admin=driver.findElement(By.id("welcome"));
	welcome_Admin.click();

		Thread.sleep(2000);
		WebElement logout=driver.findElement(By.linkText("Logout"));

		logout.click();
		
}

@AfterTest
public void tearDown()
{
	driver.quit();
}
}
	



