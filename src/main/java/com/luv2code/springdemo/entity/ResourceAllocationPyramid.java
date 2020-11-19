package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.luv2code.springdemo.composite.ResourceAllocationPyramidPK;

@Entity
@Table(name="RESOURCE_ALLOCATION_PYRAMID")
public class ResourceAllocationPyramid {

	@EmbeddedId
	private ResourceAllocationPyramidPK resourceAllocationPyramidPK;
	
	@Column(name="PYRAMID")
	private double pyramid;
	
	@Column(name="ACTUAL")
	private double actual;
	
	@Column(name="Variance")
	private double variance; 
	
	public ResourceAllocationPyramid()
	{
		
	}

	public ResourceAllocationPyramid(ResourceAllocationPyramidPK resourceAllocationPyramidPK, double pyramid,
			double actual, double variance) {
		this.resourceAllocationPyramidPK = resourceAllocationPyramidPK;
		this.pyramid = pyramid;
		this.actual = actual;
		this.variance = variance;
	}

	public ResourceAllocationPyramidPK getResourceAllocationPyramidPK() {
		return resourceAllocationPyramidPK;
	}

	public void setResourceAllocationPyramidPK(ResourceAllocationPyramidPK resourceAllocationPyramidPK) {
		this.resourceAllocationPyramidPK = resourceAllocationPyramidPK;
	}

	public double getPyramid() {
		return pyramid;
	}

	public void setPyramid(double pyramid) {
		this.pyramid = pyramid;
	}

	public double getActual() {
		return actual;
	}

	public void setActual(double actual) {
		this.actual = actual;
	}

	public double getVariance() {
		return variance;
	}

	public void setVariance(double variance) {
		this.variance = variance;
	}

	@Override
	public String toString() {
		return "ResourceAllocationPyramid [resourceAllocationPyramidPK=" + resourceAllocationPyramidPK + ", pyramid="
				+ pyramid + ", actual=" + actual + ", variance=" + variance + "]";
	}
	
	
}
