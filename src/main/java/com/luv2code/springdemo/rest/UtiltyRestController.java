package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.dto.ManagerDropdownDto;
import com.luv2code.springdemo.entity.Country;
import com.luv2code.springdemo.entity.Department;
import com.luv2code.springdemo.entity.Designation;
import com.luv2code.springdemo.entity.FunctionalDomain;
import com.luv2code.springdemo.entity.Grade;
import com.luv2code.springdemo.entity.Region;
import com.luv2code.springdemo.entity.Skills;
import com.luv2code.springdemo.service.UtilityService;

@RestController
@RequestMapping("/rmg")
public class UtiltyRestController {

	@Autowired
	private UtilityService utilityService;

	@GetMapping("/countries")
	public List<Country> getCountries() {
		System.out.println("Im in the getCountries");
		return utilityService.getCountries();
	}

	@PostMapping("/countries")
	public Country addCountry(@RequestBody Country theCountry) {
		utilityService.saveCountry(theCountry);
		System.out.println("Added the Country: " + theCountry);
		return theCountry;
	}

	@GetMapping("/grades")
	public List<Grade> getGrades() {
		System.out.println("Fetching the Grades");
		return utilityService.getGrades();
	}

	@GetMapping("/departments")
	public List<Department> getDepartments() {
		System.out.println("Fetching the departments");
		return utilityService.getDepartments();
	}

	@GetMapping("/designations")
	public List<Designation> getDesignations() {
		System.out.println("Fetching the Designations");
		return utilityService.getDesignations();
	}

	@GetMapping("/skills")
	public List<Skills> getSkills() {
		System.out.println("Fetching the skills");
		return utilityService.getSkills();
	}



	@GetMapping("/pskills")
	public List<Skills> getPSkills() {
		System.out.println("Fetching the Primary Skills");
		return utilityService.getPSkills();
	}

	@GetMapping("/sskills")
	public List<Skills> getSSkills() {
		System.out.println("Fetching the Secondary Skills");
		return utilityService.getSSkills();
	}

	@GetMapping("/functionalDomain")
	public List<FunctionalDomain> getFunctionalDomain() {
		System.out.println("Fetching the FunctionalDomain");
		return utilityService.getFunctionalDomain();
	}
	
	@GetMapping("/projectManager")
	public List<ManagerDropdownDto> getProjectManager()
	{
		return utilityService.getProjectManagerName();
	}
	
	@GetMapping("/deliveryManager")
	public List<ManagerDropdownDto> getDeliveryManager()
	{
		return utilityService.getDeliveryManagerName();
	}
	
	@GetMapping("/countries/{regionId}")
	public List<Country> getCountriesByRegion(@PathVariable String regionId) {
		
		return utilityService.getCountriesByRegion(regionId);
	}
	
	@GetMapping("/regions")
	public List<Region> getRegions()
	{
		return utilityService.getRegions();
	}
}