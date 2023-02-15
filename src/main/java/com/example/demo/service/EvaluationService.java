package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Evaluation;

public interface EvaluationService {
	
	public Evaluation addEvatuationDetailsById(int id,Evaluation eva);
    public List<Evaluation> getAllEvaluation();
	void deleteEmployee(Integer evaluationId);
	public Evaluation findByEmployeeId(Integer evaluationId );
	public Evaluation updateEvaluation(Evaluation evaluation,Integer evaluationId);

}
