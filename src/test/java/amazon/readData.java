package amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readData {
	static String value;
	public static String readDatafromsheet(String sheetname,int row,int cell) throws IOException {
		File f = new File("C:\\Users\\sures\\eclipse-workspace\\DataDrivenDemo\\excel\\amazon.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		org.apache.poi.ss.usermodel.Sheet sheetAt = wb.getSheet(sheetname);
		Row r = sheetAt.getRow(row);
		Cell c = r.getCell(cell);
		CellType cellType = c.getCellType();
		if (cellType.equals(CellType.STRING)) {
			value = c.getStringCellValue();
		} else if (cellType.equals(CellType.NUMERIC)) {
			double numericCellValue = c.getNumericCellValue();
			int data = (int) numericCellValue;
			value=Integer.toString(data);
		}
		return value;
}
	}
