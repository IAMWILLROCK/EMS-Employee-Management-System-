package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springdemo.dto.ResDetailsDto;
import com.luv2code.springdemo.dto.ResourceAllocationDto;
import com.luv2code.springdemo.dto.ResourceNameDto;
import com.luv2code.springdemo.exception.ResourceNotFoundException;
import com.luv2code.springdemo.helpers.ExcelHelper;
import com.luv2code.springdemo.message.ResponseMessage;
import com.luv2code.springdemo.service.ResDetailsService;
import com.luv2code.springdemo.service.ResourceAllocationPyramidService;
import com.luv2code.springdemo.service.ResourceAllocationService;

@RestController
@RequestMapping("/resource")
public class ResDetailsControlller {

	@Autowired
	private ResDetailsService resDetailsService;
	
	@Autowired
	private ResourceAllocationService resourceAllocationService;
	
	@Autowired
	private ResourceAllocationPyramidService resourceAllocationPyramidService;

	@GetMapping("/resDetails/{theResourceId}")
	public ResDetailsDto getResourceDetails(@PathVariable String theResourceId) {

		// Retrive the resourceId from the service and push it out
		ResDetailsDto tempResDetailsDto = resDetailsService.getResourceDetails(theResourceId);
		if (tempResDetailsDto == null) {
			throw new ResourceNotFoundException("The resource with id-" + theResourceId + " is not found");
		}
		return resDetailsService.getResourceDetails(theResourceId);
	}

	@PostMapping("/resDetails")
	public ResDetailsDto addResourceDetails(@RequestBody ResDetailsDto theResDetailsDto) {

		resDetailsService.addResourceDetails(theResDetailsDto);

		return theResDetailsDto;
	}

	@GetMapping("/resDetails")
	public List<ResDetailsDto> getResources() {

		return resDetailsService.getAll();
	}

	/*
	 * @GetMapping("/resDetails/department/{departmentId}") public
	 * List<ResDetails> getResourcesByDepartmentId(@PathVariable String
	 * departmentId){
	 * 
	 * return resDetailsService.getResourcesByDepartment(departmentId); }
	 */

	// This is all new Code
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		System.out.println("Inside the upload controller");
		if (ExcelHelper.hasExcelFormat(file)) {
			try {
				resDetailsService.save(file);

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}

		message = "Please upload an excel file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

	@GetMapping("/download")
	public ResponseEntity<Resource> getFile() {
		InputStreamResource file = new InputStreamResource(resDetailsService.load());
		String filename = "resource_details.xlsx";
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}

	@PutMapping("/resDetails")
	public ResDetailsDto updateResourceDetails(@RequestBody ResDetailsDto theResDetailsDto) {

		resDetailsService.addResourceDetails(theResDetailsDto);

		return theResDetailsDto;
	}

	
	@PostMapping("/allocation")
	public ResponseEntity<ResponseMessage> saveResourceAllocation(@RequestBody ResourceAllocationDto theResourceAllocationDto){
		String message = "";
		System.out.println(">>>>>saveResourceAllocation");
		try{
			resourceAllocationService.save(theResourceAllocationDto);
			message = "saved the Allocation successfully!";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		}catch(Exception e){
			message = "Couldn't save the Allocation Details!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@PutMapping("/allocation")
	public ResponseEntity<ResponseMessage> updateResourceAllocation(@RequestBody ResourceAllocationDto theResourceAllocationDto){
		String message = "";
		System.out.println(">>>>>updateResourceAllocation");
		try{
			resourceAllocationService.save(theResourceAllocationDto);
			message = "updated the Allocation successfully!";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		}catch(Exception e){
			message = "Couldn't update the Allocation Details!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@GetMapping("/allocation/resId/{theResourceId}")
	public ResponseEntity<List<ResourceAllocationDto>> geResourceAllocationsById(@PathVariable String theResourceId){
		try{
			System.out.println(">>>>>>getAllResourceList");
			List<ResourceAllocationDto> theList = resourceAllocationService.getByResourceId(theResourceId);
			System.out.println(">>>>>>ResourceAllocationDto: " + theList.get(0).getStartDate());
			System.out.println(">>>>>>ResourceAllocationDto: " + theList.get(0).getEndDate());
			return ResponseEntity.status(HttpStatus.OK).body(theList);
		}catch(Exception e){
			List<ResourceAllocationDto> theResourceAllocationList = new ArrayList<>();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(theResourceAllocationList);
		}
		
	}
	@GetMapping("/allocation/proCode/{theProjectCode}")
	public ResponseEntity<List<ResourceAllocationDto>> getResourceAllocationsByProject(@PathVariable String theProjectCode){
		try{
			System.out.println(">>>>>>getAllResourceList");
			List<ResourceAllocationDto> theList = resourceAllocationService.getByProjectCode(theProjectCode);
			System.out.println(">>>>>>ResourceAllocationDto: " + theList.get(0).getStartDate());
			System.out.println(">>>>>>ResourceAllocationDto: " + theList.get(0).getEndDate());
			return ResponseEntity.status(HttpStatus.OK).body(theList);
		}catch(Exception e){
			List<ResourceAllocationDto> theResourceAllocationList = new ArrayList<>();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(theResourceAllocationList);
		}
	}
	@GetMapping("/allocation/download/{theProjectCode}")
	public ResponseEntity<Resource> getAllocationFile(@PathVariable String theProjectCode) {
		List<ResourceAllocationDto>theList=resourceAllocationService.getByProjectCode(theProjectCode);
		List<ResourceNameDto> theName=resourceAllocationPyramidService.getName(theProjectCode);
		InputStreamResource file = new InputStreamResource(resDetailsService.loadAllocation(theList,theName));
		String filename = "report.xlsx";
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}
	
	@GetMapping("/resName/{projectCode}")
    public List<ResourceNameDto> getName(@PathVariable String projectCode){
		return resourceAllocationPyramidService.getName(projectCode);
		
	}
}