package com.joy.rsp.repo;
//import RideSharingPlatform.Microservices.IncidentManagement.Models.DTO.Incident;
//import RideSharingPlatform.Microservices.IncidentManagement.Models.IncidentTypes;
//import com.joy.rsp.entity.DTOs.*;
import com.joy.rsp.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
//import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class IncidentRepository {
    private final EntityManager entityManager;

    @Autowired
    public IncidentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public int addIncident(Incident incident) {
        entityManager.persist(incident);
        return 1;
    }

    public IncidentTypes getIncidentType(Long id) {
        return entityManager.find(IncidentTypes.class, id);
    }

    public List<Incident> getAllPendingIncidents() {
        return entityManager.createQuery("SELECT i FROM Incident i WHERE i.status = 'Pending'", Incident.class).getResultList();
    }

    public Incident getIncidentTypesById(String id) {
        return entityManager.find(Incident.class, id);
    }

    public int updateIncident(String id, String incidentReport) {
        Incident incident = entityManager.find(Incident.class, id);
        if (incident != null) {
            incident.setIncidentDetails(incidentReport);
            return 1;
        } else {
            return 0;
        }
    }
}

