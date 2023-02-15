package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int evaluationId;
	private int overallRating;
	private String overallComment;
	@Temporal(TemporalType.DATE)
	private Date evaluationDate;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_skills_fk")
    private List<Skills> skills=new ArrayList<>();
	public int getEvaluationId() {
		return evaluationId;
	}
	public void setEvaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
	}
	public int getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}
	public String getOverallComment() {
		return overallComment;
	}
	public void setOverallComment(String overallComment) {
		this.overallComment = overallComment;
	}
	public Date getEvaluationDate() {
		return evaluationDate;
	}
	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}
	public List<Skills> getSkills() {
		return skills;
	}
	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}
	public Evaluation(int evaluationId, int overallRating, String overallComment, Date evaluationDate,
			List<Skills> skills) {
		super();
		this.evaluationId = evaluationId;
		this.overallRating = overallRating;
		this.overallComment = overallComment;
		this.evaluationDate = evaluationDate;
		this.skills = skills;
	}
	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Evaluation [evaluationId=" + evaluationId + ", overallRating=" + overallRating + ", overallComment="
				+ overallComment + ", evaluationDate=" + evaluationDate + ", skills=" + skills + "]";
	}
	
	
	
}
