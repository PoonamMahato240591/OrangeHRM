package com.ExcelOperation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Write_Data {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("./src/com/ExcelOperations/SingleTest.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet =workBook.getSheet("Sheet1");
		Row row = sheet.createRow(2);
		Cell cell =row.createCell(3);
		cell.setCellValue("LiveTech");
		cell.setCellValue("Jmeter");
		Cell cell4=row.createCell(4);
		cell4.setCellValue("LoadRunner");
		FileOutputStream file1 = new FileOutputStream("./src/com/ExcelOperations/SingleTest.xlsx");
		workBook.write(file1);

	}

}
