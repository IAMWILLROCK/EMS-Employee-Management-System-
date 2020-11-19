package com.luv2code.springdemo.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.composite.ResourceAllocationCompositeKey;
import com.luv2code.springdemo.dto.ResourceAllocationDto;
import com.luv2code.springdemo.entity.ResourceAllocation;

@Repository
public class ResourceAllocationDAOImpl implements ResourceAllocationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(ResourceAllocationDto resourceAllocationDto) throws ParseException {
		Session currentSession = sessionFactory.getCurrentSession();
		ResourceAllocation tempResourceAllocation;
		System.out.println(resourceAllocationDto.toString());
		tempResourceAllocation = importDto(resourceAllocationDto);
		// System.out.println(resourceAllocationDto.toString());
		System.out.println(tempResourceAllocation.toString());
		currentSession.saveOrUpdate(tempResourceAllocation);
	}

	@Override
	public List<ResourceAllocationDto> getByResourceId(String resourceId) {
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			Query<ResourceAllocation> query = currentSession.createQuery(
					"from ResourceAllocation E where E.resourceAllocationId.resourceId = :theresourceId", ResourceAllocation.class);
			query.setParameter("theresourceId", resourceId);
			List<ResourceAllocation> theList = new ArrayList<>();
			theList = query.getResultList();
			List<ResourceAllocationDto> allocationList = new ArrayList<>();
			for(ResourceAllocation tempAllocation : theList){
				allocationList.add(exportDto(tempAllocation));
			}
			System.out.println(theList.toString());
			return allocationList;
		} catch (Exception e) {
			e.printStackTrace();
			List<ResourceAllocationDto> theList = new ArrayList<>();
			return theList;			
		}

	}

	@Override
	public List<ResourceAllocationDto> getByProjectCode(String projectCode) {
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			Query<ResourceAllocation> query = currentSession.createQuery(
					"from ResourceAllocation E where E.resourceAllocationId.projectCode = :theprojectCode", ResourceAllocation.class);
			query.setParameter("theprojectCode", projectCode);
			List<ResourceAllocation> theList = new ArrayList<>();
			theList = query.getResultList();
			List<ResourceAllocationDto> allocationList = new ArrayList<>();
			for(ResourceAllocation tempAllocation : theList){
				allocationList.add(exportDto(tempAllocation));
			}
			System.out.println(theList.toString());
			return allocationList;
		} catch (Exception e) {
			e.printStackTrace();
			List<ResourceAllocationDto> theList = new ArrayList<>();
			return theList;			
		}

	}
	private ResourceAllocation importDto(ResourceAllocationDto theResourceAllocationDto) throws ParseException {
		ResourceAllocation theResourceAllocation = new ResourceAllocation();
		ResourceAllocationCompositeKey theKey = new ResourceAllocationCompositeKey(
				theResourceAllocationDto.getResourceId(), theResourceAllocationDto.getProjectCode());
		theResourceAllocation.setResourceAllocationId(theKey);
		theResourceAllocation.setProjectName(theResourceAllocationDto.getProjectName());

		theResourceAllocation.setStartDate((theResourceAllocationDto.getStartDate()));
		theResourceAllocation.setEndDate((theResourceAllocationDto.getEndDate()));
		theResourceAllocation.setBilledCapacity(theResourceAllocationDto.getBilledCapacity());
		theResourceAllocation.setUtilizationCapacity(theResourceAllocationDto.getUtilizationCapacity());
		return theResourceAllocation;
	}

	/*
	public static Date StringToDate(String dob) throws ParseException {
		// Instantiating the SimpleDateFormat class
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		// Parsing the given String to Date object
		Date date = formatter.parse(dob);
		System.out.println("Date object value: " + date);
		return date;
	}
	*/
	
	private ResourceAllocationDto exportDto(ResourceAllocation theResourceAllocation){
		ResourceAllocationDto theDto = new ResourceAllocationDto();
		theDto.setProjectCode(theResourceAllocation.getResourceAllocationId().getProjectCode());
		theDto.setProjectName(theResourceAllocation.getProjectName());
		theDto.setResourceId(theResourceAllocation.getResourceAllocationId().getResourceId());
		theDto.setStartDate(theResourceAllocation.getStartDate());
		theDto.setEndDate(theResourceAllocation.getEndDate());
		theDto.setUtilizationCapacity(theResourceAllocation.getUtilizationCapacity());
		theDto.setBilledCapacity(theResourceAllocation.getBilledCapacity());
		System.out.println(">>>>>>>>>exportDto: " + theDto.getStartDate());
		System.out.println(">>>>>>>>>exportDto: " + theDto.getEndDate());
		return theDto;
	}
}

