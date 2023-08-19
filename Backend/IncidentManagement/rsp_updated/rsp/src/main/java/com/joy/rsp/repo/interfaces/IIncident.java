package com.joy.rsp.repo.interfaces;
import com.joy.rsp.entity.DTOs.*;
//import RideSharingPlatform.Microservices.IncidentManagement.Models.DTO.IncidentDTOs;
//import RideSharingPlatform.Microservices.IncidentManagement.Models.Incident;
import com.joy.rsp.entity.*;

import java.util.List;

public interface IIncident {

    String addIncident(IncidentDTOs incidentDTOs);
    List<Incident> getAllPendingIncidents();
    Incident getIncidentTypesById(String id);
}
