package com.luv2code.springdemo.dao;

import java.text.ParseException;
import java.util.List;

import com.luv2code.springdemo.dto.ResourceAllocationDto;

public interface ResourceAllocationDAO {

	public void save(ResourceAllocationDto resourceAllocation) throws ParseException;
	
	public List<ResourceAllocationDto> getByResourceId(String resourceId);

	public List<ResourceAllocationDto> getByProjectCode(String projectCode);
}
