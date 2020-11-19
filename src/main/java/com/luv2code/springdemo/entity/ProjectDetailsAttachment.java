package com.luv2code.springdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="PROJECT_DETAILS_ATTACHMENT")
public class ProjectDetailsAttachment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ATTACHMENT_ID")
	private int attachmentId;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="FILE_TYPE")
	private String fileType;

	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_AT")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@Column(name="FILE_CONTENT")
	@Lob
	private String fileContent;
	
	public ProjectDetailsAttachment()
	{
	}

	public int getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	@Override
	public String toString() {
		return "ProjectDetailsAttachment [attachmentId=" + attachmentId + ", fileName=" + fileName + ", fileType="
				+ fileType + ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", fileContent=" + fileContent
				+ "]";
	}
	
	

}

