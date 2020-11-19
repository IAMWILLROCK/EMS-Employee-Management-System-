package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.dto.ProjectDetailsDto;
import com.luv2code.springdemo.dto.ProjectNameDto;


public interface ProjectDetailsDAO {

	public List<ProjectDetailsDto> getAll();

	public ProjectDetailsDto getProjectDetails(String projectCode);

	public void saveProjectDetails(ProjectDetailsDto projectDetailsDto);

	public List<ProjectDetailsDto> getUpcoming();

	public List<ProjectDetailsDto> getOngoing();

	public List<ProjectDetailsDto> getCompleted();

	public List<ProjectNameDto> getProjectName();	

}
