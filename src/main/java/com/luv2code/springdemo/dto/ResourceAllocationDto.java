package com.luv2code.springdemo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResourceAllocationDto {

	private String resourceId;
	private String projectCode;
	private String projectName;
	private Date startDate;
	private Date endDate;
	private double utilizationCapacity;
	private double billedCapacity;
	
	public ResourceAllocationDto(){
		
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getUtilizationCapacity() {
		return utilizationCapacity;
	}

	public void setUtilizationCapacity(double utilizationCapacity) {
		this.utilizationCapacity = utilizationCapacity;
	}

	public double getBilledCapacity() {
		return billedCapacity;
	}

	public void setBilledCapacity(double billedCapacity) {
		this.billedCapacity = billedCapacity;
	}
	
	
	
}
