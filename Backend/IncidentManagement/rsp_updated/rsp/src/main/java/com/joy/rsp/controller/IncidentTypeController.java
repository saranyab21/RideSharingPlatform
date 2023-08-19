package com.joy.rsp.controller;


import com.joy.rsp.entity.IncidentTypes;
//import com.ridesharingplatform.microservices.incidentmanagement.models.dto.IncidentTypeDTO;
//import com.ridesharingplatform.microservices.incidentmanagement.repository.IIncidentTypeRepository;
import com.joy.rsp.entity.DTOs.*;
import com.joy.rsp.repo.*;
import com.joy.rsp.repo.interfaces.*;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/")
@CrossOrigin 
public class IncidentTypeController {
    private final IIncidentType incidentTypeRepository;

    @Autowired
    public IncidentTypeController(IIncidentType incidentTypeRepository) {
        this.incidentTypeRepository = incidentTypeRepository;
    }

    @GetMapping("incidents/types")
    public ResponseEntity<List<IncidentTypes>> getAllIncidentTypes() {
        List<IncidentTypes> incidentTypes = incidentTypeRepository.getIncidentTypes();
        return ResponseEntity.ok(incidentTypes);
    }

    @GetMapping("/incidents/types/{id}")
    public ResponseEntity<IncidentTypes> getTypeById(@PathVariable int id) {
        IncidentTypes incidentType = incidentTypeRepository.getIncidentTypesById(id);
        if (incidentType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(incidentType);
    }
}

/*@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class IncidentTypeController {
    private final IIncidentType incidentTypeRepository = null;

    @GetMapping("incidents/type")
    public ResponseEntity<List<IncidentTypeDTOs>> getType() {
        List<IncidentTypeDTOs> incidentTypeDTOs = incidentTypeRepository.getIncidentTypes().stream()
               .map(incidentType -> new IncidentTypeDTOs(
                       incidentType.getId(),
                        incidentType.getType(),
                        incidentType.getExpectedSLAInDays()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(incidentTypeDTOs);
    }

    @GetMapping("{id}")
    public ResponseEntity<IncidentTypes> getType(@PathVariable int id) {
        IncidentTypes incidentTypeDTO = incidentTypeRepository.getIncidentTypesById(id);
        if (incidentTypeDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(incidentTypeDTO);
    }
}*/


