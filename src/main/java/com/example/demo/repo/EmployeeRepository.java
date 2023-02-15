package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Evaluation;
import com.example.demo.payload.EmployeeDto;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	

	public Employee findByEmployeeIdAndEmployeeName(Integer employeeId,String employeeName);
	public Employee searchByEmployeeIdAndEmployeeName(Integer employeeId,String employeeName);
	//public Evaluation addEvatuationDetailsById(Integer employeeId, Evaluation eva);

}
