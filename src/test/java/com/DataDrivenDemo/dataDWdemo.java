package com.DataDrivenDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class dataDWdemo {
	private static void write_Data() throws IOException {
		File f = new File("C:\\Users\\sures\\OneDrive\\Desktop\\writedata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		wb.createSheet("Details1").createRow(0).createCell(0).setCellValue("username");
		wb.getSheet("Details1").getRow(0).createCell(1).setCellValue("password");
		wb.getSheet("Details1").createRow(1).createCell(0).setCellValue("suresh");
		wb.getSheet("Details1").getRow(1).createCell(1).setCellValue("suresh@123");
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		System.out.println("write successfully");
		wb.close();
	}
public static void main(String[] args) throws IOException {
	write_Data();
	
	
}
}
