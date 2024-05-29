package week5.assignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class test {
	@Test
	public void testTry() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./data/datasheet.xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		int rowCount = ws.getLastRowNum();
		int cellCount = ws.getRow(rowCount).getLastCellNum();
		System.out.println(rowCount);
		System.out.println(cellCount);
		
		String[][] value = new String[rowCount][cellCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(stringCellValue);
			}
		}
		
		wb.close();
		//return value;

	}

}
