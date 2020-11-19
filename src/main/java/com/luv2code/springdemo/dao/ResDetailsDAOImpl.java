package com.luv2code.springdemo.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.composite.SkillsPK;
import com.luv2code.springdemo.dto.ResDetailsDto;
import com.luv2code.springdemo.entity.ResDetails;
import com.luv2code.springdemo.entity.Skills;

@Repository
public class ResDetailsDAOImpl implements ResDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ResDetailsDto ExportDto(ResDetails resDetails)
	{
		ResDetailsDto resDetailsDto= new ResDetailsDto();
		resDetailsDto.setSubGradeId(resDetails.getSubGrade());
		resDetailsDto.setDepartmentId(resDetails.getDepartment());
		resDetailsDto.setDepartmentId(resDetails.getDepartment());
		resDetailsDto.setDesignationId(resDetails.getDesignation());
		resDetailsDto.setResourceId(resDetails.getResourceId());
		resDetailsDto.setFirstName(resDetails.getFirstName());
		resDetailsDto.setLastName(resDetails.getLastName());
		resDetailsDto.setEmail(resDetails.getEmail());
		resDetailsDto.setMobile(resDetails.getMobile());
		for(Skills tempSkills:resDetails.getSkills())
		{ 	SkillsPK skillsPK=tempSkills.getSkillsPK();
		
			if(skillsPK.getsType().equals("Primary"))
				resDetailsDto.setpSkills(skillsPK.getsId());
				
			if(skillsPK.getsType().equals("Secondary"))
				resDetailsDto.setsSkills(skillsPK.getsId());
		}
		return resDetailsDto;
		
		
	}

	@Override
	public List<ResDetailsDto> getAll() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<ResDetails> theQuery = currentSession.createQuery("from ResDetails order by resourceId", ResDetails.class);
	    List<ResDetails> resDetails=theQuery.getResultList();
	    List<ResDetailsDto> resDetailsDto= new ArrayList<>();
	    for(ResDetails tempResDetails:resDetails)
	    {
	    	resDetailsDto.add(ExportDto(tempResDetails));
	    }
	    return resDetailsDto;
	}

	@Override
	public ResDetailsDto getResourceDetails(String resourceId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<ResDetails> query = currentSession.createQuery("from ResDetails a " + "where a.resourceId= :id ",
				ResDetails.class);

		query.setParameter("id", resourceId);
		ResDetails resDetails =query.getSingleResult();
		ResDetailsDto resDetailsDto= ExportDto(resDetails);

		return resDetailsDto;
	}

	@Override
	public void saveResourceDetails(ResDetailsDto resDetailsDto) {

		Session currentSession = sessionFactory.getCurrentSession();

		ResDetails theResDetails = new ResDetails();
		Skills pSkills = currentSession.get(Skills.class, new SkillsPK(resDetailsDto.getpSkills(), "Primary"));
		Skills sSkills = currentSession.get(Skills.class, new SkillsPK(resDetailsDto.getsSkills(), "Secondary"));
		theResDetails.setSubGrade(resDetailsDto.getSubGradeId());
		theResDetails.setDepartment(resDetailsDto.getDepartmentId());
		theResDetails.setDesignation(resDetailsDto.getDesignationId());
		theResDetails.setResourceId(resDetailsDto.getResourceId());
		theResDetails.setFirstName(resDetailsDto.getFirstName());
		theResDetails.setLastName(resDetailsDto.getLastName());
		theResDetails.setEmail(resDetailsDto.getEmail());
		theResDetails.setMobile(resDetailsDto.getMobile());
		/*
		 * Department tempDepartment = currentSession.get(Department.class,
		 * resDetailsDto.getDepartmentId());
		 * tempDepartment.addResource(theResDetails);
		 */

		theResDetails.addSkills(pSkills);
		theResDetails.addSkills(sSkills);

		currentSession.saveOrUpdate(theResDetails);

	}

	public ResDetails importDto(ResDetailsDto resDetailsDto) {

		// Create a session Factory object
		Session currentSession = sessionFactory.getCurrentSession();

		// Declare a ResDetails object

		// Copy things from the Dto to the ResDetails object
		ResDetails theResDetails = new ResDetails();
		Skills pSkills = currentSession.get(Skills.class, new SkillsPK(resDetailsDto.getpSkills(), "Primary"));
		Skills sSkills = currentSession.get(Skills.class, new SkillsPK(resDetailsDto.getsSkills(), "Secondary"));
		theResDetails.setSubGrade(resDetailsDto.getSubGradeId());
		theResDetails.setDepartment(resDetailsDto.getDepartmentId());
		theResDetails.setDesignation(resDetailsDto.getDesignationId());
		theResDetails.setResourceId(resDetailsDto.getResourceId());
		theResDetails.setFirstName(resDetailsDto.getFirstName());
		theResDetails.setLastName(resDetailsDto.getLastName());
		theResDetails.setEmail(resDetailsDto.getEmail());
		theResDetails.setMobile(resDetailsDto.getMobile());
		theResDetails.addSkills(pSkills);
		theResDetails.addSkills(sSkills);

		// Return that back

		return theResDetails;
	}

	@Override
	public void saveAll(List<ResDetailsDto> resDetailsDtoList) {
		Session session = sessionFactory.getCurrentSession();
		
		for(ResDetailsDto currentDto : resDetailsDtoList){
			ResDetails tempResDetails = importDto(currentDto);
			session.saveOrUpdate(tempResDetails);
		}
	}

	
//	public ResDetailsDto exportDto(ResDetails theResDetails){
//		
//		return null;
//	}
	
	/*
	 * @Override public List<ResDetails> getResourceDetailsbyDepartmentId(String
	 * departmentId) {
	 * 
	 * // Get the Department Session currentSession =
	 * sessionFactory.getCurrentSession(); Department tempDepartment =
	 * currentSession.get(Department.class, departmentId);
	 * 
	 * System.out.println(tempDepartment.getResources()); return
	 * tempDepartment.getResources(); }
	 */
}