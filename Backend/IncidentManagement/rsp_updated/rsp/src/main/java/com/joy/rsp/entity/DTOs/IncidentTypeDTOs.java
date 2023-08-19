package com.joy.rsp.entity.DTOs;

import com.joy.rsp.entity.IncidentTypes;


public class IncidentTypeDTOs {
    private int id;
    private String types;
    private int expectedSLAInDays;

   // public IncidentTypeDTOs(Long id2, String type, Integer expectedSLAInDays2) {
		// TODO Auto-generated constructor stub
	//}

	

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public int getExpectedSLAInDays() {
        return expectedSLAInDays;
    }

    public void setExpectedSLAInDays(int expectedSLAInDays) {
        this.expectedSLAInDays = expectedSLAInDays;
    }
}
