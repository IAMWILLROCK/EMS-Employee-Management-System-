package com.luv2code.springdemo.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="RES_DETAILS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResDetails {
	
	@Id
	@Column(name="RESOURCE_ID")
	private String resourceId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="MOBILE")
	private String mobile;
	
	@Column(name="EMAIL")
	private String email;
	
	
	@Column(name="SUB_GRADE_ID")
	private String subGrade;
	
	
	@Column(name="DEPARTMENT_ID")	
	private String department;
	

	@Column(name = "DESIGNATION_ID")
	private String designation;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="RESOURCE_SKILLS",
	           joinColumns=@JoinColumn(name="RESOURCE_ID"),
	           inverseJoinColumns={@JoinColumn(name="SKILL_ID",referencedColumnName="SKILL_ID"),
		        		  @JoinColumn(name="SKILL_TYPE",referencedColumnName="SKILL_TYPE")})
	@JsonManagedReference
	     private Set<Skills> skills;
	

	
	public ResDetails(){
		
	}

	public ResDetails(String resourceId, String firstName, String lastName, String mobile, String email) {
		this.resourceId = resourceId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	

	
	public String getSubGrade() {
		return subGrade;
	}

	public void setSubGrade(String subGrade) {
		this.subGrade = subGrade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Set<Skills> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}
	
    public void addSkills(Skills theSkills){
		
		if(skills == null){
			skills = new LinkedHashSet<>();
			
		}
		
		skills.add(theSkills);
	}
	

}

