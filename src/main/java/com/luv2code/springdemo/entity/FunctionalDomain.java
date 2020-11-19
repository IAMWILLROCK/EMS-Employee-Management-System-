package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="FUNCTIONAL_DOMAIN")
public class FunctionalDomain {
	@Id
	@Column(name="FDOMAIN_ID")
	private String fDomainId;
	
	@Column(name="FDOMAIN_NAME")
	private String fDomainName;
	

	public FunctionalDomain()
	{
		
	}


	public String getfDomainId() {
		return fDomainId;
	}

	public void setfDomainId(String fDomainId) {
		this.fDomainId = fDomainId;
	}

	public String getfDomainName() {
		return fDomainName;
	}

	public void setfDomainName(String fDomainName) {
		this.fDomainName = fDomainName;
	}

	@Override
	public String toString() {
		return "FunctionalDomain [fDomainId=" + fDomainId + ", fDomainName=" + fDomainName + "]";
	}
	

}


