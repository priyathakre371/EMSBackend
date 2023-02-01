package com.example.demo.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.serviceimpl.EmployeeServiceEmpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceEmpl empService;
	
	DateTimeFormatter dtm =DateTimeFormatter.ofPattern("yyyy-dd-MM");
	
	@PostMapping("/addEmp")
	public Employee add(@RequestBody Employee emp)
	{
		/*System.out.println(emp.getDateOfJoining());
		Date d=emp.getDateOfJoining();
		System.out.println(d.getYear()+"/"+d.getMonth()+"/"+d.getDate());
		LocalDate cur=LocalDate.of(d.getYear(), d.getMonth(), d.getDate());
		
		LocalDate now=LocalDate.now();
		Period age = Period.between(cur, now);
        int years = age.getYears();
        int months = age.getMonths();
        int days = age.getDays();
        System.out.println(years+"/"+months+"/"+days); */
		
		
		
		return empService.addEmployee(emp);
	}
	@GetMapping("/getAllEmp")
	public List<Employee> getAll()
	{ 
		
		return empService.getAllEmp();
	}
	@GetMapping("/getDate")
	public void date(Employee emp)
	{
		empService.setDate(emp);
	}

}
/*
 *{
    "employeeId":1001,
	"employeeName":"ekta marathe",
	"grade":"E1",
	 "dob":"1970-12-11",
	"exprience":"2 years",
	"exprience_range":"ee",
	"base_location":"pune",
	"current_location":"pune"
}
*/
