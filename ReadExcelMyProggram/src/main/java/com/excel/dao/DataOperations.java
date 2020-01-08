package com.excel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.read.excel.bean.ExcelSheetBean;

public class DataOperations {
 private JdbcTemplate jdbctemplate;

public void setJdbctemplate(JdbcTemplate jdbctemplate) {
	this.jdbctemplate = jdbctemplate;
}
 public Boolean insertExcelData( final ExcelSheetBean excelbean) {
	 String sql="insert into us_zip values(?,?,?,?)";
	return jdbctemplate.execute(sql,new PreparedStatementCallback<Boolean>(){

		public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
			ps.setInt(1, excelbean.getZip());
			ps.setString(2, excelbean.getState());
			ps.setString(3, excelbean.getCountry());
			ps.setString(4, excelbean.getCity());
			
			return ps.execute();
		}  
	 
 });
 }
}
