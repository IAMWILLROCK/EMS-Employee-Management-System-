package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.AllocationPyramidDAO;
import com.luv2code.springdemo.dao.UtilityDAO;
import com.luv2code.springdemo.dto.ManagerDropdownDto;
import com.luv2code.springdemo.entity.AllocationPyramid;
import com.luv2code.springdemo.entity.Country;
import com.luv2code.springdemo.entity.Department;
import com.luv2code.springdemo.entity.Designation;
import com.luv2code.springdemo.entity.FunctionalDomain;
import com.luv2code.springdemo.entity.Grade;
import com.luv2code.springdemo.entity.Region;
import com.luv2code.springdemo.entity.Skills;


@Service
public class UtiliyServiceImpl implements UtilityService {

	@Autowired
	private UtilityDAO utilityDAO;
	
	@Autowired
	private AllocationPyramidDAO allocationPyramidDAO;
	
	@Override
	@Transactional
	public List<Country> getCountries() {
		
		return utilityDAO.getCountries();
	}

	@Override
	@Transactional
	public void saveCountry(Country theCountry) {

		utilityDAO.saveCountry(theCountry);
		
	}

	@Override
	@Transactional
	public List<Grade> getGrades() {
		
		return utilityDAO.getGrades();
	}

	@Override
	@Transactional
	public List<Department> getDepartments() {
		
		return utilityDAO.getDepartments();
	}

	@Override
	@Transactional
	public List<Designation> getDesignations() {
		
		return utilityDAO.getDesignations();
	}

	@Override
	@Transactional
	public List<Skills> getSkills() {
		return utilityDAO.getSkills();
	}

	
	@Override
	@Transactional
	public List<Skills> getPSkills() {
		return utilityDAO.getPSkills();
	}
    
	@Override
	@Transactional
	public List<Skills> getSSkills() {
		return utilityDAO.getSSkills();
	}
	
	@Override
	@Transactional
	public List<FunctionalDomain> getFunctionalDomain() {
		
		return utilityDAO.getFunctionalDomain();
	}
	
	@Override
	@Transactional
	public List<ManagerDropdownDto> getDeliveryManagerName()  {
		
		return utilityDAO.getDeliveryManagerName();
	}
	
	@Override
	@Transactional
	public List<ManagerDropdownDto> getProjectManagerName()  {
		
		return utilityDAO.getProjectManagerName();
	}
	
	@Override
	@Transactional
	public AllocationPyramid getPyramid(String grade)
	{
		return allocationPyramidDAO.getPyramid(grade);
	}
	
	@Override
	@Transactional
	public List<Country> getCountriesByRegion(String regionId) {
		
		return utilityDAO.getCountriesByRegion(regionId);
	}
	
	@Override
	@Transactional
	public List<Region> getRegions() {
		
		return utilityDAO.getRegions();
	}
}