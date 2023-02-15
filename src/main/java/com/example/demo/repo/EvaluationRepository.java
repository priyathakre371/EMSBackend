package com.example.demo.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Evaluation;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Integer>{

}
