package com.luv2code.springdemo.service;

import java.text.ParseException;
import java.util.List;

import com.luv2code.springdemo.dto.ProjectMilestonesDto;
import com.luv2code.springdemo.entity.PaymentMilestone;

public interface MilestoneService {

	public void saveMilestoneDetails(List<ProjectMilestonesDto> theProjectDetailsDto) throws ParseException;
	
	public List<PaymentMilestone> getMilestoneDetails(String projectCode);
}
