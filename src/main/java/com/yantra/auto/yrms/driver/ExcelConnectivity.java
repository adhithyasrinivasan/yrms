package com.yantra.auto.yrms.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelConnectivity  {

	@SuppressWarnings("deprecation")
	public static List<List<String>> readExcel(String filePath, String fileName, String sheetName) throws IOException 
	{

		File file = new File(filePath +File.separator+ fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		workbook = new HSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()
				- sheet.getFirstRowNum();
		
		List<List<String>> rowList = new ArrayList<List<String>>();
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			rowList.add(new ArrayList<String>());
			for (int j = 0; j < row.getLastCellNum(); j++) {
				if(row.getCell(j)!=null)
					rowList.get(i-1).add(row.getCell(j).toString());
				else
					rowList.get(i-1).add(row.getCell(j,Row.CREATE_NULL_AS_BLANK).toString());
			}
		}
		workbook.close();
		return rowList;
		
	}
	
}
