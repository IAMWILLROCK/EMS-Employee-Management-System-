package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.dto.ProjectDetailsDto;
import com.luv2code.springdemo.dto.ProjectMilestonesDto;
import com.luv2code.springdemo.dto.ProjectNameDto;
import com.luv2code.springdemo.entity.PaymentMilestone;
import com.luv2code.springdemo.message.ResponseMessage;
import com.luv2code.springdemo.service.MilestoneService;
import com.luv2code.springdemo.service.ProjectDetailsService;

@RestController
@RequestMapping("/project")
public class ProjectDetailsController {

	@Autowired
	private MilestoneService milestoneService;

	@Autowired
	private ProjectDetailsService projectDetailsService;

	@PostMapping("/milestones")
	public ResponseEntity<ResponseMessage> saveMilestoneDetails(
			@RequestBody List<ProjectMilestonesDto> theProjectMilestonesDto) {
		System.out.println("Inside the controller");
		try {
			for (ProjectMilestonesDto currentProjectDetailsDto : theProjectMilestonesDto) {
				currentProjectDetailsDto.setMilestoneId(0);
				currentProjectDetailsDto.getInvoice().setAttachmentId(0);
			}
			milestoneService.saveMilestoneDetails(theProjectMilestonesDto);
			String message = "Milestones saved Succesfully";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			String message = "Couldn't save";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}

	}

	@PutMapping("/milestones")
	public ResponseEntity<ResponseMessage> updateMilestoneDetails(
			@RequestBody List<ProjectMilestonesDto> theProjectMilestonesDto) {
		System.out.println("Inside the controller");
		try {
			milestoneService.saveMilestoneDetails(theProjectMilestonesDto);
			String message = "Milestones updated Succesfully";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			String message = "Couldn't save";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}

	}

	@GetMapping("/milestones/{projectCode}")
	public ResponseEntity<List<PaymentMilestone>> getMilestoneDetails(@PathVariable String projectCode) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(milestoneService.getMilestoneDetails(projectCode));
		} catch (Exception e) {
			e.printStackTrace();
			List<PaymentMilestone> milestoneList = new ArrayList<>();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(milestoneList);
		}
	}

	@GetMapping("/projDetails/{projectCode}")
	public ProjectDetailsDto getProjectDetails(@PathVariable String projectCode) {

		// Retrive the resourceId from the service and push it out

		return projectDetailsService.getProjectDetails(projectCode);
	}

	@PostMapping("/projDetails")
	public ProjectDetailsDto addProjectDetails(@RequestBody ProjectDetailsDto projectDetailsDto) {

		projectDetailsService.saveProjectDetails(projectDetailsDto);

		return projectDetailsDto;
	}

	@PutMapping("/projDetails")
	public ProjectDetailsDto updateResourceDetails(@RequestBody ProjectDetailsDto projectDetailsDto) {

		projectDetailsService.saveProjectDetails(projectDetailsDto);

		return projectDetailsDto;
	}

	@GetMapping("/projDetails")
	public List<ProjectDetailsDto> getProjects() {

		return projectDetailsService.getAll();
	}

	@GetMapping("/upcomProj")
	public List<ProjectDetailsDto> getUpcoming() {

		return projectDetailsService.getUpcoming();
	}

	@GetMapping("/ongoingProj")
	public List<ProjectDetailsDto> getOngoing() {

		return projectDetailsService.getOngoing();
	}

	@GetMapping("/completedProj")
	public List<ProjectDetailsDto> getCompleted() {

		return projectDetailsService.getCompleted();
	}
	
	@GetMapping("/name")
	public List<ProjectNameDto> getProjectName() {

		return projectDetailsService.getProjectName();
	}

}
