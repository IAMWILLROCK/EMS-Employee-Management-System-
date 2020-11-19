package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.dto.ResDetailsDto;

public interface ResDetailsDAO {

	public List<ResDetailsDto> getAll();
	
	public ResDetailsDto getResourceDetails(String resourceId);
	
	public void saveResourceDetails(ResDetailsDto resDetailsDto);
	
	public void saveAll(List<ResDetailsDto> resDetailsDtoList);
//	public List<ResDetails> getResourceDetailsbyDepartmentId(String departmentId);
	
}
