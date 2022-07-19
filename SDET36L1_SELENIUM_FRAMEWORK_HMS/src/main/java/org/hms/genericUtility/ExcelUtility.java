package org.hms.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public final class ExcelUtility
{
	private Workbook workbook;
	private Sheet sheet;
	public void intiallizeExcelFile(String excelFilePath)
	{
		FileInputStream fisExcel = null;
		try {
			fisExcel = new FileInputStream(excelFilePath);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try 
		{
			workbook=WorkbookFactory.create(fisExcel);
		} 
		catch (EncryptedDocumentException | IOException e)
		{
			e.printStackTrace();
		}
	}
	public String getDataFromExcel(int rowNumber, int cellNumber, String sheetName)
	{
		Sheet sheet=workbook.getSheet(sheetName);
		return new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));	
	}
}