package com.joy.rsp.repo;

import com.joy.rsp.repo.interfaces.*;
import com.joy.rsp.entity.*;

//import RideSharingPlatform.Microservices.IncidentManagement.DAL.Interface.IIncidentType;
//import RideSharingPlatform.Microservices.IncidentManagement.Models.IncidentTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class IncidentTypeRepository implements IIncidentType {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<IncidentTypes> getIncidentTypes() {
        return entityManager.createQuery("SELECT it FROM IncidentTypes it", IncidentTypes.class)
                .getResultList();
    }

    @Override
    public IncidentTypes getIncidentTypesById(int id) {
        return entityManager.find(IncidentTypes.class, id);
    }
}

