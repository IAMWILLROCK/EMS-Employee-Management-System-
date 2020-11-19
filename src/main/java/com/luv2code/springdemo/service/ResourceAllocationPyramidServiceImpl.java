package com.luv2code.springdemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.ResourceAllocationPyramidDAO;
import com.luv2code.springdemo.dto.ResDetailsDto;
import com.luv2code.springdemo.dto.ResourceAllocationDto;
import com.luv2code.springdemo.dto.ResourceAllocationPyramidDto;
import com.luv2code.springdemo.dto.ResourceNameDto;
import com.luv2code.springdemo.entity.AllocationPyramid;

@Service
public class ResourceAllocationPyramidServiceImpl implements ResourceAllocationPyramidService {

	@Autowired
	private ResourceAllocationService resourceAllocationService;
	
	@Autowired
	private ResDetailsService resDetailsService;
	
	@Autowired
	private UtilityService utilityService;
	
	@Autowired
	private ResourceAllocationPyramidDAO resourceAllocationPyramidDAO;
	
	@Override
	@Transactional
	public void calculatePyramid(String projectCode)
	{
		List<ResourceAllocationPyramidDto> resourceAllocationPyramidDtos= new ArrayList<>();
		List<ResourceAllocationDto> resAlloDtos= new ArrayList<>();
		List<ResDetailsDto> resDetailsDtos = new ArrayList<>();
		Map<String,Integer> gradeCountMap= new HashMap<>();
		resAlloDtos= resourceAllocationService.getByProjectCode(projectCode);
		int resourceCount=resAlloDtos.size();
		for(ResourceAllocationDto resAlloDto:resAlloDtos)
		{
			ResDetailsDto resDetailsDto=resDetailsService.getResourceDetails(resAlloDto.getResourceId());
			resDetailsDtos.add(resDetailsDto);
		}
		for(ResDetailsDto resDetailsDto:resDetailsDtos)
		{
			String k=resDetailsDto.getSubGradeId();
			if(gradeCountMap.containsKey(k))
			{
				gradeCountMap.put(k, gradeCountMap.get(k)+1);
			}
			else
				gradeCountMap.put(k, 1);
		}
		
		double actualWithRestGrade=0;
		ResourceAllocationPyramidDto resourceAllocationPyramidRestDto=new ResourceAllocationPyramidDto();
		for(Map.Entry<String,Integer> m:gradeCountMap.entrySet())
		{ResourceAllocationPyramidDto resourceAllocationPyramidDto=new ResourceAllocationPyramidDto();
		 AllocationPyramid allocationPyramid=utilityService.getPyramid(m.getKey());//check
		 double actual=0;
		 double variance=0;
		 String stringGrade=(m.getKey()).substring(1,(m.getKey()).length());
		 double gradeDouble=Double.parseDouble(stringGrade);
		 if(gradeDouble<=2.1)
		 {
			 resourceAllocationPyramidDto.setGrade(m.getKey());
			 resourceAllocationPyramidDto.setPyramid(allocationPyramid.getPyramidValue());
			 actual=m.getValue()*100/resourceCount;
			 variance=actual-allocationPyramid.getPyramidValue();
			 resourceAllocationPyramidDto.setActual(actual);
			 resourceAllocationPyramidDto.setVariance(variance);
			 resourceAllocationPyramidDto.setProjectCode(projectCode);
			 
			 resourceAllocationPyramidDtos.add(resourceAllocationPyramidDto);		 
		 
		}
		else
		{
			actualWithRestGrade=actualWithRestGrade+m.getValue();
			 resourceAllocationPyramidRestDto.setGrade("Rest (Sr.Mgmt)");
			 resourceAllocationPyramidRestDto.setPyramid(allocationPyramid.getPyramidValue());
			 actual=actualWithRestGrade*100/resourceCount;
			 variance=actual-allocationPyramid.getPyramidValue();
			 resourceAllocationPyramidRestDto.setActual(actual);
			 resourceAllocationPyramidRestDto.setVariance(variance);
			 resourceAllocationPyramidRestDto.setProjectCode(projectCode);
			 
			// resourceAllocationPyramidDtos.add(resourceAllocationPyramidDto);
			
		}
		
	}
		if(resourceAllocationPyramidRestDto!=null)
			resourceAllocationPyramidDtos.add(resourceAllocationPyramidRestDto);
		for(ResourceAllocationPyramidDto temp:resourceAllocationPyramidDtos)
		{
			resourceAllocationPyramidDAO.saveResourceAllocationPyramid(temp);
		}
		
	}
	
	@Override
	@Transactional
	public List<ResourceAllocationPyramidDto> getPyramid(String projectCode)
	{
		
		return resourceAllocationPyramidDAO.getResourceAllocationPyramid(projectCode);
		
	}
	
	@Override
	@Transactional
	public List<ResourceNameDto> getName(String projectCode)
	{
		List<ResourceAllocationDto> resAlloDtos= new ArrayList<>();
		resAlloDtos= resourceAllocationService.getByProjectCode(projectCode);
		List<ResourceNameDto> resNameDtos= new ArrayList<>();
		for(ResourceAllocationDto resAlloDto:resAlloDtos)
		{
			ResourceNameDto theDto=new ResourceNameDto();
			ResDetailsDto resDetailsDto=resDetailsService.getResourceDetails(resAlloDto.getResourceId());
			theDto.setName(resDetailsDto.getFirstName()+" "+resDetailsDto.getLastName());
			theDto.setResourceId(resDetailsDto.getResourceId());
			resNameDtos.add(theDto);
		}
		return resNameDtos;
	}
	
}