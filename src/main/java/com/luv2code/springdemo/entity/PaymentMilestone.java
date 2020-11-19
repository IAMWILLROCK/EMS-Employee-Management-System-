package com.luv2code.springdemo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "PAYMENT_MILESTONE")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMilestone {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MILESTONE_ID")
	private int milestoneId;

	@Column(name = "PROJECT_CODE")
	private String projectCode;
	
	@Column(name = "MILESTONE_NAME")
	private String milestoneName;

	@Temporal(TemporalType.DATE)
	@Column(name = "COMPLETION_DATE_AS_PER_SOW")
	private Date completionDateAsPerSow;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACTUAL_COMPLETION_DATE")
	private Date actualCompletionDate;

	@Column(name = "BILLED")
	private boolean billed;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ATTACHMENT_ID")
	private PaymentMilestoneAttachment invoice;
	
	public PaymentMilestone(){
		
	}
	
	public int getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(int milestoneId) {
		this.milestoneId = milestoneId;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getCompletionDateAsPerSow() {
		return completionDateAsPerSow;
	}

	public void setCompletionDateAsPerSow(Date completionDateAsPerSow) {
		this.completionDateAsPerSow = completionDateAsPerSow;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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

	public PaymentMilestoneAttachment getInvoice() {
		return invoice;
	}

	public void setInvoice(PaymentMilestoneAttachment invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "PaymentMilestone [milestoneId=" + milestoneId + ", projectCode=" + projectCode + ", milestoneName="
				+ milestoneName + ", completionDateAsPerSow=" + completionDateAsPerSow + ", actualCompletionDate="
				+ actualCompletionDate + ", billed=" + billed + ", invoice=" + invoice + "]";
	}

}
