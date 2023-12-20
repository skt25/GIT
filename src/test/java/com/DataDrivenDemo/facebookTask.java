package com.DataDrivenDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookTask {
public static void main(String[] args) throws IOException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\sures\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	File f = new File("C:\\Users\\sures\\eclipse-workspace\\DataDrivenDemo\\excel\\ddworkbook.xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fis);
	String username = wb.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
	WebElement usermail = driver.findElement(By.id("email"));
	usermail.sendKeys(username);
	String passvalue = wb.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
	WebElement password = driver.findElement(By.id("pass"));
	password.sendKeys(passvalue);
	WebElement text = driver.findElement(By.xpath("//h2[@class=\"_8eso\"]"));
	String visibletext = text.getText();
	wb.createSheet("text").createRow(1).createCell(0).setCellValue(visibletext);
	FileOutputStream fos = new FileOutputStream(f);
	wb.write(fos);
}
}
