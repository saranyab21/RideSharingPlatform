package com.joy.rsp.service;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joy.rsp.service.exceptions.CannotReportIncidentException;
import com.joy.rsp.repo.*;
import com.joy.rsp.entity.*;
import com.joy.rsp.entity.DTOs.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Random;
import java.util.List;

@Service
@Transactional
public class IncidentService {
    private final ModelMapper _mapper;
    private final IncidentRepository incidentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public IncidentService(ModelMapper mapper, IncidentRepository incidentRepository) {
        _mapper = mapper;
        this.incidentRepository = incidentRepository;
    }

    public boolean addIncident(IncidentDTOs incidentDTO) throws CannotReportIncidentException {
        Incident incident = _mapper.map(incidentDTO, Incident.class);
       // Incident incidentTypes = _mapper.map(incidentDTO, Incident.class);
       
        String unique = getUniqueIncidentId();
        incident.setIncidentID(incidentDTO.getIncidentDate().getYear() + "-" + unique);
        incident.setIncidentType(incidentRepository.getIncidentType(incident.getIncidentTypeId()));

        incident.setResolutionETA(incident.getReportDate().plusDays(incident.getIncidentType().getExpectedSLAInDays()));
        if (java.time.LocalDate.now().isAfter(incident.getIncidentDate().plusDays(2))) {
            throw new CannotReportIncidentException("Incident cannot be registered");
        }

        entityManager.persist(incident);
        return true;
    }

    public List<Incident> getAllPendingIncidents() {
        return incidentRepository.getAllPendingIncidents();
    }

    public Incident getIncidentTypesById(String id) {
        return incidentRepository.getIncidentTypesById(id);
    }

    public int updateIncident(String id, String incidentReport) {
        return incidentRepository.updateIncident(id, incidentReport);
    }

    public String getUniqueIncidentId() {
        Random random = new Random();
        int value = random.nextInt(9000) + 1000;
        String uniqueNum = Integer.toString(value);
        return uniqueNum;
    }
}


