package com.luv2code.springdemo.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springdemo.dao.ResDetailsDAO;
import com.luv2code.springdemo.dto.ResDetailsDto;
import com.luv2code.springdemo.dto.ResourceAllocationDto;
import com.luv2code.springdemo.dto.ResourceNameDto;
import com.luv2code.springdemo.helpers.ExcelHelper;

@Service
public class ResDetailsServiceImpl implements ResDetailsService {

	@Autowired
	private ResDetailsDAO resDetailsDAO;

	@Override
	@Transactional
	public List<ResDetailsDto> getAll() {
		return resDetailsDAO.getAll();
	}

	@Override
	@Transactional
	public ResDetailsDto getResourceDetails(String resourceId) {

		return resDetailsDAO.getResourceDetails(resourceId);
	}

	@Override
	@Transactional
	public void addResourceDetails(ResDetailsDto resDetailsDto) {

		resDetailsDAO.saveResourceDetails(resDetailsDto);

	}

	@Override
	@Transactional
	public void save(MultipartFile file) {

		try {
			List<ResDetailsDto> resDetailsDtoList = ExcelHelper.excelToResourceDetailsDto(file.getInputStream());
			resDetailsDAO.saveAll(resDetailsDtoList);
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public ByteArrayInputStream load() {

	    ByteArrayInputStream in = ExcelHelper.resDetailsToExcel();
	    return in;
	}
	
	@Override
	@Transactional
	public ByteArrayInputStream loadAllocation(List<ResourceAllocationDto> theDto, List<ResourceNameDto> theName) {

	    ByteArrayInputStream in = ExcelHelper.resAllocationToExcel(theDto, theName);
	    return in;
	}



	/*
	 * @Override
	 * 
	 * @Transactional public List<ResDetails> getResourcesByDepartment(String
	 * departmentId) {
	 * 
	 * return resDetailsDAO.getResourceDetailsbyDepartmentId(departmentId); }
	 */
	

}