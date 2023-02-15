package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {

	@Id
	private int employeeId;
	private String employeeName;
	private String grade;
	// @JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String email;
	public String mobileNo;
	// @JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	private String exprience;
	private String baseLocation;
	private String currentLocation;
	public String primarySkills;
	public String secondarySkills;
	
	public String yashExperiene;
	public String totalExperience;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_evaluation_fk")
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	public String getPrimarySkills() {
		return primarySkills;
	}

	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}

	public String getSecondarySkills() {
		return secondarySkills;
	}

	public void setSecondarySkills(String secondarySkills) {
		this.secondarySkills = secondarySkills;
	}

	public String getYashExperiene() {
		return yashExperiene;
	}

	public void setYashExperiene(String yashExperiene) {
		this.yashExperiene = yashExperiene;
	}

	public String getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}

	public List<Evaluation> getEvalList() {
		return evalList;
	}

	public void setEvalList(List<Evaluation> evalList) {
		this.evalList = evalList;
	}

	public Employee(int employeeId, String employeeName, String grade, Date dob, String email, String mobileNo,
			Date dateOfJoining, String exprience, String baseLocation, String currentLocation, String primarySkills,
			String secondarySkills, String yashExperiene, String totalExperience, List<Evaluation> evalList) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.grade = grade;
		this.dob = dob;
		this.email = email;
		this.mobileNo = mobileNo;
		this.dateOfJoining = dateOfJoining;
		this.exprience = exprience;
		this.baseLocation = baseLocation;
		this.currentLocation = currentLocation;
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.yashExperiene = yashExperiene;
		this.totalExperience = totalExperience;
		this.evalList = evalList;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", grade=" + grade + ", dob="
				+ dob + ", email=" + email + ", mobileNo=" + mobileNo + ", dateOfJoining=" + dateOfJoining
				+ ", exprience=" + exprience + ", baseLocation=" + baseLocation + ", currentLocation=" + currentLocation
				+ ", primarySkills=" + primarySkills + ", secondarySkills=" + secondarySkills + ", yashExperiene="
				+ yashExperiene + ", totalExperience=" + totalExperience + ", evalList=" + evalList + "]";
	}
	
	
	
}
