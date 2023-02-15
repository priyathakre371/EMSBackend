package com.example.demo.service;
import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.serviceimpl.EmployeeServiceEmpl;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { TestEmployeeService.class })
public class TestEmployeeService {
	
	@Mock
	EmployeeRepository empRepo;

	@InjectMocks
	EmployeeServiceEmpl empService;

	public List<Employee> empList;
/*
	@Test
	@Order(1)
	public void test_getAllEmp() {
		empList = new ArrayList<Employee>();
		empList.add(new Employee(1001, "Sayali Sharma", "E1", new java.util.Date(System.currentTimeMillis()),
		"priya@gmail.com", "8976453433", new java.util.Date(System.currentTimeMillis()), "4years,2 months",
		"pune", "pune", "Java,Spring", "MySQL", "1 years,4 months", "5 years,6 months"));
		empList.add(new Employee(1002, "Priya Thakre", "E2", new java.util.Date(System.currentTimeMillis()),
		"priya@gmail.com", "8976453433", new java.util.Date(System.currentTimeMillis()), "4years,2 months",
		"pune", "pune", "Java,Spring", "MySQL", "1 years,4 months", "5 years,6 months"));

		when(empRepo.findAll()).thenReturn(empList);

		assertEquals(2, empService.getAllEmp().size());

	}

	@Test
	@Order(2)
	public void test_addBook() {

		Employee emp = new Employee(1002, "Sayali Sharma", "E1", new java.util.Date(System.currentTimeMillis()),
				"priya@gmail.com", "8976453433", new java.util.Date(System.currentTimeMillis()), "4years,2 months",
				"pune", "pune", "Java,Spring", "MySQL", "1 years,4 months", "5 years,6 months");
		when(empRepo.save(emp)).thenReturn(emp);

		assertEquals(emp, empService.addEmployee(emp));

	}

	@Test
	@Order(3)
	@DisplayName("JUnit test for getEmpById employee operation")
	public void test_getEmpById() {
		Optional<Employee> emp = Optional.of(new Employee(1003, "Mona Verma", "E1",
				new java.util.Date(System.currentTimeMillis()), "priya@gmail.com", "8976453433",
				new java.util.Date(System.currentTimeMillis()), "4years,2 months", "pune", "pune", "Java,Spring",
				"MySQL", "1 years,4 months", "5 years,6 months"));

		int empId = 1003;

		when(empRepo.findById(empId)).thenReturn(emp);

		assertEquals(empId, empService.getEmpById(empId).get().getEmployeeId());
	}
	
	
	@Test
    @Order(4)
    @DisplayName("JUnit test for delete employee operation")
    public void test_deleteEmpById(){
    	Employee emp = new Employee(1002, "Sayali Sharma", "E1", new java.util.Date(System.currentTimeMillis()),
				"priya@gmail.com", "8976453433", new java.util.Date(System.currentTimeMillis()), "4years,2 months",
				"pune", "pune", "Java,Spring", "MySQL", "1 years,4 months", "5 years,6 months");
     
        when(empRepo.findById(emp.getEmployeeId())).thenReturn(Optional.of(emp));
        empService.deleteEmpById(emp.getEmployeeId());
        verify(empRepo).deleteById(emp.getEmployeeId());
	

}


	/*@Test
    @Order(5)
    @DisplayName("JUnit test for update employee operation")
    public void test_updateEmpById()
	{
	Employee emp = new Employee(1002, "Sayali Sharma", "E1", new java.util.Date(System.currentTimeMillis()),
				"priya@gmail.com", "8976453433", new java.util.Date(System.currentTimeMillis()), "4years,2 months",
				"pune", "pune", "Java,Spring", "MySQL", "1 years,4 months", "5 years,6 months");
	
	Employee newEmp = new Employee(1002, "Mona Sharma", "E1", new java.util.Date(System.currentTimeMillis()),
			"priya@gmail.com", "8976453433", new java.util.Date(System.currentTimeMillis()), "4years,2 months",
			"pune", "pune", "Java,Spring", "MySQL", "1 years,4 months", "5 years,6 months");
	given(empRepo.findById(emp.getEmployeeId()).willReturn(Optional.of(emp));
	empService.updateEmpById(emp.getEmployeeId(), newEmp);
	verify(empRepo).save(newEmp);
	verify(empRepo).findById(emp.getEmployeeId());
	}
	*/
}
