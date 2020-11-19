package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.dto.ManagerDropdownDto;
import com.luv2code.springdemo.entity.AllocationPyramid;
import com.luv2code.springdemo.entity.Country;
import com.luv2code.springdemo.entity.Department;
import com.luv2code.springdemo.entity.Designation;
import com.luv2code.springdemo.entity.FunctionalDomain;
import com.luv2code.springdemo.entity.Grade;
import com.luv2code.springdemo.entity.Region;
import com.luv2code.springdemo.entity.Skills;

public interface UtilityService {

	public List<Country> getCountries();

	public void saveCountry(Country theCountry);

	public List<Grade> getGrades();

	public List<Department> getDepartments();
	
	public List<Designation> getDesignations();
	
	public List<Skills> getSkills();

	public List<Skills> getPSkills();

	public List<Skills> getSSkills();

	public List<FunctionalDomain> getFunctionalDomain();

	public AllocationPyramid getPyramid(String grade);

	public List<ManagerDropdownDto> getDeliveryManagerName();

	public List<ManagerDropdownDto> getProjectManagerName();

	public List<Country> getCountriesByRegion(String regionId);

	public List<Region> getRegions();
}