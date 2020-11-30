package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EXcelReader {

	FileInputStream fis = null;
	public FileInputStream getFileInputStream() {
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/Book.xlsx" ;
		File srcFolder = new File(filePath);
		
		try {
			fis = new FileInputStream(srcFolder);
		} catch (FileNotFoundException e) {
		System.out.println("The file path dose not excist");
		}
		return fis ;
	}
	public Object[][] getExcelData() throws IOException{
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int totalNumberOfRows = (sheet.getLastRowNum()+1);
		int totalNumberOfColoumns = 4;
		String [][] arrayExcelData = new String[totalNumberOfColoumns][totalNumberOfRows];
		for (int i = 0; i < totalNumberOfRows; i++) {
			for (int j = 0; j < totalNumberOfColoumns; j++) {				
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j]= row.getCell(j).toString();				
			}
		}
		wb.close();
		return arrayExcelData;
	}
}
