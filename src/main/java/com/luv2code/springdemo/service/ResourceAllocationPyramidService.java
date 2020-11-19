package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.dto.ResourceAllocationPyramidDto;
import com.luv2code.springdemo.dto.ResourceNameDto;

public interface ResourceAllocationPyramidService {

	public void calculatePyramid(String projectCode);

	public List<ResourceAllocationPyramidDto> getPyramid(String projectCode);

	public List<ResourceNameDto> getName(String projectCode);

}
