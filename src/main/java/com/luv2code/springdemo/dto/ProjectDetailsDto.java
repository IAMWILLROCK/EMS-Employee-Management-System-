package com.luv2code.springdemo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luv2code.springdemo.entity.ProjectDetailsAttachment;

public class ProjectDetailsDto {

	
	
	//***************************************
	private String projectCode;
	private String projectName;
	private String region;
	private String country;
	private String projectDescription;
	private String projectDomain;
	private Date projectStartDate;
	private Date projectEndDate;
	private int resourcePlanned;
	private Double projectedMargin;
	private String projectManagerName;
	private String deliveryManagerName;
	private String dealValue;
	private String actualValue;
	private String budgetedValue;
	private boolean isProposalSignedOff;
	private boolean isSalesToDeliveryHandover;
	private boolean isMsaSignedOff;
	private boolean isNdaSignedOff;
	private boolean isPoSignedOff;
	private int status;
	private ProjectDetailsAttachment sowProposalAttachment;
	private ProjectDetailsAttachment salesToDeliveryHandoverAttachment;
	private ProjectDetailsAttachment msaSignedOffAttachment;
	private ProjectDetailsAttachment ndaSignedOffAttachment;
	private ProjectDetailsAttachment poSignedOffAttachment;
	

	public ProjectDetailsDto() {

	}


	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getProjectDomain() {
		return projectDomain;
	}
	public void setProjectDomain(String projectDomain) {
		this.projectDomain = projectDomain;
	}
    
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getProjectStartDate() {
		return projectStartDate;
	}


	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getProjectEndDate() {
		return projectEndDate;
	}


	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}


	public int getResourcePlanned() {
		return resourcePlanned;
	}
	public void setResourcePlanned(int resourcePlanned) {
		this.resourcePlanned = resourcePlanned;
	}
	public Double getProjectedMargin() {
		return projectedMargin;
	}
	public void setProjectedMargin(Double projectedMargin) {
		this.projectedMargin = projectedMargin;
	}
	public String getProjectManagerName() {
		return projectManagerName;
	}
	public void setProjectManagerName(String projectManagerName) {
		this.projectManagerName = projectManagerName;
	}
	public String getDeliveryManagerName() {
		return deliveryManagerName;
	}
	public void setDeliveryManagerName(String deliveryManagerName) {
		this.deliveryManagerName = deliveryManagerName;
	}
	public String getDealValue() {
		return dealValue;
	}
	public void setDealValue(String dealValue) {
		this.dealValue = dealValue;
	}
	public String getActualValue() {
		return actualValue;
	}
	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}
	public String getBudgetedValue() {
		return budgetedValue;
	}
	public void setBudgetedValue(String budgetedValue) {
		this.budgetedValue = budgetedValue;
	}
	public boolean isProposalSignedOff() {
		return isProposalSignedOff;
	}
	public void setIsProposalSignedOff(boolean isProposalSignedOff) {
		this.isProposalSignedOff = isProposalSignedOff;
	}
	public boolean isSalesToDeliveryHandover() {
		return isSalesToDeliveryHandover;
	}
	public void setIsSalesToDeliveryHandover(boolean isSalesToDeliveryHandover) {
		this.isSalesToDeliveryHandover = isSalesToDeliveryHandover;
	}
	public boolean isMsaSignedOff() {
		return isMsaSignedOff;
	}
	public void setIsMsaSignedOff(boolean isMsaSignedOff) {
		this.isMsaSignedOff = isMsaSignedOff;
	}
	public boolean isNdaSignedOff() {
		return isNdaSignedOff;
	}
	public void setIsNdaSignedOff(boolean isNdaSignedOff) {
		this.isNdaSignedOff = isNdaSignedOff;
	}
	public boolean isPoSignedOff() {
		return isPoSignedOff;
	}
	public void setIsPoSignedOff(boolean isPoSignedOff) {
		this.isPoSignedOff = isPoSignedOff;
	}


	public ProjectDetailsAttachment getSowProposalAttachment() {
		return sowProposalAttachment;
	}


	public void setSowProposalAttachment(ProjectDetailsAttachment sowProposalAttachment) {
		this.sowProposalAttachment = sowProposalAttachment;
	}


	public ProjectDetailsAttachment getSalesToDeliveryHandoverAttachment() {
		return salesToDeliveryHandoverAttachment;
	}


	public void setSalesToDeliveryHandoverAttachment(ProjectDetailsAttachment salesToDeliveryHandoverAttachment) {
		this.salesToDeliveryHandoverAttachment = salesToDeliveryHandoverAttachment;
	}


	public ProjectDetailsAttachment getMsaSignedOffAttachment() {
		return msaSignedOffAttachment;
	}


	public void setMsaSignedOffAttachment(ProjectDetailsAttachment msaSignedOffAttachment) {
		this.msaSignedOffAttachment = msaSignedOffAttachment;
	}


	public ProjectDetailsAttachment getNdaSignedOffAttachment() {
		return ndaSignedOffAttachment;
	}


	public void setNdaSignedOffAttachment(ProjectDetailsAttachment ndaSignedOffAttachment) {
		this.ndaSignedOffAttachment = ndaSignedOffAttachment;
	}


	public ProjectDetailsAttachment getPoSignedOffAttachment() {
		return poSignedOffAttachment;
	}


	public void setPoSignedOffAttachment(ProjectDetailsAttachment poSignedOffAttachment) {
		this.poSignedOffAttachment = poSignedOffAttachment;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
}
