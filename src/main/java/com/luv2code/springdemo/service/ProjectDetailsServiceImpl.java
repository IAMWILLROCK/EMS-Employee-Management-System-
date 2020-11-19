package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ProjectDetailsDAO;
import com.luv2code.springdemo.dto.ProjectDetailsDto;
import com.luv2code.springdemo.dto.ProjectNameDto;

@Service
public class ProjectDetailsServiceImpl implements ProjectDetailsService{
	
	
		@Autowired
		private ProjectDetailsDAO projectDetailsDAO;
		

		
		@Override
		@Transactional
		public List<ProjectDetailsDto> getAll() {
			return projectDetailsDAO.getAll();
		}
		
		@Override
		@Transactional
		public List<ProjectDetailsDto> getUpcoming() {
			return projectDetailsDAO.getUpcoming();
		}
		
		@Override
		@Transactional
		public List<ProjectDetailsDto> getOngoing() {
			return projectDetailsDAO.getOngoing();
		}
		
		@Override
		@Transactional
		public List<ProjectDetailsDto> getCompleted() {
			return projectDetailsDAO.getCompleted();
		}

		@Override
		@Transactional
		public ProjectDetailsDto getProjectDetails(String projectCode) {

			return projectDetailsDAO.getProjectDetails(projectCode);
		}

		@Override
		@Transactional
		public void saveProjectDetails(ProjectDetailsDto projectDetailsDto)  {

			projectDetailsDAO.saveProjectDetails(projectDetailsDto);

		}

		@Override
		@Transactional
		public List<ProjectNameDto> getProjectName() {
			return projectDetailsDAO.getProjectName();
		}
}
