package edu.ait.repserver.rest.dto;

import java.util.List;

import edu.ait.repserver.usecase.entity.Property;

public class PropertyPageDTO {
	
	private List<Property> properties;
	private int totalNumberOfPages;
	
	public PropertyPageDTO() {
		super();
	}
	
	public PropertyPageDTO(int totalNumberOfPages, List<Property> properties) {
		super();
		this.totalNumberOfPages = totalNumberOfPages;
		this.properties = properties;
	}
	
	public List<Property> getProperties() {
		return properties;
	}
	
	public int getTotalNumberOfPages() {
		return totalNumberOfPages;
	}
	
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	public void setTotalNumberOfPages(int totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}
}
