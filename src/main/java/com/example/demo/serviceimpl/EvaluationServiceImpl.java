package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Evaluation;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.EvaluationRepository;
import com.example.demo.service.EvaluationService;
@Service	
public class EvaluationServiceImpl implements EvaluationService{
	
	@Autowired
	EvaluationRepository evalRepo;
	
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Evaluation addEvatuationDetailsById(int id,Evaluation eva) {
		Employee e=empRepo.findById(id).get();

	     Evaluation evaluation=new Evaluation();
	     if(e.getEmployeeId()==id)
		{
			evaluation= evalRepo.save(eva);
		}
		return evaluation;
	}

	

	@Override
	public List<Evaluation> getAllEvaluation() {
		return evalRepo.findAll();
	}

	@Override
	public void deleteEmployee(Integer evaluationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Evaluation findByEmployeeId(Integer evaluationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evaluation updateEvaluation(Evaluation evaluation, Integer evaluationId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
