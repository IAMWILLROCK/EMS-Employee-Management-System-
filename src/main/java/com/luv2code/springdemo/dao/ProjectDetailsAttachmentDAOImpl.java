package com.luv2code.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.luv2code.springdemo.entity.ProjectDetailsAttachment;


@Repository
public class ProjectDetailsAttachmentDAOImpl implements ProjectDetailsAttachmentDAO  {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveAttachment(ProjectDetailsAttachment projectDetailsAttachment) {
		
		Session currentSession = sessionFactory.getCurrentSession();		
		
		currentSession.saveOrUpdate(projectDetailsAttachment);
		
		
	}


}
