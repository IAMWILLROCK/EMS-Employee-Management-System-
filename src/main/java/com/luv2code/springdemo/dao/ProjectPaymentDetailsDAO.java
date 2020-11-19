package com.luv2code.springdemo.dao;


import java.text.ParseException;
import java.util.List;

import com.luv2code.springdemo.dto.ProjectMilestonesDto;
import com.luv2code.springdemo.entity.PaymentMilestone;


public interface ProjectPaymentDetailsDAO {
	
	public void savePaymentMilestones(List<ProjectMilestonesDto> theProjectDetailsDto) throws ParseException;
	
	public List<PaymentMilestone> getPaymentMilestones(String projectCode);
}
