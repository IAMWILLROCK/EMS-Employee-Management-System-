package com.luv2code.springdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.composite.ResourceAllocationPyramidPK;
import com.luv2code.springdemo.dto.ResourceAllocationPyramidDto;
import com.luv2code.springdemo.entity.ResourceAllocationPyramid;

@Repository
public class ResourceAllocationPyramidDAOImpl implements ResourceAllocationPyramidDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveResourceAllocationPyramid(ResourceAllocationPyramidDto resAllocationPyramidDto)
	{
		Session currentSession=sessionFactory.getCurrentSession();
		ResourceAllocationPyramid temp;
		temp=importDto(resAllocationPyramidDto);
		
		currentSession.saveOrUpdate(temp);
	}
	
	@Override
   public List<ResourceAllocationPyramidDto> getResourceAllocationPyramid(String projectCode) 
   {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<ResourceAllocationPyramid> theQuery=
				currentSession.createQuery("from ResourceAllocationPyramid a "
						+ "where a.resourceAllocationPyramidPK.projectCode=:theProjectCode",ResourceAllocationPyramid.class);
		theQuery.setParameter("theProjectCode", projectCode);
		List<ResourceAllocationPyramid> resAllocationPyramid=theQuery.getResultList();
		List<ResourceAllocationPyramidDto> theDto=new ArrayList<>();
		for(ResourceAllocationPyramid temp:resAllocationPyramid)
		{
			theDto.add(exportDto(temp));
		}
		return theDto;
   
   }
   
   public ResourceAllocationPyramid importDto(ResourceAllocationPyramidDto resAllocationPyramidDto)
   {
	   ResourceAllocationPyramid resourceAllocationPyramid=new ResourceAllocationPyramid();
	   ResourceAllocationPyramidPK resourcePK=
			   new ResourceAllocationPyramidPK(resAllocationPyramidDto.getProjectCode(),
					   resAllocationPyramidDto.getGrade());
	   resourceAllocationPyramid.setResourceAllocationPyramidPK(resourcePK);
	   resourceAllocationPyramid.setActual(resAllocationPyramidDto.getActual());
	   resourceAllocationPyramid.setVariance(resAllocationPyramidDto.getVariance());
	   resourceAllocationPyramid.setPyramid(resAllocationPyramidDto.getPyramid());
	   
	   return resourceAllocationPyramid;
   }
   public ResourceAllocationPyramidDto exportDto(ResourceAllocationPyramid temp)
   {
	   ResourceAllocationPyramidDto theDto=new ResourceAllocationPyramidDto();
	   theDto.setGrade(temp.getResourceAllocationPyramidPK().getGrade());
	   theDto.setProjectCode(temp.getResourceAllocationPyramidPK().getProjectCode());
	   theDto.setActual(temp.getActual());
	   theDto.setPyramid(temp.getPyramid());
	   theDto.setVariance(temp.getVariance());
	   return theDto;
   }
}
