package com.luv2code.springdemo.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.luv2code.springdemo.composite.ResourceAllocationCompositeKey;

@Entity
@Table(name = "RESOURCE_ALLOCATION")
public class ResourceAllocation {

	@EmbeddedId
	private ResourceAllocationCompositeKey resourceAllocationId;
	
	@Column(name = "PROJECT_NAME")
	private String projectName;
	
	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "END_DATE")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Column(name = "UTILIZATION_CAPACITY")
	private double utilizationCapacity;
	
	@Column(name = "BILLED_CAPACITY")
	private  double billedCapacity;
	
	public ResourceAllocation(){
		
	}

	public ResourceAllocationCompositeKey getResourceAllocationId() {
		return resourceAllocationId;
	}

	public void setResourceAllocationId(ResourceAllocationCompositeKey resourceAllocationId) {
		this.resourceAllocationId = resourceAllocationId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getUtilizationCapacity() {
		return utilizationCapacity;
	}

	public void setUtilizationCapacity(double utilizationCapacity) {
		this.utilizationCapacity = utilizationCapacity;
	}

	public double getBilledCapacity() {
		return billedCapacity;
	}

	public void setBilledCapacity(double billedCapacity) {
		this.billedCapacity = billedCapacity;
	}

	@Override
	public String toString() {
		return "ResourceAllocation [resourceAllocationId=" + resourceAllocationId + ", projectName=" + projectName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", utilizationCapacity=" + utilizationCapacity
				+ ", billedCapacity=" + billedCapacity + "]";
	}

	

}
/*
class CustomJsonDateDeserializer extends JsonDeserializer<Date>
{
    @Override
    public Date deserialize(JsonParser jsonParser,
            DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = jsonParser.getText();
        try {
        	Date actualDate = format.parse(date);
        	System.out.println("Date of the date object: " + actualDate);
            return actualDate;
        } catch (ParseException | java.text.ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
*/

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


