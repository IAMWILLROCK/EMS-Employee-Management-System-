package com.luv2code.springdemo.dto;

import java.util.Date;

import com.luv2code.springdemo.entity.PaymentMilestoneAttachment;

public class ProjectMilestonesDto {
	private String projectCode;

	private String milestoneName;

	private int milestoneId;

	private Date completionDateAsPerSow;

	private Date actualCompletionDate;

	private boolean billed;

	private PaymentMilestoneAttachment invoice;

	public PaymentMilestoneAttachment getInvoice() {
		return invoice;
	}

	public void setInvoice(PaymentMilestoneAttachment invoice) {
		this.invoice = invoice;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getMilestoneName() {
		return milestoneName;
	}

	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}

	public int getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(int milestoneId) {
		this.milestoneId = milestoneId;
	}

	public Date getCompletionDateAsPerSow() {
		return completionDateAsPerSow;
	}

	public void setCompletionDateAsPerSow(Date completionDateAsPerSow) {
		this.completionDateAsPerSow = completionDateAsPerSow;
	}

	public Date getActualCompletionDate() {
		return actualCompletionDate;
	}

	public void setActualCompletionDate(Date actualCompletionDate) {
		this.actualCompletionDate = actualCompletionDate;
	}

	public boolean isBilled() {
		return billed;
	}

	public void setBilled(boolean billed) {
		this.billed = billed;
	}

}
