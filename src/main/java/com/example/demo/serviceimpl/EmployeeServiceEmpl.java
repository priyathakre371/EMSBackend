package com.example.demo.serviceimpl;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Evaluation;
import com.example.demo.model.Skills;
import com.example.demo.payload.EmployeeDto;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.EvaluationRepository;
import com.example.demo.repo.SkillsRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceEmpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private EvaluationRepository evalRepo;
	
	@Autowired
	private SkillsRepository skillRepo;

	DateTimeFormatter dateTimeFormmater = DateTimeFormatter.ofPattern("yyyy-dd-MM");

	@Override
	public Employee addEmployee(Employee emp) {

		return empRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> list = null;
		try {
			if (empRepo.findAll() != null || empRepo.findAll().size() > 0) {
				list = calculateExp(empRepo.findAll());
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public void setDate(Employee e) {

		Date d = e.getDateOfJoining();
		System.out.println(d);
	}

	private List<Employee> calculateExp(List<Employee> empList) {

		Employee emp = null;
		List<Employee> lists = new ArrayList<>();

		java.util.Date currentDate = new java.util.Date(System.currentTimeMillis());
		int years_difference = 0;
		int months_difference = 0;

		int totalyearsExp;
		int totalmthExp;
		int parse5;

		for (Employee e : empList) {
			if (e != null) {
				emp = e;

				// Calculate YashExperience
				Date dateOfJoining = emp.getDateOfJoining();
				long time_difference = currentDate.getTime() - dateOfJoining.getTime();

				// calculate months
				long differenceInMonths = TimeUnit.MILLISECONDS.toDays(time_difference) / 30;

				if (differenceInMonths % 12 == 0) {
					years_difference = (int) differenceInMonths / 12;
					months_difference = 0;
				} else {
					years_difference = (int) differenceInMonths / 12;
					months_difference = (int) differenceInMonths % 12;
				}
				emp.setYashExperiene(years_difference + "." + months_difference);

				// Calculate TotalExperience

				String prevExp = emp.getExprience();

				String currentExp = emp.getYashExperiene();

				String[] split1 = prevExp.split("\\.");
				int parseInt1 = Integer.parseInt(split1[0]);

				int parseInt2 = Integer.parseInt(split1[1]);

				String[] split2 = currentExp.split("\\.");

				int parseInt3 = Integer.parseInt(split2[0]);

				int parseInt4 = Integer.parseInt(split2[1]);
				if (parseInt2 + parseInt4 > 12) {
					parse5 = parseInt2 + parseInt4;
					int month = parse5 % 12;
					totalyearsExp = parseInt1 + parseInt3 + 1;
					System.out.println("totalyearsExp " + totalyearsExp);
					totalmthExp = month;
					System.out.println("totalMthExp " + totalmthExp);
				} else {
					totalmthExp = parseInt2 + parseInt4;
					totalyearsExp = parseInt1 + parseInt3;
					System.out.println("totalyearsExp " + totalyearsExp);
					System.out.println("totalMthExp " + totalmthExp);
				}
				emp.setTotalExperience(totalyearsExp + "." + totalmthExp);

			}

			lists.add(emp);

		}
		return lists;
	}

	@Override
	public Optional<Employee> getEmpById(int id) {

		Optional<Employee> emp = empRepo.findById(id);
		if (!emp.isEmpty()) {
			Optional<Employee> name = Optional.ofNullable(emp.get());
			name.ifPresentOrElse(n -> System.out.println("Employee of id " + id + " is present"),
					() -> System.out.println("Sorry Employee is not present"));
		} else
			System.out.println("Employee of id " + id + " is not present");
		return emp;

	}

	@Override
	public void deleteEmpById(int id) {

		Optional<Employee> emp = Optional.ofNullable(new Employee());
		try {
			emp = getEmpById(id);
			if (emp != null) {
				empRepo.deleteById(id);

			}
		} catch (Exception e) {
			System.out.println("Exception while removing Employee");
		}

	}

	@Override
	public Employee updateEmpById(int id, Employee emp) {
		Optional<Employee> op = empRepo.findById(id);
		
		if (op.isPresent()) {
			Employee eo = op.get();
			eo.setEmployeeId(emp.getEmployeeId());
			eo.setEmployeeName(emp.getEmployeeName());
			eo.setGrade(emp.getGrade());
			eo.setDob(emp.getDob());
			eo.setEmail(emp.getEmail());
			eo.setMobileNo(emp.getMobileNo());
			eo.setDateOfJoining(emp.getDateOfJoining());
			eo.setExprience(emp.getExprience());
			eo.setBaseLocation(emp.getBaseLocation());
			eo.setCurrentLocation(emp.getCurrentLocation());
			eo.setYashExperiene(emp.getYashExperiene());
			eo.setTotalExperience(emp.getTotalExperience());
			
			

			empRepo.save(emp);
		} else {
			System.out.println("Employee not available");
		}
		System.out.println("Employee Updating Successfully ");
		return emp;
	}

	@Override
	public Employee findByEmployeeIdAndEmployeeName(Integer employeeId, String employeeName) {

		Employee emp = empRepo.findByEmployeeIdAndEmployeeName(employeeId, employeeName);

		return emp;
	}

	@Override
	public EmployeeDto searchByEmployeeIdAndEmployeeName(Integer employeeId, String employeeName) {
		Employee emp=empRepo.searchByEmployeeIdAndEmployeeName(employeeId, employeeName);
		return this.convertEntityToDto(emp);
	}

	public EmployeeDto convertEntityToDto(Employee emp) {
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setEmployeeId(emp.getEmployeeId());
		employeeDto.setEmployeeName(emp.getEmployeeName());
		employeeDto.setMobileNo(emp.getMobileNo());
		employeeDto.setEvalList(emp.getEvalList());
		 return employeeDto;

}

	@Override
	public Evaluation addEvatuationDetailsById(  int employeeId, Evaluation eva) {
     Optional<Employee> op = empRepo.findById(employeeId);
     
		Evaluation eval=new Evaluation();
		List<Evaluation> eList=new ArrayList<>();
	
		if (op.isPresent() ) {
			Employee eo = op.get();
			
			eList=eo.getEvalList();
			
			eval.setEvaluationDate(eva.getEvaluationDate());
			eval.setOverallComment(eva.getOverallComment());
			eval.setOverallRating(eva.getOverallRating());
			eval.setSkills(eva.getSkills());
			eList.add(eval);
	
		    eo.setEvalList(eList);
		    empRepo.save(eo);
		} else {
			System.out.println("Evaluation not available");
		}
		System.out.println("Evaluation Updating Successfully ");
		System.out.println(eva);
		
		return eva;
}
}
/*
 * List<Employee> list=new ArrayList<>(); try {
 * 
 * if (empRepo.findAll() != null || empRepo.findAll().size() > 0 ) {
 * 
 * list.addAll(calcuteYashExperience(empRepo.findAll()));
 * list.addAll(calcuteTotalExperience(empRepo.findAll())); }
 * 
 * 
 * }catch(Exception e) { System.out.println(e); }
 * 
 * private List<Employee> calcuteYashExperience(List<Employee> empList) {
 * Employee emp = null; List<Employee> lists = new ArrayList<>(); java.util.Date
 * currentDate = new java.util.Date(System.currentTimeMillis()); int
 * years_difference = 0; int months_difference = 0; for (Employee e : empList) {
 * if (e != null) { emp = e; Date dateOfJoining = emp.getDateOfJoining(); long
 * time_difference = currentDate.getTime() - dateOfJoining.getTime();
 * 
 * // calculate months long differenceInMonths =
 * TimeUnit.MILLISECONDS.toDays(time_difference) / 30;
 * 
 * if (differenceInMonths % 12 == 0) { years_difference = (int)
 * differenceInMonths / 12; months_difference = 0; } else { years_difference =
 * (int) differenceInMonths / 12; months_difference = (int) differenceInMonths %
 * 12; } //float yashExperience= years_difference + months_difference/10;
 * //  emp.setYashExperiene(years_difference + months_difference/10);
 * emp.setYashExperiene(years_difference + "." + months_difference);
 * //System.out.println(emp.getYashExperiene()); }
 * 
 * lists.add(emp);
 * 
 * List<Employee> eList=new ArrayList<>();
 * eList=calcuteTotalExperience(empRepo.findAll()); lists.addAll(eList);
 * 
 * } return lists; }
 * 
 * public List<Employee> calcuteTotalExperience(List<Employee> empList) {
 * Employee emp = null; List<Employee> lists = new ArrayList<>();
 * 
 * 
 * 
 * 
 * int totalyearsExp; int totalmthExp;
 * 
 * int parse5;
 * 
 * for (Employee e : empList) { if (e != null ) { emp = e; String
 * prevExp=emp.getExprience();
 * 
 * String currentExp=emp.getYashExperiene();
 * 
 * String[] split1 = prevExp.split("\\."); int parseInt1 =
 * Integer.parseInt(split1[0]);
 * 
 * int parseInt2 = Integer.parseInt(split1[1]);
 * 
 * String[] split2 = currentExp.split("\\.");
 * 
 * int parseInt3 = Integer.parseInt(split2[0]);
 * 
 * int parseInt4 = Integer.parseInt(split2[1]); if(parseInt2+parseInt4>12) {
 * parse5=parseInt2+parseInt4; int month=parse5%12;
 * totalyearsExp=parseInt1+parseInt3+1;
 * System.out.println("totalyearsExp "+totalyearsExp); totalmthExp=month;
 * System.out.println("totalMthExp "+totalmthExp); } else {
 * totalmthExp=parseInt2+parseInt4; totalyearsExp=parseInt1+parseInt3;
 * System.out.println("totalyearsExp "+totalyearsExp);
 * System.out.println("totalMthExp "+totalmthExp); }
 * emp.setTotalExperience(totalyearsExp+"."+totalmthExp);
 * 
 * } lists.add(emp); List<Employee> eList=new ArrayList<>();
 * eList=calcuteYashExperience(empRepo.findAll()); lists.addAll(eList); } return
 * lists; }
 */
