package com.OrangeHRMFunctionality;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHRM_EmployeeList {
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
//<a href="/orangehrm/symfony/web/index.php/pim/viewEmployeeList/reset/1" id="menu_pim_viewEmployeeList">Employee List</a>
WebElement employee_List=driver.findElement(By.id("menu_pim_viewEmployeeList"));
employee_List.click();

//<a href="/orangehrm/symfony/web/index.php/pim/viewEmployee/empNumber/62">0062</a>
//<a href="/orangehrm/symfony/web/index.php/pim/viewEmployee/empNumber/53">0053</a>
// //*[@id="resultTable"]/tbody/tr[2]/td[2]/a
////*[@id="resultTable"]/tbody/tr[45]/td[2]/a
WebElement employeeList=driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[45]/td[2]/a"))

}
}
