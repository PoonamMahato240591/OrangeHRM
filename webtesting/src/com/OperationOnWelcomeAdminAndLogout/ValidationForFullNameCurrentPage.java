package com.OperationOnWelcomeAdminAndLogout;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ValidationForFullNameCurrentPage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://localhost/orangehrm/symfony/web/index.php/auth/login";
		driver.navigate().to(url);
		driver.manage().window().maximize();
		String expected_LoginPageTitle="OrangeHRM";
		System.out.println("The expected LoginPage Title is: "+expected_LoginPageTitle);
		String actual_WebPageTitle=driver.getTitle();
		System.out.println("The actual WebPage Title is :"+actual_WebPageTitle);
		
		//<div id="logInPanelHeading">LOGIN Panel</div>
		WebElement login=driver.findElement(By.id("logInPanelHeading"));
		String expected_loginName="LOGIN Panel";
		System.out.println("The expected login name is: "+expected_loginName);
		String actual_loginName=login.getText();
		System.out.println("The actual login name is: "+actual_loginName);
		if(actual_loginName.equals(expected_loginName))
		{
		System.out.println("The Login Name matched-PASS");
	}
		else
		{
			System.out.println("The Login Name did not matched-FAIL");
		}
		
		//<input name="txtUsername" id="txtUsername" type="text">
	WebElement userName=driver.findElement(By.id("txtUsername"));
	userName.sendKeys("Admin");
	
	//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
	WebElement password=driver.findElement(By.id("txtPassword"));
	password.sendKeys("Admin123");
	
	//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	WebElement login_button=driver.findElement(By.id("btnLogin"));
	login_button.click();
	String expected_AdminName ="Admin";
	System.out.println("The expected admin name is: "+expected_AdminName);
	
	//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
	WebElement welcome_Admin=driver.findElement(By.id("welcome"));
	String actual_WelcomeAdminName=welcome_Admin.getText();
	System.out.println("The actual_WelcomeAdminName name is: "+actual_WelcomeAdminName);
	if(actual_WelcomeAdminName.contains(expected_AdminName))
	{
		System.out.println("It's in Welcome Admin Page-PASS");
		
	}
	else
	{
     System.out.println("It is not in Welcome Admin Page-Fail");
	}
	
	//<a class="firstLevelMenu" id="menu_pim_viewPimModule" href="/orangehrm/symfony/web/index.php/pim/viewPimModule"><b>PIM</b></a>
	WebElement PIM =driver.findElement(By.id("menu_pim_viewPimModule"));
	Actions act = new Actions(driver);
	act.moveToElement(PIM).perform();
	
	//<a id="menu_pim_addEmployee" href="/orangehrm/symfony/web/index.php/pim/addEmployee">Add Employee</a>
	WebElement addEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
	addEmployee.click();
	String expected_HomepageNameAddEmployee="Add Employee";
	System.out.println("The expected Home Page Name of Add Employee is:"+expected_HomepageNameAddEmployee);
	
	//<h1>Add Employee</h1>
	WebElement actual_WebpageNameOfAddEmployee=driver.findElement(By.tagName("h1"));
	String actual_NameofAddEmployeePage=actual_WebpageNameOfAddEmployee.getText();
	
	System.out.println("The actual namee of home page is:"+actual_NameofAddEmployeePage);
	
	if(actual_NameofAddEmployeePage.equals(expected_HomepageNameAddEmployee))
{
	System.out.println("The WebPage is an Add Employee Page-Pass");
}
	else
	{
		System.out.println("The Web Page is not an Add Employee Page-Fail");
	}
	//<input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
	WebElement employee_FirstName = driver.findElement(By.id("firstName"));
	employee_FirstName.sendKeys("Neil");
	String firstName=employee_FirstName.getAttribute("value");
	System.out.println("The first name is: "+firstName);
	WebElement employee_MiddleName = driver.findElement(By.id("middleName"));
	employee_MiddleName.sendKeys("Nitin");
	String middleName=employee_MiddleName.getAttribute("value");
	System.out.println("The middle name is: "+middleName);
	WebElement employee_LastName = driver.findElement(By.id("lastName"));
	employee_LastName.sendKeys("Mukesh");
	String lastName=employee_LastName.getAttribute("value");
	System.out.println("The last name is : "+lastName);

	
//<input type="button" class="" id="btnSave" value="Save">
 WebElement save=driver.findElement(By.id("btnSave"));
 save.click();
 
 //<input value="Neil" type="text" name="personal[txtEmpFirstName]" class="block default editable" maxlength="30" title="First Name" id="personal_txtEmpFirstName" disabled="disabled">
    WebElement personal_Page_FirstName=driver.findElement(By.id("personal_txtEmpFirstName"));
   String personalDetail_FirstName =personal_Page_FirstName.getAttribute("value");
   System.out.println("The name in personal detail full name is:"+personalDetail_FirstName);
   //<input value="Nitin" type="text" name="personal[txtEmpMiddleName]" class="block default editable" maxlength="30" title="Middle Name" id="personal_txtEmpMiddleName" disabled="disabled">
   WebElement personal_Page_MiddleName=driver.findElement(By.id("personal_txtEmpMiddleName"));
   String personalDetail_MiddleName =personal_Page_MiddleName.getAttribute("value");
   System.out.println("The name in personal detail Middle name is:"+personalDetail_MiddleName);
	//<input value="Mukesh" type="text" name="personal[txtEmpLastName]" class="block default editable" maxlength="30" title="Last Name" id="personal_txtEmpLastName" disabled="disabled">
   WebElement personal_Page_LastName=driver.findElement(By.id("personal_txtEmpLastName"));
   String personalDetail_LastName =personal_Page_LastName.getAttribute("value");
   System.out.println("The name in personal detail Last name is:"+personalDetail_LastName);
   if(personalDetail_FirstName.equals(firstName)&&personalDetail_MiddleName.equals(middleName)&&personalDetail_LastName.equals(lastName))
   {
	   System.out.println("The Names matched-Pass");
   }
   else
   {
	   System.out.println("The names does not match-Fail");   
   }
	WebElement personalDetail_welcome_Admin=driver.findElement(By.id("welcome"));
	personalDetail_welcome_Admin.click();
   Thread.sleep(10000);
   WebElement logout=driver.findElement(By.linkText("Logout"));

	logout.click();
   
	}
	

}
