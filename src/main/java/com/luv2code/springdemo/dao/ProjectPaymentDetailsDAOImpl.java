package com.luv2code.springdemo.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.dto.ProjectMilestonesDto;
import com.luv2code.springdemo.entity.PaymentMilestone;
import com.luv2code.springdemo.entity.PaymentMilestoneAttachment;

@Repository
public class ProjectPaymentDetailsDAOImpl implements ProjectPaymentDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * @Override public void savePaymentMilestones(List<ProjectDetailsDto>
	 * theProjectDetailsDto) throws ParseException { Session currentSession =
	 * sessionFactory.getCurrentSession(); try { for (ProjectDetailsDto
	 * tempProjectDetailsDto : theProjectDetailsDto) {
	 * 
	 * PaymentMilestone thePaymentMilestone = new PaymentMilestone();
	 * PaymentMilestoneAttachment thePaymentMilestoneAttachment = new
	 * PaymentMilestoneAttachment();
	 * 
	 * thePaymentMilestone.setMilestoneName(tempProjectDetailsDto.
	 * getMilestoneName());
	 * thePaymentMilestone.setProjectCode(tempProjectDetailsDto.getProjectCode()
	 * ); Date date =
	 * StringToDate(tempProjectDetailsDto.getActualCompletionDate());
	 * thePaymentMilestone.setActualCompletionDate(date); date =
	 * StringToDate(tempProjectDetailsDto.getCompletionDateAsPerSow());
	 * thePaymentMilestone.setCompletionDateAsPerSow(date);
	 * thePaymentMilestone.setBilled(tempProjectDetailsDto.isBilled());
	 * thePaymentMilestone.setMilestoneId(tempProjectDetailsDto.getMilestoneId()
	 * ); if (thePaymentMilestone.isBilled() == true) { // This is a new trial
	 * date = StringToDate(tempProjectDetailsDto.getCreatedAt());
	 * thePaymentMilestoneAttachment.setCreatedAt(date);
	 * thePaymentMilestoneAttachment.setFileName(tempProjectDetailsDto.
	 * getFileName());
	 * thePaymentMilestoneAttachment.setFileType(tempProjectDetailsDto.
	 * getFileType());
	 * thePaymentMilestoneAttachment.setFileContent(tempProjectDetailsDto.
	 * getFileContent());
	 * thePaymentMilestoneAttachment.setCreatedBy(tempProjectDetailsDto.
	 * getCreatedBy());
	 * 
	 * } else { thePaymentMilestone.setInvoice(null); }
	 * thePaymentMilestoneAttachment.setAttachmentId(tempProjectDetailsDto.
	 * getAttachmentId());
	 * thePaymentMilestone.setInvoice(thePaymentMilestoneAttachment);
	 * currentSession.saveOrUpdate(thePaymentMilestone); } } catch (Exception e)
	 * { e.printStackTrace(); currentSession.close(); sessionFactory.close();
	 * 
	 * } }
	 */

	public static Date StringToDate(String dob) throws ParseException {
		// Instantiating the SimpleDateFormat class
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		// Parsing the given String to Date object
		Date date = formatter.parse(dob);
		System.out.println("Date object value: " + date);
		return date;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PaymentMilestone> getPaymentMilestones(String projectCode) throws LazyInitializationException {
		Session currentSession = sessionFactory.getCurrentSession();

		try {
			String hql = "From PaymentMilestone E where E.projectCode = :project_code";
			Query<PaymentMilestone> query = currentSession.createQuery(hql);
			query.setParameter("project_code", projectCode);
			List<PaymentMilestone> thePaymentMilestones = query.getResultList();
			// for(PaymentMilestone currPaymentMilestones :
			// thePaymentMilestones){
			// System.out.println(currPaymentMilestones.getInvoice().toString());
			// }
			return thePaymentMilestones;
		} catch (Exception e) {
			List<PaymentMilestone> thePaymentMilestones = new ArrayList<>();
			e.printStackTrace();
			currentSession.close();
			return thePaymentMilestones;
		}

	}

	@Override
	public void savePaymentMilestones(List<ProjectMilestonesDto> theProjectMilestonesDto) throws ParseException {
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			for (ProjectMilestonesDto tempProjectMilestonesDto : theProjectMilestonesDto) {
				
				PaymentMilestone thePaymentMilestone = new PaymentMilestone();
				PaymentMilestoneAttachment thePaymentMilestoneAttachment = new PaymentMilestoneAttachment();
				
				thePaymentMilestone.setMilestoneName(tempProjectMilestonesDto.getMilestoneName());
				thePaymentMilestone.setProjectCode(tempProjectMilestonesDto.getProjectCode());
				thePaymentMilestone.setActualCompletionDate(tempProjectMilestonesDto.getActualCompletionDate());
//				date = StringToDate(tempProjectMilestonesDto.getCompletionDateAsPerSow());
				thePaymentMilestone.setCompletionDateAsPerSow(tempProjectMilestonesDto.getCompletionDateAsPerSow());
				thePaymentMilestone.setBilled(tempProjectMilestonesDto.isBilled());
				thePaymentMilestone.setMilestoneId(tempProjectMilestonesDto.getMilestoneId());
				if (thePaymentMilestone.isBilled() == true) {
					// This is a new trial
//					date = StringToDate(tempProjectMilestonesDto.getCreatedAt());
					thePaymentMilestone.setInvoice(tempProjectMilestonesDto.getInvoice());
				} else {
					thePaymentMilestone.setInvoice(null);
				}
				thePaymentMilestoneAttachment.setAttachmentId(tempProjectMilestonesDto.getMilestoneId());
				currentSession.saveOrUpdate(thePaymentMilestone);
			}
		} catch (Exception e) {
			e.printStackTrace();

			sessionFactory.close();

		}
	}

}
