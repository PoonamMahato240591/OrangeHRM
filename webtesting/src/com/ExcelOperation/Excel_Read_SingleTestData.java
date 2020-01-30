
package com.ExcelOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_SingleTestData {

	public static void main(String[] args) throws IOException  {
		FileInputStream file=new FileInputStream("./src/com/ExcelOperations/SingleTest.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.createRow(1);
		Cell cell=row.createCell(2);
		cell.setCellValue("PASS");
		FileOutputStream file1=new FileOutputStream("./src/com/ExcelOperations/SingleTest.xlsx");
		workbook.write(file1);
		
		

	}

}
