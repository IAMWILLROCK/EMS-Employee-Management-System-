package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.dto.ProjectDetailsDto;
import com.luv2code.springdemo.dto.ProjectNameDto;


public interface ProjectDetailsService {

	public List<ProjectDetailsDto> getAll();

	public ProjectDetailsDto getProjectDetails(String projectCode);

	public void saveProjectDetails(ProjectDetailsDto theprojectDetailsDto);

	public List<ProjectDetailsDto> getUpcoming();

	public List<ProjectDetailsDto> getOngoing();

	public List<ProjectDetailsDto> getCompleted();

	public List<ProjectNameDto> getProjectName();
	
	

}
