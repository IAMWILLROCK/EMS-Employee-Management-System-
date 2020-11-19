package com.luv2code.springdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.dto.ManagerDropdownDto;
import com.luv2code.springdemo.entity.Country;
import com.luv2code.springdemo.entity.Department;
import com.luv2code.springdemo.entity.Designation;
import com.luv2code.springdemo.entity.FunctionalDomain;
import com.luv2code.springdemo.entity.Grade;
import com.luv2code.springdemo.entity.Region;
import com.luv2code.springdemo.entity.ResDetails;
import com.luv2code.springdemo.entity.Skills;

@Repository
public class UtilityDAOImpl implements UtilityDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Region> getRegions() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.createQuery("select a from Region a", Region.class).getResultList();
	}
	
	@Override
	public List<Country> getCountries() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.createQuery("select a from Country a", Country.class).getResultList();
	}
	
	@Override
	public List<Country> getCountriesByRegion(String regionId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Country> query= currentSession.createQuery("select a from Country a "
				+ "where a.region.regionId=:Id", Country.class);
		query.setParameter("Id", regionId);
	   List<Country> country=query.getResultList();
	   return country;
	}

	@Override
	public void saveCountry(Country theCountry) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCountry);
		
	}

	@Override
	public List<Grade> getGrades() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.createQuery("select a from Grade a", Grade.class).getResultList();
	}

	@Override
	public List<Department> getDepartments() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.createQuery("select a from Department a", Department.class).getResultList();
	}

	@Override
	public List<Designation> getDesignations() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.createQuery("select a from Designation a", Designation.class).getResultList();
	}

	@Override
	public List<Skills> getSkills() {
		
        Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.createQuery("select a from Skills a", Skills.class).getResultList();

		
	}

	
	@Override
	public List<Skills> getPSkills()
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.createQuery("select a from Skills a where a.skillsPK.sType='Primary' ", Skills.class).getResultList();
	}
	
	@Override
	public List<Skills> getSSkills()
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.createQuery("select a from Skills a where a.skillsPK.sType='Secondary' ", Skills.class).getResultList();
	}

	@Override
	public List<FunctionalDomain> getFunctionalDomain() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.createQuery("select a from FunctionalDomain a", FunctionalDomain.class).getResultList();
	}
	
	@Override
	public List<ManagerDropdownDto> getProjectManagerName() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ResDetails> query = currentSession.createQuery("from ResDetails a " + "where a.designation= 'Project Manager' ",
				ResDetails.class);
		
		List<ResDetails> resDetails=query.getResultList();
	    List<ManagerDropdownDto> managerDropdownDto= new ArrayList<>();
	    
	    for(ResDetails tempResDetails:resDetails)
	    {
	    	ManagerDropdownDto theDto=new ManagerDropdownDto();
	    	theDto.setManagerId(tempResDetails.getResourceId());
	    	theDto.setManagerName(tempResDetails.getFirstName()+" "+tempResDetails.getLastName());
	    	managerDropdownDto.add(theDto);
	    }
	    return managerDropdownDto;
	}
	
	@Override
	public List<ManagerDropdownDto> getDeliveryManagerName() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ResDetails> query = currentSession.createQuery("from ResDetails a " + "where a.designation= 'Manager-Delivery' ",
				ResDetails.class);
		
		List<ResDetails> resDetails=query.getResultList();
	    List<ManagerDropdownDto> managerDropdownDto= new ArrayList<>();
	    
	    for(ResDetails tempResDetails:resDetails)
	    {
	    	ManagerDropdownDto theDto=new ManagerDropdownDto();
	    	theDto.setManagerId(tempResDetails.getResourceId());
	    	theDto.setManagerName(tempResDetails.getFirstName()+" "+tempResDetails.getLastName());
	    	managerDropdownDto.add(theDto);
	    }
	    return managerDropdownDto;
	}
}