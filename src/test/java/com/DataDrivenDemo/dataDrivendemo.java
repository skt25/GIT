package com.DataDrivenDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDrivendemo {
	private static void readSingleData() throws IOException {
		File f = new File("C:\\Users\\sures\\eclipse-workspace\\DataDrivenDemo\\excel\\ddworkbook.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		org.apache.poi.ss.usermodel.Sheet sheetAt = wb.getSheetAt(0);
		Row row = sheetAt.getRow(2);
		Cell cell = row.getCell(1);
		CellType cellType = cell.getCellType();
		if (cellType.equals(CellType.STRING)) {
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
		} else if (cellType.equals(CellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			int data = (int) numericCellValue;
			System.out.println(data);
		}
		
	}
	public static void readAllData() throws IOException {
		File f = new File("C:\\Users\\sures\\eclipse-workspace\\DataDrivenDemo\\excel\\ddworkbook.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		org.apache.poi.ss.usermodel.Sheet sheetAt = wb.getSheetAt(0);
		int numofrows = sheetAt.getPhysicalNumberOfRows();
		for (int i = 0; i < numofrows; i++) {
			Row row = sheetAt.getRow(i);
			int numberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < numberOfCells; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				if (cellType.equals(CellType.STRING)) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				} else if (cellType.equals(CellType.NUMERIC)) {
					double numericCellValue = cell.getNumericCellValue();
					int data = (int) numericCellValue;
					System.out.println(data);
				}
			}
			wb.close();
		}

	}

	public static void main(String[] args) throws IOException {
		readSingleData();
		readAllData();
	}
}
