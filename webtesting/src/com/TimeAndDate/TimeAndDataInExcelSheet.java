package com.TimeAndDate;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TimeAndDataInExcelSheet {
	WebDriver driver=null;
	String url="https://www.timeanddate.com/worldclock/";


	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe" );
		driver= new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test
	public void  CapturingCompleteWebTableData() throws IOException {
		//<a href="/worldclock/ghana/accra">Accra</a>
	 // /html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a
	// /html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]
		for(int i=1;i<=36;i++) {
				FileInputStream file=new FileInputStream("./src/com/ExcelOperations/TimeAndDate.xlsx");
				XSSFWorkbook workBook = new XSSFWorkbook(file);
				XSSFSheet sheet =workBook.getSheet("Sheet1");
	
				Row row = sheet.createRow(i);
				for(int j=1;j<=8;j++)
					
				{
				
				String data=driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td["+j+"]/a")).getText();
				System.out.print(data+"     ");
				Cell cell =row.createCell(i);
				cell.setCellValue(data);
				
				FileOutputStream file1 = new FileOutputStream("./src/com/ExcelOperations/TimeAndDate.xlsx");
				workBook.write(file1);
			}
				System.out.println();	
				}
			}
	
@AfterTest
public void tearDown()
{
	driver.quit();
}
}

