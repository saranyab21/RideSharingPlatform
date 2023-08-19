package com.joy.rsp.repo.interfaces;

import com.joy.rsp.entity.*;
import com.joy.rsp.entity.DTOs.IncidentTypeDTOs;

//import RideSharingPlatform.Microservices.IncidentManagement.Models.IncidentTypes;
import java.util.List;

public interface IIncidentType {
List<IncidentTypes> getIncidentTypes();
IncidentTypes getIncidentTypesById(int id);
}