package com.luv2code.springdemo.service;

import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.ResourceAllocationDAO;
import com.luv2code.springdemo.dto.ResourceAllocationDto;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

	@Autowired
	private ResourceAllocationDAO resourceAllocationDAO;
	
	@Override
	@Transactional
	public void save(ResourceAllocationDto resourceAllocationDto) throws ParseException {
		resourceAllocationDAO.save(resourceAllocationDto);
	}

	@Override
	@Transactional
	public List<ResourceAllocationDto> getByResourceId(String resourceId) {
		return resourceAllocationDAO.getByResourceId(resourceId);
	}
	
	@Override
	@Transactional
	public List<ResourceAllocationDto> getByProjectCode(String projectCode) {
		return resourceAllocationDAO.getByProjectCode(projectCode);
	}

}
