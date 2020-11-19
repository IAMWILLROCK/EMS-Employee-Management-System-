package com.luv2code.springdemo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springdemo.dto.ResDetailsDto;
import com.luv2code.springdemo.dto.ResourceAllocationDto;
import com.luv2code.springdemo.dto.ResourceNameDto;

public interface ResDetailsService {

	public List<ResDetailsDto> getAll();

	public ResDetailsDto getResourceDetails(String resourceId);

	public void addResourceDetails(ResDetailsDto resDetailsDto);

	// public List<ResDetails> getResourcesByDepartment(String departmentId);

	public void save(MultipartFile file);
	
	public ByteArrayInputStream load();

	public ByteArrayInputStream loadAllocation(List<ResourceAllocationDto> theDto, List<ResourceNameDto> theName);

	
}