package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ALLOCATION_PYRAMID")
public class AllocationPyramid {
	

	@Id
	@Column(name="GRADE")
	private String grade;
	
	@Column(name="PYRAMID_VALUE")
	private double pyramidValue;
	
	public AllocationPyramid()
	{
		
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getPyramidValue() {
		return pyramidValue;
	}

	public void setPyramidValue(double pyramidValue) {
		this.pyramidValue = pyramidValue;
	}

	@Override
	public String toString() {
		return "AllocationPyramid [grade=" + grade + ", pyramidValue=" + pyramidValue + "]";
	}
	
	

}
