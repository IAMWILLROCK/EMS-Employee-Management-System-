package com.luv2code.springdemo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.dto.ProjectDetailsDto;
import com.luv2code.springdemo.dto.ProjectNameDto;
import com.luv2code.springdemo.entity.ProjectDetails;

@Repository
public class ProjectDetailsDAOImpl implements ProjectDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ProjectDetailsAttachmentDAO projectDetailsAttachmentDAO;

	public ProjectDetailsDto ExportDto(ProjectDetails theProjectDetails) {

		int status;
		ProjectDetailsDto theProjectDetailsDto = new ProjectDetailsDto();
		theProjectDetailsDto.setProjectCode(theProjectDetails.getProjectCode());
		theProjectDetailsDto.setProjectName(theProjectDetails.getProjectName());
		theProjectDetailsDto.setRegion(theProjectDetails.getRegion());
		theProjectDetailsDto.setCountry(theProjectDetails.getCountry());
		theProjectDetailsDto.setProjectDescription(theProjectDetails.getProjectDescription());
		theProjectDetailsDto.setProjectDomain(theProjectDetails.getProjectDomain());
		theProjectDetailsDto.setResourcePlanned(theProjectDetails.getResourcePlanned());
		theProjectDetailsDto.setProjectedMargin(theProjectDetails.getProjectedMargin());
		theProjectDetailsDto.setProjectManagerName(theProjectDetails.getProjectManagerName());
		theProjectDetailsDto.setDeliveryManagerName(theProjectDetails.getDeliveryManagerName());
		theProjectDetailsDto.setDealValue(theProjectDetails.getDealValue());
		theProjectDetailsDto.setActualValue(theProjectDetails.getActualValue());
		theProjectDetailsDto.setBudgetedValue(theProjectDetails.getBudgetedValue());
		theProjectDetailsDto.setIsProposalSignedOff(theProjectDetails.isProposalSignedOff());
		theProjectDetailsDto.setIsSalesToDeliveryHandover(theProjectDetails.isSalesToDeliveryHandover());
		theProjectDetailsDto.setIsMsaSignedOff(theProjectDetails.isMsaSignedOff());
		theProjectDetailsDto.setIsPoSignedOff(theProjectDetails.isPoSignedOff());
		theProjectDetailsDto.setIsNdaSignedOff(theProjectDetails.isNdaSignedOff());
		theProjectDetailsDto.setProjectStartDate(theProjectDetails.getProjectStartDate());
		theProjectDetailsDto.setProjectEndDate(theProjectDetails.getProjectEndDate());

		if (theProjectDetails.getSowProposalAttachment() != null)
			theProjectDetailsDto.setSowProposalAttachment(theProjectDetails.getSowProposalAttachment());
		else
			theProjectDetailsDto.setSowProposalAttachment(null);
		if (theProjectDetails.getSalesToDeliveryHandoverAttachment() != null)
			theProjectDetailsDto
					.setSalesToDeliveryHandoverAttachment(theProjectDetails.getSalesToDeliveryHandoverAttachment());
		else
			theProjectDetailsDto.setSalesToDeliveryHandoverAttachment(null);
		if (theProjectDetails.getMsaSignedOffAttachment() != null)
			theProjectDetailsDto.setMsaSignedOffAttachment(theProjectDetails.getMsaSignedOffAttachment());
		else
			theProjectDetailsDto.setMsaSignedOffAttachment(null);
		if (theProjectDetails.getPoSignedOffAttachment() != null)
			theProjectDetailsDto.setPoSignedOffAttachment(theProjectDetails.getPoSignedOffAttachment());
		else
			theProjectDetailsDto.setPoSignedOffAttachment(null);
		if (theProjectDetails.getNdaSignedOffAttachment() != null)
			theProjectDetailsDto.setNdaSignedOffAttachment(theProjectDetails.getNdaSignedOffAttachment());
		else
			theProjectDetailsDto.setNdaSignedOffAttachment(null);

		Date currentdate = new Date();

		if (currentdate.getTime() - theProjectDetails.getProjectStartDate().getTime() < 0) // currentdate
																							// is
																							// before
																							// d1(startdate)
			status = 0;
		else if (currentdate.getTime() - theProjectDetails.getProjectEndDate().getTime() > 0)// currentdate
																								// is
																								// after
																								// d2
																								// enddate
			status = 100;
		else {
			long diff = theProjectDetails.getProjectEndDate().getTime()
					- theProjectDetails.getProjectStartDate().getTime();
			double projduration = diff / (1000 * 60 * 60 * 24);
			diff = currentdate.getTime() - theProjectDetails.getProjectStartDate().getTime();
			double currenttime = diff / (1000 * 60 * 60 * 24);
			status = (int) ((currenttime / projduration) * 100);
		}
		theProjectDetailsDto.setStatus(status);

		return theProjectDetailsDto;

	}

	@Override
	public List<ProjectDetailsDto> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ProjectDetails> theQuery = currentSession.createQuery("from ProjectDetails a", ProjectDetails.class);

		// execute query and get result list
		List<ProjectDetails> projectDetails = theQuery.getResultList();
		List<ProjectDetailsDto> projectDetailsDto = new ArrayList<>();
		for (int counter = 0; counter < projectDetails.size(); counter++) {
			projectDetailsDto.add(ExportDto(projectDetails.get(counter)));
		}

		return projectDetailsDto;

	}

	@Override
	public List<ProjectDetailsDto> getUpcoming() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ProjectDetails> theQuery = currentSession.createQuery("from ProjectDetails a", ProjectDetails.class);

		// execute query and get result list
		List<ProjectDetails> projectDetails = theQuery.getResultList();
		List<ProjectDetailsDto> projectDetailsDto = new ArrayList<>();
		for (int counter = 0; counter < projectDetails.size(); counter++) {
			if (ExportDto(projectDetails.get(counter)).getStatus() == 0)
				projectDetailsDto.add(ExportDto(projectDetails.get(counter)));
		}

		return projectDetailsDto;

	}

	@Override
	public List<ProjectDetailsDto> getOngoing() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ProjectDetails> theQuery = currentSession.createQuery("from ProjectDetails a", ProjectDetails.class);

		// execute query and get result list
		List<ProjectDetails> projectDetails = theQuery.getResultList();
		List<ProjectDetailsDto> projectDetailsOutputDto = new ArrayList<>();
		for (int counter = 0; counter < projectDetails.size(); counter++) {
			if (ExportDto(projectDetails.get(counter)).getStatus() != 0
					&& ExportDto(projectDetails.get(counter)).getStatus() != 100)
				projectDetailsOutputDto.add(ExportDto(projectDetails.get(counter)));
		}

		return projectDetailsOutputDto;

	}

	@Override
	public List<ProjectDetailsDto> getCompleted() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ProjectDetails> theQuery = currentSession.createQuery("from ProjectDetails a", ProjectDetails.class);

		// execute query and get result list
		List<ProjectDetails> projectDetails = theQuery.getResultList();
		List<ProjectDetailsDto> projectDetailsDto = new ArrayList<>();
		for (int counter = 0; counter < projectDetails.size(); counter++) {
			if (ExportDto(projectDetails.get(counter)).getStatus() == 100)
				projectDetailsDto.add(ExportDto(projectDetails.get(counter)));
		}

		return projectDetailsDto;

	}

	@Override
	public ProjectDetailsDto getProjectDetails(String projectCode) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<ProjectDetails> query = currentSession.createQuery("from ProjectDetails a " + "where a.projectCode= :id ",
				ProjectDetails.class);

		query.setParameter("id", projectCode);

		ProjectDetails projectDetails = query.getSingleResult();
		ProjectDetailsDto projectDetailsDto = ExportDto(projectDetails);

		return projectDetailsDto;
	}

	@Override
	public void saveProjectDetails(ProjectDetailsDto projectDetailsDto) {

		Session currentSession = sessionFactory.getCurrentSession();
		int status;

		ProjectDetails projectDetails = new ProjectDetails();

		projectDetails.setProjectCode(projectDetailsDto.getProjectCode());
		projectDetails.setProjectName(projectDetailsDto.getProjectName());
		projectDetails.setRegion(projectDetailsDto.getRegion());
		projectDetails.setCountry(projectDetailsDto.getCountry());
		projectDetails.setProjectDescription(projectDetailsDto.getProjectDescription());
		projectDetails.setProjectDomain(projectDetailsDto.getProjectDomain());
		projectDetails.setResourcePlanned(projectDetailsDto.getResourcePlanned());
		projectDetails.setProjectedMargin(projectDetailsDto.getProjectedMargin());
		projectDetails.setProjectManagerName(projectDetailsDto.getProjectManagerName());
		projectDetails.setDeliveryManagerName(projectDetailsDto.getDeliveryManagerName());
		projectDetails.setDealValue(projectDetailsDto.getDealValue());
		projectDetails.setActualValue(projectDetailsDto.getActualValue());
		projectDetails.setBudgetedValue(projectDetailsDto.getBudgetedValue());
		projectDetails.setIsProposalSignedOff(projectDetailsDto.isProposalSignedOff());
		projectDetails.setIsSalesToDeliveryHandover(projectDetailsDto.isSalesToDeliveryHandover());
		projectDetails.setIsMsaSignedOff(projectDetailsDto.isMsaSignedOff());
		projectDetails.setIsPoSignedOff(projectDetailsDto.isPoSignedOff());
		projectDetails.setIsNdaSignedOff(projectDetailsDto.isNdaSignedOff());

		if (projectDetailsDto.getSowProposalAttachment() != null) {
			projectDetailsAttachmentDAO.saveAttachment(projectDetailsDto.getSowProposalAttachment());
			projectDetails.setSowProposalAttachment(projectDetailsDto.getSowProposalAttachment());

		} else
			projectDetails.setSowProposalAttachment(null);

		if (projectDetailsDto.getSalesToDeliveryHandoverAttachment() != null) {
			projectDetailsAttachmentDAO.saveAttachment(projectDetailsDto.getSalesToDeliveryHandoverAttachment());
			projectDetails
					.setSalesToDeliveryHandoverAttachment(projectDetailsDto.getSalesToDeliveryHandoverAttachment());
		} else
			projectDetails.setSalesToDeliveryHandoverAttachment(null);

		if (projectDetailsDto.getMsaSignedOffAttachment() != null) {
			projectDetailsAttachmentDAO.saveAttachment(projectDetailsDto.getMsaSignedOffAttachment());
			projectDetails.setMsaSignedOffAttachment(projectDetailsDto.getMsaSignedOffAttachment());
		} else
			projectDetails.setMsaSignedOffAttachment(null);
		if (projectDetailsDto.getPoSignedOffAttachment() != null) {
			projectDetailsAttachmentDAO.saveAttachment(projectDetailsDto.getPoSignedOffAttachment());
			projectDetails.setPoSignedOffAttachment(projectDetailsDto.getPoSignedOffAttachment());
		} else
			projectDetails.setPoSignedOffAttachment(null);
		if (projectDetailsDto.getNdaSignedOffAttachment() != null) {
			projectDetailsAttachmentDAO.saveAttachment(projectDetailsDto.getNdaSignedOffAttachment());
			projectDetails.setNdaSignedOffAttachment(projectDetailsDto.getNdaSignedOffAttachment());
		} else
			projectDetails.setNdaSignedOffAttachment(null);

		Date currentdate = new Date();
		projectDetails.setProjectStartDate(projectDetailsDto.getProjectStartDate());
		projectDetails.setProjectEndDate(projectDetailsDto.getProjectEndDate());

		if (currentdate.getTime() - projectDetailsDto.getProjectStartDate().getTime() < 0) // currentdate
																							// is
																							// before
																							// d1(startdate)
			status = 0;
		else if (currentdate.getTime() - projectDetailsDto.getProjectEndDate().getTime() > 0)// currentdate
																								// is
																								// after
																								// d2
																								// enddate
			status = 100;
		else {
			long diff = projectDetailsDto.getProjectEndDate().getTime()
					- projectDetailsDto.getProjectStartDate().getTime();
			double projduration = diff / (1000 * 60 * 60 * 24);
			diff = currentdate.getTime() - projectDetailsDto.getProjectStartDate().getTime();
			double currenttime = diff / (1000 * 60 * 60 * 24);
			status = (int) ((currenttime / projduration) * 100);
		}

		projectDetails.setStatus(status);

		currentSession.saveOrUpdate(projectDetails);

	}
	
	@Override
	public List<ProjectNameDto> getProjectName()
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ProjectDetails> theQuery = currentSession.createQuery("from ProjectDetails a",
				                                     ProjectDetails.class);
		List<ProjectDetails> project=theQuery.getResultList();
		List<ProjectNameDto> projectNameDto= new ArrayList<>();
		
		for(ProjectDetails temp:project)
		{
			ProjectNameDto theDto=new ProjectNameDto();
			
			theDto.setProjectCode(temp.getProjectCode());
			theDto.setProjectName(temp.getProjectName());
			
			projectNameDto.add(theDto);
		}
		
		return projectNameDto;
		
	}

}
