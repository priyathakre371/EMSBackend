

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;
import com.example.demo.model.Evaluation;
import com.example.demo.model.Skills;
import com.example.demo.payload.EmployeeDto;

public interface EmployeeService {
	
	public Employee addEmployee(Employee emp);
	public List<Employee> getAllEmp();
	public Optional<Employee> getEmpById(int id);
	public void deleteEmpById(int id);
	public Employee updateEmpById(int id,Employee emp);
	public Employee findByEmployeeIdAndEmployeeName(Integer employeeId,String employeeName);
	public EmployeeDto searchByEmployeeIdAndEmployeeName(Integer employeeId,String employeeName);
	
	public Evaluation addEvatuationDetailsById(int employeeId, Evaluation e);

}
