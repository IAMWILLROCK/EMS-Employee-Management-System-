package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.luv2code.springdemo.composite.SkillsPK;

@Entity
@Table(name="Skills")
public class Skills {
	
	@EmbeddedId
	private SkillsPK skillsPK;

	@Column(name="SKILL_NAME")
	private String sName;

	
	public Skills() {
		
	}

  

	public SkillsPK getSkillsPK() {
		return skillsPK;
	}



	public void setSkillsPK(SkillsPK skillsPK) {
		this.skillsPK = skillsPK;
	}



	public String getSname() {
		return sName;
	}



	public void setSname(String sName) {
		this.sName = sName;
	}
	
	
}





