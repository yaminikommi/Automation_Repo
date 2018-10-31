package com.crm.GenericLib;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public static String getExcelData(String SheetName,int rowNum,int colnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./testdata/Test case Azzu.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row row=sh.getRow(rowNum);
		String data=row.getCell(colnum).getStringCellValue();
		return data;
		}
	public static Properties getPropertiesObj() throws Throwable
	{
		FileInputStream fobj=new FileInputStream("./testdata/commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fobj);
		return pobj;
		
	}
	
	public static String getQuoteExcelData(String SheetName,int rowNum,int colnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./testdata/Test case Azzu.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row row=sh.getRow(rowNum);
		String data=row.getCell(colnum).getStringCellValue();
		return data;
	}
}
