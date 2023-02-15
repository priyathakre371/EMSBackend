package com.example.demo.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.Evaluation;
import com.example.demo.model.Skills;
import com.example.demo.payload.EmployeeDto;
import com.example.demo.serviceimpl.EmployeeServiceEmpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceEmpl empService;

	DateTimeFormatter dtm = DateTimeFormatter.ofPattern("yyyy-dd-MM");

	@PostMapping("/addEmp")
	public Employee add(@RequestBody Employee emp) {

		return empService.addEmployee(emp);
	}

	@GetMapping("/getAllEmp")
	public List<Employee> getAll() {

		return empService.getAllEmp();
	}

	@GetMapping("/getDate")
	public void date(Employee emp) {
		empService.setDate(emp);
	}

	@GetMapping("/getByIdAndName/{employeeId}/{employeeName}/evaluation")
	public ResponseEntity<Employee> getByIdAndName(@PathVariable Integer employeeId,
			@PathVariable String employeeName) {
		Employee employee = empService.findByEmployeeIdAndEmployeeName(employeeId, employeeName);
		//List<Evaluation> evaluations = new ArrayList<Evaluation>();
		//evaluations.addAll(employee.getEvalList());
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/searchEmpByIdAndName/{employeeId}/{employeeName}/evaluation")
	public ResponseEntity<?> search(@PathVariable Integer employeeId,@PathVariable String employeeName)
	{
  	       EmployeeDto emp=empService.searchByEmployeeIdAndEmployeeName(employeeId, employeeName);     
         	List<Evaluation> evaluations = new ArrayList<Evaluation>();
  	       evaluations.addAll(emp.getEvalList());
  	return new ResponseEntity<>(emp,HttpStatus.OK);
	} 
	
	@GetMapping("/getEmpById/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		Optional<Employee> emp = empService.getEmpById(id);
		if (!emp.isEmpty()) {
			Optional<Employee> name = Optional.ofNullable(emp.get());
			name.ifPresentOrElse(n -> System.out.println("Employee of id " + id + " is present"),
					() -> System.out.println("Sorry Employee is not present"));
		} else {
			return new ResponseEntity<>("Employee of id " + id + " is not present", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/deleteEmpById/{id}")
	public void deleteById(@PathVariable int id) {
		Employee emp = new Employee();

		if (emp != null) {
			empService.deleteEmpById(id);
		}
	}

	@PutMapping("/updateEmpById/{id}")
	public Employee updateById(@RequestBody Employee emp, @PathVariable int id) {
		return empService.updateEmpById(id, emp);
	}

	@PutMapping("/addEval/{id}")
	public Evaluation addEval(@PathVariable int id,@RequestBody Evaluation eval)
	{
		return empService.addEvatuationDetailsById(id,eval);
	}
}
/*
 * { "employeeId":1001, "employeeName":"ekta marathe", "grade":"E1",
 * "dob":"1970-12-11", "exprience":"2 years", "exprience_range":"ee",
 * "base_location":"pune", "current_location":"pune" }
 */

/*
{
    "employeeId": 1002,
    "employeeName": "Geeta A.Sharma",
    "grade": "E1",
    "dob": "2020-02-03",
    "dateOfJoining": "2020-02-01",
    "exprience": "2.09",
    "baseLocation": "Pune",
    "currentLocation": "Pune",
    "mobileNo": "7897656789",
    "primarySkills":"Core Java",
     "secondarySkills":"Spring Boot",
     "yashExperiene":"",
     "totalExperience":"",
      "evalList":[
          {
         "overallRating":"good",
          "overallComment":"very good",
          "evaluationDate":null,
         "skills":[
             {
                 "skillName":"Java",
                 "skillRating":5,
                 "skillProficiency":"good"

             }
         ]
}
]
}
*/