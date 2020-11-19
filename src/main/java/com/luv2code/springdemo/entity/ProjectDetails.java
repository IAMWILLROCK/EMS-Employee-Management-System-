package com.luv2code.springdemo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PROJECT_DETAILS")

public class ProjectDetails {

	@Id
	@Column(name = "PROJECT_CODE")
	private String projectCode;
	
	@Column(name="PROJECT_NAME")
	private String projectName;

	@Column(name = "PROJECT_REGION")
	private String region;

	@Column(name = "PROJECT_COUNTRY")
	private String country;

	@Column(name = "PROJECT_DESCRIPTION")
	private String projectDescription;

	@Column(name = "PROJECT_DOMAIN")
	private String projectDomain;

	@Column(name = "PROJECT_START_DATE")
	@Temporal(TemporalType.DATE)
	private Date ProjectStartDate;

	@Column(name = "PROJECT_END_DATE")
	@Temporal(TemporalType.DATE)
	private Date ProjectEndDate;

	@Column(name = "RESOURCE_PLANNED")
	private int resourcePlanned;

	@Column(name = "PROJECTED_MARGIN")
	private Double projectedMargin;

	@Column(name = "PROJECT_MANAGER_NAME")
	private String projectManagerName;

	@Column(name = "DELIVERY_MANAGER_NAME")
	private String deliveryManagerName;

	@Column(name = "DEAL_VALUE")
	private String dealValue;

	@Column(name = "ACTUAL_VALUE")
	private String actualValue;

	@Column(name = "BUDGETED_VALUE")
	private String budgetedValue;

	@Column(name = "IS_PROPOSAL_SIGNED_OFF")
	private boolean isProposalSignedOff;

	@Column(name = "IS_SALES_TO_DELIVERY_HANDOVER")
	private boolean isSalesToDeliveryHandover;

	@Column(name = "IS_MSA_SIGNED_OFF")
	private boolean isMsaSignedOff;

	@Column(name = "IS_NDA_SIGNED_OFF")
	private boolean isNdaSignedOff;

	@Column(name = "IS_PO_SIGNED_OFF")
	private boolean isPoSignedOff;

	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "SOW_PROPOSAL_ATTACHMENT")
	@JsonIgnore
	private ProjectDetailsAttachment sowProposalAttachment;

	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "SALES_TO_DELIVERY_HANDOVER_ATTACHMENT")
	@JsonIgnore
	private ProjectDetailsAttachment salesToDeliveryHandoverAttachment;

	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "MSA_SIGNED_OFF_ATTACHMENT")
	@JsonIgnore
	private ProjectDetailsAttachment msaSignedOffAttachment;

	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "NDA_SIGNED_OFF_ATTACHMENT")
	@JsonIgnore
	private ProjectDetailsAttachment ndaSignedOffAttachment;

	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "PO_SIGNED_OFF_ATTACHMENT")
	@JsonIgnore
	private ProjectDetailsAttachment poSignedOffAttachment;

	@Column(name = "STATUS")
	private int status;

	public ProjectDetails() {

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
		return ProjectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		ProjectStartDate = projectStartDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getProjectEndDate() {
		return ProjectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		ProjectEndDate = projectEndDate;
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

	@Override
	public String toString() {
		return "ProjectDetails [projectCode=" + projectCode + ", projectName=" + projectName + ", region=" + region
				+ ", country=" + country + ", projectDescription=" + projectDescription + ", projectDomain="
				+ projectDomain + ", ProjectStartDate=" + ProjectStartDate + ", ProjectEndDate=" + ProjectEndDate
				+ ", resourcePlanned=" + resourcePlanned + ", projectedMargin=" + projectedMargin
				+ ", projectManagerName=" + projectManagerName + ", deliveryManagerName=" + deliveryManagerName
				+ ", dealValue=" + dealValue + ", actualValue=" + actualValue + ", budgetedValue=" + budgetedValue
				+ ", isProposalSignedOff=" + isProposalSignedOff + ", isSalesToDeliveryHandover="
				+ isSalesToDeliveryHandover + ", isMsaSignedOff=" + isMsaSignedOff + ", isNdaSignedOff="
				+ isNdaSignedOff + ", isPoSignedOff=" + isPoSignedOff + ", sowProposalAttachment="
				+ sowProposalAttachment + ", salesToDeliveryHandoverAttachment=" + salesToDeliveryHandoverAttachment
				+ ", msaSignedOffAttachment=" + msaSignedOffAttachment + ", ndaSignedOffAttachment="
				+ ndaSignedOffAttachment + ", poSignedOffAttachment=" + poSignedOffAttachment + ", status=" + status
				+ "]";
	}

	
}
