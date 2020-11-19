package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.dto.ResourceAllocationPyramidDto;
import com.luv2code.springdemo.service.ResourceAllocationPyramidService;

@RestController
@RequestMapping("/pyramid")
public class ResourceAllocationPyramidController {
	@Autowired
	private ResourceAllocationPyramidService resourceAllocationPyramidService;

	
	@GetMapping("/project/{projectCode}")
	public List<ResourceAllocationPyramidDto> getPyramid(@PathVariable String projectCode){
		resourceAllocationPyramidService.calculatePyramid(projectCode);
		return resourceAllocationPyramidService.getPyramid(projectCode);
	}
	
}
