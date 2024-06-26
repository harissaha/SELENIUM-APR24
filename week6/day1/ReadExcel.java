package week6.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String[][] readExcelData(String fileName) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		int rowCount = ws.getLastRowNum();
		int cellCount = ws.getRow(rowCount).getLastCellNum();
		String[][] data = new String[rowCount][cellCount];
		
		for (int i = 1; i <=rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String value = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=value;
			}
		}
		wb.close();
		return data;
	}

}
