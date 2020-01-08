package com.excel.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.excel.dao.DatabaseOperations;
import com.excel.sheetbean.ExceelSheetBean;
import com.sun.rowset.internal.Row;

public class OneByOneSheet {
public void insertSheetsData() throws IOException, ParseException {
	ApplicationContext context =new ClassPathXmlApplicationContext("Timesheetconfig.xml");
	DatabaseOperations dbo=(DatabaseOperations) context.getBean("sheet");
	HSSFWorkbook workbook=null;
	FileInputStream fis=null;
	HSSFSheet sheet=null;
	fis=new FileInputStream(new File("D:/java main projects/Spring Projects/Spring Works/TimeSheetss/TimSheet_Java9.xls"));
	workbook=new HSSFWorkbook(fis);
	int sno;
	int employeeId;
	String Date;
	java.util.Date inTime;
	Date outTime;
	String task;
	ExceelSheetBean sheetbean=null;
	for(int i=5;i<workbook.getNumberOfSheets();i++) {
	HSSFSheet hssfSheet=workbook.getSheetAt(i);
	Iterator<org.apache.poi.ss.usermodel.Row> iterator=hssfSheet.iterator();
	iterator.next();

	while(iterator.hasNext()) {
		sheetbean=new ExceelSheetBean();
		org.apache.poi.ss.usermodel.Row row1=iterator.next();
		try {
		sno=(int) row1.getCell(0).getNumericCellValue();
		}catch (Exception e) {
    sno=0;
		}
		employeeId=i;
		try {
		Date=row1.getCell(1).getStringCellValue();
		if(Date==""||Date==null) {
			Date="01/01/19";
		}
		}catch (Exception e) {
        Date="10/10/10";
		}
		try {
		inTime=row1.getCell(4).getDateCellValue();
		System.out.println(inTime);
		}catch (Exception e) {
        inTime=new Date(01/01/19);	
		} try {
			outTime=row1.getCell(5).getDateCellValue();
		}catch (Exception e) {
			outTime=new Date(01/01/19);
		}
	
		System.out.println(outTime);
		task=row1.getCell(8).getStringCellValue();
		sheetbean.setSno(sno);
		sheetbean.setEmployeeId(employeeId);
		//date conversion process
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	       java.util.Date df= sdf.parse(Date);
	        java.sql.Date date=new java.sql.Date(df.getTime());
	        System.out.println(date);
		sheetbean.setDate(date);
		//Time conversion
		DateFormat time=new SimpleDateFormat("hh:mm");
		String dateq=time.format(inTime);
		String out=time.format(outTime);

		sheetbean.setInTime(dateq);
		sheetbean.setOutTime(out);
		sheetbean.setTraineeTask(task);
		dbo.insertSingleSheets(sheetbean);
	}
}
}
	public static void main(String[] args) throws IOException, ParseException {
		OneByOneSheet bb=new OneByOneSheet();
		bb.insertSheetsData();
	}

}
