package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Evaluation;
import com.example.demo.service.EvaluationService;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
	
	@Autowired
	private EvaluationService evalService;
	
	@PostMapping("/addEval/{id}")
	public Evaluation addEval(@PathVariable int id,@RequestBody Evaluation eval)
	{
		return evalService.addEvatuationDetailsById(id,eval);
	}
	@GetMapping("/getAllEval")
	public List<Evaluation> getAll()
	{
		return evalService.getAllEvaluation();
	}

}
