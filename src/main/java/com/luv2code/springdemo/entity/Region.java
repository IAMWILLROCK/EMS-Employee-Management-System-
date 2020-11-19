package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGION")
public class Region {

	@Id
	@Column(name="REGION_ID", unique = true, nullable = false)
	private String regionId;
	
	@Column(name="REGION_NAME")
	private String regionName;
	
	public Region(){
		
	}

	public Region(String regionId, String regionName) {
		this.regionId = regionId;
		this.regionName = regionName;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
}
