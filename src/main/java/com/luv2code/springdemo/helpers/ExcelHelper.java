package com.luv2code.springdemo.helpers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springdemo.dto.ResDetailsDto;
import com.luv2code.springdemo.dto.ResourceAllocationDto;
import com.luv2code.springdemo.dto.ResourceNameDto;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Resource_Id", "First_Name", "Last_Name", "Email", "Mobile", "Department", "Grade",
			"Primary_Skill", "Secondary_Skill", "Designation" };
	static String SHEET = "ResourceDetails";
	static String[] ALLOCATIONHEADERs={"Resource Id","Name","Start Date","End Date","Utilization Capacity",
			                            "Billed Capacity"};
	

	public static boolean hasExcelFormat(MultipartFile file) {
		System.out.println("ExcelHelper: hasExcelFormat");
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	// *************************************************************************
	public static ByteArrayInputStream resDetailsToExcel() {
		System.out.println("ExcelHelper: tutorialsToExcel");
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);
			int width=12;
			 CellStyle style = workbook.createCellStyle();//Create style
			    Font font = workbook.createFont();//Create font
			    font.setBold(true);//Make font bold
			    style.setFont(font);//set it to bol
			

			// Header
			Row headerRow = sheet.createRow(0);
			sheet.setDefaultColumnWidth(width);
			sheet.setColumnWidth(5, 29*256);
			sheet.setColumnWidth(6, 9*256);
			sheet.setColumnWidth(7, 20*256);
			sheet.setColumnWidth(8, 20*256);
			sheet.setColumnWidth(9, 29*256);

			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
				headerRow.getCell(col).setCellStyle(style);
			}

			String [] designations = new String[]{"Consultant-Technology", "Associate Consultant-Technology", "Senior Consultant-Technology", "Lead-Functional", "Senior Analyst-Quality Assurance", "Manager-Delivery","Project Manager"};
			String [] grades = new String[] {"G1.1","G1.2","G1.3","G2.1","G2.2","G2.3","G3.1","G3.2","G3.3" };
			String [] primarySkills = new String[] {"Android", "SAP PI/PO", "UI-UX Designer", "SAP UI5", "SAP ABAP", "Java", "Testing", "Project Management"};
			String [] secondarySkills = new String [] {"SAP PI", "UX Designer", "SAP UI5", "Android", "ABAP OO", "Java", "SAP ABAP","Webdynpro","Project Management"};
			String [] departments = new String [] {"IT", "Sales", "Marketing", "Human Resource Management","Production", "Accounts & Finance", "R&D", "Purchasing"};
			
			XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper((XSSFSheet) sheet);
			XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper.createExplicitListConstraint(departments);
			CellRangeAddressList addressList = new CellRangeAddressList(1, 50, 5, 5);
			XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);
			validation.setSuppressDropDownArrow(true);
			validation.setShowErrorBox(true);
			sheet.addValidationData(validation);
			
			
			dvConstraint = (XSSFDataValidationConstraint) dvHelper.createExplicitListConstraint(grades);
			addressList = new CellRangeAddressList(1, 50, 6, 6);
			validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);
			validation.setSuppressDropDownArrow(true);
			validation.setShowErrorBox(true);
			sheet.addValidationData(validation);
			
			
			
			dvConstraint = (XSSFDataValidationConstraint) dvHelper.createExplicitListConstraint(primarySkills);
			addressList = new CellRangeAddressList(1, 50, 7, 7);
			validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);
			validation.setSuppressDropDownArrow(true);
			validation.setShowErrorBox(true);
			sheet.addValidationData(validation);
			
			
			
			
			dvConstraint = (XSSFDataValidationConstraint) dvHelper.createExplicitListConstraint(secondarySkills);
			addressList = new CellRangeAddressList(1, 50, 8, 8);
			validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);
			validation.setSuppressDropDownArrow(true);
			validation.setShowErrorBox(true);
			sheet.addValidationData(validation);
			
			
			
			dvConstraint = (XSSFDataValidationConstraint) dvHelper.createExplicitListConstraint(designations);
			addressList = new CellRangeAddressList(1, 50, 9, 9);
			validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);
			validation.setSuppressDropDownArrow(true);
			validation.setShowErrorBox(true);
			sheet.addValidationData(validation);
			
			
				
			
			
			workbook.write(out);	
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	// ****************************************************

	public static List<ResDetailsDto> excelToResourceDetailsDto(InputStream is) {
		try {
			System.out.println("Excel to Resource Details Dto");
			Workbook workbook = new XSSFWorkbook(is);
			Sheet sheet = workbook.getSheet(SHEET);
			List<ResDetailsDto> resDetailsDtoList = new ArrayList<ResDetailsDto>();

			// This is my new edit
			int rowCount = sheet.getPhysicalNumberOfRows();
//			Row row0 = sheet.getRow(0);
//			int cellcount = row0.getPhysicalNumberOfCells();

			for (int r = 1; r < rowCount; r++) {

				ResDetailsDto dto = new ResDetailsDto();
				Row currentRow = sheet.getRow(r);

				Iterator<Cell> cellsInRow = currentRow.iterator();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						dto.setResourceId(currentCell.getStringCellValue());

						break;

					case 1:
						dto.setFirstName(currentCell.getStringCellValue());

						break;

					case 2:
						dto.setLastName(currentCell.getStringCellValue());

						break;
					case 3:
						dto.setEmail(currentCell.getStringCellValue());

						break;
					case 4:
						Integer num = (int) currentCell.getNumericCellValue();
						dto.setMobile(num.toString());
						break;
					case 5:
						dto.setDepartmentId(currentCell.getStringCellValue());

						break;
					case 6:
						dto.setSubGradeId(currentCell.getStringCellValue());

						break;
					case 7:
						dto.setpSkills(currentCell.getStringCellValue());

						break;
					case 8:
						dto.setsSkills(currentCell.getStringCellValue());

						break;
					case 9:
						dto.setDesignationId(currentCell.getStringCellValue());

						break;

					default:
						break;
					}
					cellIdx++;
				}
				resDetailsDtoList.add(dto);
			}

			workbook.close();
			System.out.println("\n" + resDetailsDtoList);
			return resDetailsDtoList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	//*******************************************************************************
	
	public static ByteArrayInputStream resAllocationToExcel(List<ResourceAllocationDto> theDto, List<ResourceNameDto> theName) {
		
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);
			CreationHelper createHelper = workbook.getCreationHelper();
			Row headerRow = sheet.createRow(0);
			sheet.setDefaultColumnWidth(20);
			int r=1;
			 CellStyle style = workbook.createCellStyle();//Create style
			    Font font = workbook.createFont();//Create font
			    font.setBold(true);//Make font bold
			    style.setFont(font);//set it to bol
			
			
			    CellStyle cellStyle = workbook.createCellStyle();


			    cellStyle.setDataFormat(
			    		createHelper.createDataFormat().getFormat("yyyy-mm-dd"));


			    


			    
			for (int col = 0; col < ALLOCATIONHEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(ALLOCATIONHEADERs[col]);
				headerRow.getCell(col).setCellStyle(style);
			}
			
			for(ResourceAllocationDto temp: theDto)
			{
				String name= new String();
				Row row=sheet.createRow(r);
				
				for(ResourceNameDto dtos:theName)
				{
					if(dtos.getResourceId().equals(temp.getResourceId()))
					{
						name=dtos.getName();
						break;
					}
				}
				
		       for(int col=0; col < ALLOCATIONHEADERs.length; col++)
		       {    Cell c=row.createCell(col);
		    	   switch(col){
		    	   
		    	   case 0:  c.setCellValue(temp.getResourceId());
		    	   			break;
		    	   case 1: c.setCellValue(name);
		    	   			break;
		    	   case 2: c.setCellValue(temp.getStartDate());
		    	           c.setCellStyle(cellStyle);
		    	   			break;
		    	   case 3: c.setCellValue(temp.getEndDate());
		    	   		  c.setCellStyle(cellStyle);			
		    	   		  break;
		    	   case 4: c.setCellValue(temp.getUtilizationCapacity());	
		    	   			break;
		    	   			
		    	   case 5: c.setCellValue(temp.getBilledCapacity());
		    	   			break;
		    	   	default:break;
		    	   	
		    	   
		    	   }
		    	   
			   }
			
			r++;
		}
			workbook.write(out);	
			return new ByteArrayInputStream(out.toByteArray());
	}catch (IOException e) {
		throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	}
  }
}
