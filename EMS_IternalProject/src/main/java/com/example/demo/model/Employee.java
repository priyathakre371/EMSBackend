package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Employee {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	private String employeeName;
	private String grade;
//	 @JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
//	 @JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	  private Date dateOfJoining;
	private String exprience;
	private String exprienceInRange;
	private String baseLocation;
	private String currentLocation;
	public String mobileNo;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getExprience() {
		return exprience;
	}
	public void setExprience(String exprience) {
		this.exprience = exprience;
	}
	public String getExprienceInRange() {
		return exprienceInRange;
	}
	public void setExprienceInRange(String exprienceInRange) {
		this.exprienceInRange = exprienceInRange;
	}
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int employeeId, String employeeName, String grade, Date dob, Date dateOfJoining, String exprience,
			String exprienceInRange, String baseLocation, String currentLocation, String mobileNo) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.grade = grade;
		this.dob = dob;
		this.dateOfJoining = dateOfJoining;
		this.exprience = exprience;
		this.exprienceInRange = exprienceInRange;
		this.baseLocation = baseLocation;
		this.currentLocation = currentLocation;
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", grade=" + grade + ", dob="
				+ dob + ", dateOfJoining=" + dateOfJoining + ", exprience=" + exprience + ", exprienceInRange="
				+ exprienceInRange + ", baseLocation=" + baseLocation + ", currentLocation=" + currentLocation
				+ ", mobileNo=" + mobileNo + "]";
	}
	
	

}
