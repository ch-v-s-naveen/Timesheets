package com.excel.sheetbean;

import java.sql.Date;

public class ExceelSheetBean {
private int sno;
private int employeeId;
private String employeeName;
private Date date;
private String inTime;
private String outTime;
public String getInTime() {
	return inTime;
}
public void setInTime(String inTime) {
	this.inTime = inTime;
}
private String traineeTask;
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

public String getOutTime() {
	return outTime;
}

public void setOutTime(String outTime) {
	this.outTime = outTime;
}
public String getTraineeTask() {
	return traineeTask;
}
public void setTraineeTask(String traineeTask) {
	this.traineeTask = traineeTask;
}


}
