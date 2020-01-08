package com.excel.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.excel.dao.DatabaseOperations;
import com.excel.sheetbean.ExceelSheetBean;

public class TestCase {

	public void excelData() throws IOException, InvalidFormatException {
		ApplicationContext context = new ClassPathXmlApplicationContext("Timesheetconfig.xml");
		DatabaseOperations dao=(DatabaseOperations) context.getBean("dataAcess");
	   HSSFWorkbook workbook=null;
	   FileInputStream fis=null;
	   fis=new FileInputStream(new File("D:/java main projects/Spring Projects/Spring Works/TimeSheetss/TimSheet_Java9.xls"));
	   workbook =new HSSFWorkbook(fis);
	   ExceelSheetBean beanexcel =null;
	   for(int i=0;i<workbook.getNumberOfSheets();i++) {
		   beanexcel=  new ExceelSheetBean();
		   HSSFSheet sheet=workbook.getSheetAt(i);
		   beanexcel.setEmployeeId(i);
		   beanexcel.setEmployeeName(sheet.getSheetName());
		   dao.insertData(beanexcel);
	   }
	
	
	
	
	}
		
	public static void main(String[] args) throws InvalidFormatException, IOException {
		TestCase b=new TestCase();
		b.excelData();
	}

}








































	/*
	 * XSSFWorkbook
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * XSSFWorkbook workbook11 = null;
	FileInputStream fis = null;
	fis = new FileInputStream(new File("D:/java main projects/Spring Projects/Spring Works/TimeSheetss/TimSheet_Java9.xls"));
	workbook11 = new XSSFWorkbook(fis);
	XSSFSheet sheeets = workbook11.getSheetAt(0);
	Iterator<XSSFSheet> iter = workbook11.iterator();
	ExceelSheetBean beanexcel = null;
	while (iter.hasNext()) {
		XSSFSheet sheet = iter.next();
		beanexcel = new ExceelSheetBean();
		beanexcel.setEmployeeName(sheet.getSheetName());
		beanexcel.setEmployeeId((int)sheet.getRow(0).getCell(0).getNumericCellValue());
		dao.insertData(beanexcel);
	}

}*/
