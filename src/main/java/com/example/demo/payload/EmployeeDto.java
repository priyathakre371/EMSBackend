package com.example.demo.payload;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Evaluation;

public class EmployeeDto {
	
	private int employeeId;
	private String employeeName;
	public String mobileNo;
	private List<Evaluation> evalList=new ArrayList<>();
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public List<Evaluation> getEvalList() {
		return evalList;
	}
	public void setEvalList(List<Evaluation> evalList) {
		this.evalList = evalList;
	}
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDto(int employeeId, String employeeName, String mobileNo, List<Evaluation> evalList) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.mobileNo = mobileNo;
		this.evalList = evalList;
	}
	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", employeeName=" + employeeName + ", mobileNo=" + mobileNo
				+ ", evalList=" + evalList + "]";
	}
	

}
