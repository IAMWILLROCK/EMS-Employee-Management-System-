package com.luv2code.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.AllocationPyramid;

@Repository
public class AllocationPyramidDAOImpl implements AllocationPyramidDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public AllocationPyramid getPyramid(String grade)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		AllocationPyramid allocationPyramid=currentSession.get(AllocationPyramid.class, 
				                                                     grade);
		return allocationPyramid;
	}

}
