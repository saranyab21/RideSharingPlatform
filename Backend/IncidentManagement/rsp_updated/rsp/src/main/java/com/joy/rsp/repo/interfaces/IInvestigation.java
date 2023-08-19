package com.joy.rsp.repo.interfaces;


import com.joy.rsp.entity.DTOs.*;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvestigation {
    

	int updateIncident(String incidentId, InvestigationDTO investigationDTO);
}


