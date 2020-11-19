package com.luv2code.springdemo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DEPARTMENT")
public class Department {

	@Id
	@Column(name="DEPARTMENT_ID")
	private String departmentId;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	
	
	/*@OneToMany(mappedBy="department",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					 CascadeType.DETACH, CascadeType.REFRESH})
	@JsonBackReference
	private List<ResDetails> resources;*/
	
	public Department(){
		
	}

	
	public Department(String departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	
/*  public List<ResDetails> getResources() {
		return resources;
	}


	public void setResources(List<ResDetails> resources) {
		this.resources = resources;
	}*/


	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}


	
	/*public void addResource(ResDetails theResDetails){
		
		if(resources == null){
			resources = new ArrayList<>();
			
		}
		
		resources.add(theResDetails);
		theResDetails.setDepartment(this);
	}
	*/
}