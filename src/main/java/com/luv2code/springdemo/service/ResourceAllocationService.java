package com.luv2code.springdemo.service;

import java.text.ParseException;
import java.util.List;

import com.luv2code.springdemo.dto.ResourceAllocationDto;

public interface ResourceAllocationService {
	
	public void save(ResourceAllocationDto resourceAllocation) throws ParseException;
	
	public List<ResourceAllocationDto> getByProjectCode(String projectCode);

	public List<ResourceAllocationDto> getByResourceId(String resourceId);
}
