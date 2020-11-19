package com.luv2code.springdemo.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ProjectPaymentDetailsDAO;
import com.luv2code.springdemo.dto.ProjectMilestonesDto;
import com.luv2code.springdemo.entity.PaymentMilestone;

@Service
public class MilestoneServiceImpl implements MilestoneService {

	@Autowired
	private ProjectPaymentDetailsDAO projectPaymentDetailsDAO;
	
	@Override
	@Transactional
	public void saveMilestoneDetails(List<ProjectMilestonesDto> theProjectMilestonesDto) throws ParseException {
		projectPaymentDetailsDAO.savePaymentMilestones(theProjectMilestonesDto);
	}

	@Override
	@Transactional
	public List<PaymentMilestone> getMilestoneDetails(String projectCode) {
		
		return projectPaymentDetailsDAO.getPaymentMilestones(projectCode);
	}

}
