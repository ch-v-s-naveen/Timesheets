package com.excel.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.excel.dao.DataOperations;
import com.read.excel.bean.ExcelSheetBean;

public class ExcelTest {

	public static ExcelSheetBean DataFromExcel() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("Excelconfig.xml");
		DataOperations dao = (DataOperations) context.getBean("insert");

		HSSFWorkbook hbook;
		FileInputStream fis;
		int zip;
		String state;
		String country;
		String city;
		ExcelSheetBean excelbean = null;
		fis = new FileInputStream(new File("D:/java main projects/Extracted files/ReadExcel/zip_code_database.xls"));
		hbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = hbook.getSheetAt(0);
		Iterator<Row> row = sheet.iterator();
		row.next();
        while (row.hasNext()) {
			Row row1 = row.next();
			zip = (int) row1.getCell(0).getNumericCellValue();
			try {
				state = row1.getCell(2).getStringCellValue();
			} catch (Exception e) {
				state = "";
			}
			try {
				country = row1.getCell(5).getStringCellValue();
			} catch (Exception e) {
				country = "";
			}
			try {
				city = row1.getCell(6).getStringCellValue();
			} catch (Exception e) {
				city = "";
			}
			excelbean = new ExcelSheetBean();
			excelbean.setZip(zip);
			excelbean.setState(state);
			excelbean.setCountry(country);
			excelbean.setCity(city);
			dao.insertExcelData(excelbean);
		}
		return excelbean;
	}

	public static void main(String[] args) throws IOException {
		DataFromExcel();
	}

}
