package com.joy.rsp.repo;

import com.joy.rsp.entity.DTOs.*;
import com.joy.rsp.repo.interfaces.IInvestigation;
import com.joy.rsp.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;

/* @Repository
public class InvestigationRepository implements IInvestigation {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public int updateIncident(InvestigationDTO investigationDTO) {
        TypedQuery<Incident> incidentQuery = entityManager.createQuery(
                "SELECT i FROM Incident i WHERE i.incidentId = :incidentId", Incident.class);
        incidentQuery.setParameter("incidentId", investigationDTO.getIncident());
        Incident incident = incidentQuery.getSingleResult();

        if (incident != null) {
            incident.setStatus(investigationDTO.getStatus());

            TypedQuery<InvestigationDetails> investigationQuery = entityManager.createQuery(
                    "SELECT i FROM InvestigationDetails i WHERE i.incidents_incident_id = :incidentId",
                    InvestigationDetails.class);
            investigationQuery.setParameter("incidentId", investigationDTO.getIncident());
            InvestigationDetails investigation = investigationQuery.getResultStream().findFirst().orElse(null);

            if (investigation != null) {
                investigation.setFindings(investigationDTO.getFinding());
                investigation.setSuggestions(investigationDTO.getSuggestions());
                investigation.setInvestigationDate(investigationDTO.getInvestigationDate());

                entityManager.merge(investigation);
                return 1; // Indicates that the incident and investigation were updated
            } else {
                InvestigationDetails newInvestigation = new InvestigationDetails();
                newInvestigation.setFindings(investigationDTO.getFinding());
                newInvestigation.setSuggestions(investigationDTO.getSuggestions());
                newInvestigation.setInvestigationDate(investigationDTO.getInvestigationDate());
                newInvestigation.setIncidents(investigationDTO.getIncident());

                entityManager.persist(newInvestigation);
                return 1; // Indicates that a new investigation was created
            }
        } else {
            return 0; // Indicates that the incident was not found
        }
    }
} */

/*@Repository
public class InvestigationRepository implements IInvestigation {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public int updateIncident(InvestigationDTO investigationDTO) {
        TypedQuery<Incident> incidentQuery = entityManager.createQuery(
                "SELECT i FROM Incident i WHERE i.incidentID = :incidentId", Incident.class);
        incidentQuery.setParameter("incidentId", investigationDTO.getIncident());

        //try {
            Incident incident = incidentQuery.getSingleResult();

            if (incident != null) {
                incident.setStatus(investigationDTO.getStatus());

                TypedQuery<InvestigationDetails> investigationQuery = entityManager.createQuery(
                        "SELECT i FROM InvestigationDetails i WHERE i.incidents.incidentID = :incidentId",
                        InvestigationDetails.class);
                investigationQuery.setParameter("incidentId", investigationDTO.getIncident());
                InvestigationDetails investigation = investigationQuery.getResultStream().findFirst().orElse(null);

                if (investigation != null) {
                    investigation.setFindings(investigationDTO.getFinding());
                    investigation.setSuggestions(investigationDTO.getSuggestions());
                    investigation.setInvestigationDate(investigationDTO.getInvestigationDate());

                    entityManager.merge(investigation);
                    return 1; // Indicates that the incident and investigation were updated
                } else {
                    InvestigationDetails newInvestigation = new InvestigationDetails();
                    newInvestigation.setFindings(investigationDTO.getFinding());
                    newInvestigation.setSuggestions(investigationDTO.getSuggestions());
                    newInvestigation.setInvestigationDate(investigationDTO.getInvestigationDate());
                    newInvestigation.setIncidents(incident);

                    entityManager.persist(newInvestigation);
                    return 1; // Indicates that a new investigation was created
                }
            } else {
                return 0; // Indicates that the incident was not found
            }
        //} catch (NoResultException e) {
        //    return 0; // Indicates that the incident was not found
        }
    }
//}*/
@Repository
@Transactional
public class InvestigationRepository implements IInvestigation {

    private final EntityManager entityManager;

    @Autowired
    public InvestigationRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public int updateIncident(String incidentId, InvestigationDTO investigationDTO) {
        try {
            // Retrieve the existing incident from the database
            Incident incident = entityManager.find(Incident.class, incidentId);
            
            if (incident != null) {
                // Update the incident status
                incident.setStatus(investigationDTO.getStatus());
                
                // Retrieve the existing investigation details associated with the incident
                TypedQuery<InvestigationDetails> investigationQuery = entityManager.createQuery(
                        "SELECT i FROM InvestigationDetails i WHERE i.incidents.incidentID = :incidentId",
                        InvestigationDetails.class);
                investigationQuery.setParameter("incidentId", incidentId);
                InvestigationDetails investigation = investigationQuery.getResultStream().findFirst().orElse(null);

                if (investigation != null) {
                    // Update the investigation details
                    investigation.setFindings(investigationDTO.getFinding());
                    investigation.setSuggestions(investigationDTO.getSuggestions());
                    investigation.setInvestigationDate(investigationDTO.getInvestigationDate());

                    entityManager.merge(investigation);
                    return 1; // Indicates that the incident and investigation were updated
                } else {
                    // Create a new investigation if it doesn't exist
                    InvestigationDetails newInvestigation = new InvestigationDetails();
                    newInvestigation.setFindings(investigationDTO.getFinding());
                    newInvestigation.setSuggestions(investigationDTO.getSuggestions());
                    newInvestigation.setInvestigationDate(investigationDTO.getInvestigationDate());
                    newInvestigation.setIncidents(incident);

                    entityManager.persist(newInvestigation);
                    return 1; // Indicates that a new investigation was created
                }
            } else {
                return 0; // Indicates that the incident was not found
            }
        } catch (Exception e) {
            return -1; // Indicates an error occurred
        }
    }
}




