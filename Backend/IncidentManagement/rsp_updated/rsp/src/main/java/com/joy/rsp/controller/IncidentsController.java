package com.joy.rsp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.joy.rsp.entity.*;
import com.joy.rsp.entity.DTOs.*;
import com.joy.rsp.service.IncidentService;
import com.joy.rsp.service.exceptions.CannotReportIncidentException;
import com.joy.rsp.repo.IncidentRepository;

import java.util.List;
import com.joy.rsp.entity.DTOs.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
@CrossOrigin
public class IncidentsController {
    private IncidentService incidentService;
    
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public IncidentsController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @Autowired
    private IncidentRepository incidentRepository;

    @PostMapping("incidents/report")
    public ResponseEntity<String> addIncident(@RequestBody IncidentDTOs incidentDTO) throws CannotReportIncidentException {
        boolean success = incidentService.addIncident(incidentDTO);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
 
    @GetMapping("incidents")
    public ResponseEntity<List<Incident>> getPendingStatus() {
        List<Incident> incidents = incidentService.getAllPendingIncidents();
        return ResponseEntity.ok(incidents);
    }

    @GetMapping("incidents/{id}")
    public ResponseEntity<Incident> getType(@PathVariable("id") String id) {
        Incident incident = incidentService.getIncidentTypesById(id);
        if (incident == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(incident);
    }

  //  @PutMapping("incidents/{id}/investigationreport")
    //public ResponseEntity<String> updateIncident(@PathVariable("id") String incidentId, @RequestBody String incidentDetails) {
      //  int result = incidentService.updateIncident(incidentId, incidentDetails);
        //if (result > 0) {
          //  return ResponseEntity.ok("Success");
        //}
        //return ResponseEntity.notFound().build();
   // }
}
