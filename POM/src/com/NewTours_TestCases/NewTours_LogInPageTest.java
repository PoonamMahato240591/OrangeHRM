package com.NewTours_TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.NewTours_WebPages.NewTours_LogInPage;

public class NewTours_LogInPageTest extends BaseTest{

	
	NewTours_LogInPage newTours_LogInPage = null;
	
	@Test(priority=1)
	public void signOnTest()
	{	
		
		newTours_LogInPage= PageFactory.initElements(driver, NewTours_LogInPage.class);

		newTours_LogInPage.SignOn();

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();

	}
	
	@Test(priority=2)
	public void registerTest()
	{
		newTours_LogInPage= PageFactory.initElements(driver, NewTours_LogInPage.class);
		newTours_LogInPage.register();
		

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();

	}
	
	@Test(priority=3)
	public void findAFlightTest() throws IOException
	{
		newTours_LogInPage= PageFactory.initElements(driver, NewTours_LogInPage.class);
		
		FileInputStream file = new FileInputStream(".//src//com//ApplicationTestDataFiles//NewTours_LogInTestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		int rowCount=sheet.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++)
		{
			// goes to an active Row
			Row row=sheet.getRow(i);
			
		newTours_LogInPage.findAFlight(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
		
		String expected_HomePageTitle="Find";
		System.out.println("The expected Title of the New Tours Home Page is:"
																		+expected_HomePageTitle);
				
				String actual_WebPageTitle=driver.getTitle();
		System.out.println(" The actual title of the NewTours WebPage is :"+actual_WebPageTitle );
				
				if(actual_WebPageTitle.contains(expected_HomePageTitle))
				{
					System.out.println(" LogIN Successfull - PASS");
					row.createCell(2).setCellValue("LogIN Successfull - PASS");
				}
				else
				{
					System.out.println(" LogIn Failed - FAIL");
					row.createCell(2).setCellValue("LogIn Failed - FAIL");
				}
				
		driver.navigate().back();
		
FileOutputStream file1 = new FileOutputStream(".//src//com//ApplicationTestResultFiles//NewTours_LogIn_TestResult.xlsx");
				workBook.write(file1);
				
		}
	
		
	}

}
