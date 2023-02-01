package com.example.demo.serviceimpl;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceEmpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	DateTimeFormatter dateTimeFormmater = DateTimeFormatter.ofPattern("yyyy-dd-MM");

	@Override
	public Employee addEmployee(Employee emp) {

		return empRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> empList = null;
		try {
			if (empRepo.findAll() != null || empRepo.findAll().size()>0) {
				empList = calcuteYashExperience(empRepo.findAll());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return empList;
	}

	private List<Employee> calcuteYashExperience(List<Employee> empList) {
		Employee emp = null;
		List<Employee> lists = new ArrayList<>();
		java.util.Date currentDate = new java.util.Date(System.currentTimeMillis());
		int years_difference = 0;
		int months_difference = 0;
		for (Employee e : empList) {
			if (e != null) {
				emp = e;
				Date dateOfJoining = emp.getDateOfJoining();
				long time_difference =  currentDate.getTime()-dateOfJoining.getTime() ;

				// calculate months
				long differenceInMonths = TimeUnit.MILLISECONDS.toDays(time_difference) / 30;

				if (differenceInMonths % 12 == 0) {
					years_difference = (int) differenceInMonths / 12;
					months_difference = 0;
				} else {
					years_difference = (int) differenceInMonths / 12;
					months_difference = (int) differenceInMonths % 12;
				}
				emp.setExprienceInRange(years_difference + " years," + months_difference + " months");
				System.out.println(emp.getExprienceInRange());
			}
			lists.add(emp);
		}
		return lists;
	}

	public void setDate(Employee e) {

		Date d = e.getDateOfJoining();
		System.out.println(d);
	}

}
