package com.IVRM.Generic;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This is the Generic class for Data Driven Testing 
 * @author Bikash
 */

public class FileLibrary {
	/**
	 * This is the Generic method for Reading/Taking data from Property file 
	 * @param key
	 * @return data
	 * @throws IOException
	 */
	public String readproperty(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/ivrm.properties");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
	
	/**
	 * This is the generic method for Reading/Taking only string data from Excel file
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/AdmissionForm.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String res = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return res;
	}
	
	/**
	 * This is the generic method for Reading/Taking only numeric data from Excel file
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public double readnumExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/AdmissionForm.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		double res = wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		return res;
	}


}
