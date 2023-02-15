package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int skillId;
	private String skillName;
	private int skillRating;
    private String skillProficiency;
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public int getSkillRating() {
		return skillRating;
	}
	public void setSkillRating(int skillRating) {
		this.skillRating = skillRating;
	}
	public String getSkillProficiency() {
		return skillProficiency;
	}
	public void setSkillProficiency(String skillProficiency) {
		this.skillProficiency = skillProficiency;
	}
	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Skills(int skillId, String skillName, int skillRating, String skillProficiency) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillRating = skillRating;
		this.skillProficiency = skillProficiency;
	}
	@Override
	public String toString() {
		return "Skills [skillId=" + skillId + ", skillName=" + skillName + ", skillRating=" + skillRating
				+ ", skillProficiency=" + skillProficiency + "]";
	}

}
