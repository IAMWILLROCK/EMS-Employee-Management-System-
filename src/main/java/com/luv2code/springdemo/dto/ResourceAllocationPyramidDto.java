package com.luv2code.springdemo.dto;

public class ResourceAllocationPyramidDto {
	
	private String projectCode;
	private String grade;
	private double pyramid;
	private double actual;
	private double variance; 



	public ResourceAllocationPyramidDto() {
	
	}



	public String getProjectCode() {
		return projectCode;
	}



	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public double getPyramid() {
		return pyramid;
	}



	public void setPyramid(double pyramid) {
		this.pyramid = pyramid;
	}



	public double getActual() {
		return actual;
	}



	public void setActual(double actual) {
		this.actual = actual;
	}



	public double getVariance() {
		return variance;
	}



	public void setVariance(double variance) {
		this.variance = variance;
	}

	

	

}
