package com.excel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.excel.sheetbean.ExceelSheetBean;

public class DatabaseOperations {
	private JdbcTemplate jdbctemplate;

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public boolean insertData(final ExceelSheetBean ExceelSheetBean) {
		String query = "insert into employeedetails (employeeId,employeeName) values(?,?)";

		return jdbctemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, ExceelSheetBean.getEmployeeId());
				ps.setString(2, ExceelSheetBean.getEmployeeName());

				return ps.execute();
			}
		});
	}

	public boolean insertSingleSheets(final ExceelSheetBean bean) {
		String sql = "insert into onesheet values(?,?,?,?,?,?)";
		return jdbctemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, bean.getEmployeeId());
				ps.setDate(2, bean.getDate());
				ps.setString(3, bean.getInTime());
				ps.setString(4, bean.getOutTime());
				ps.setString(5,bean.getTraineeTask());
				ps.setInt(6, bean.getSno());

				return ps.execute();
			}
		});

	}
}
