package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GRADE")
public class Grade {

	@Id
	@Column(name="SUB_GRADE_ID",unique = true, nullable = false)
	private String subGradeId;
	
	
	@Column(name="GRADE_ID")
	private String gradeId;
	
	@Column(name="GRADE_VALUE")
	private String gradeValue;
	
	public Grade() {
		
	}	


	

	public Grade(String subGradeId, String gradeId, String gradeValue) {
		this.subGradeId = subGradeId;
		this.gradeId = gradeId;
		this.gradeValue = gradeValue;
	}




	public String getSubGradeId() {
		return subGradeId;
	}




	public void setSubGradeId(String subGradeId) {
		this.subGradeId = subGradeId;
	}




	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeValue() {
		return gradeValue;
	}

	public void setGradeValue(String gradeValue) {
		this.gradeValue = gradeValue;
	}
	
	
}
