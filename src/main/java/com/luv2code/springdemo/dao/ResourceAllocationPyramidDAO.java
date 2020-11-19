package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.dto.ResourceAllocationPyramidDto;

public interface ResourceAllocationPyramidDAO {

	public void saveResourceAllocationPyramid(ResourceAllocationPyramidDto resAllocationPyramid);

	public List<ResourceAllocationPyramidDto> getResourceAllocationPyramid(String projectCode);

}
