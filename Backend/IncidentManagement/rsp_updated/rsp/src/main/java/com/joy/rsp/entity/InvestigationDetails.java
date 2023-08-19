package com.joy.rsp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "investigation_details")
public class InvestigationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "findings")
    private String findings;

    @Column(name = "suggestions")
    private String suggestions;

    @Column(name = "investigation_date")
    private LocalDate investigationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incidents_incident_id")
    private Incident incidents;

    

    public InvestigationDetails() {
    }

    public InvestigationDetails(String findings, String suggestions, LocalDate investigationDate,
                                Incident incidents) {
        this.findings = findings;
        this.suggestions = suggestions;
        this.investigationDate = investigationDate;
        this.incidents = incidents;
       
    }

    // Generate getter and setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFindings() {
        return findings;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public LocalDate getInvestigationDate() {
        return investigationDate;
    }

    public void setInvestigationDate(LocalDate date) {
        this.investigationDate = date;
    }

    public Incident getIncidents() {
        return incidents;
    }

    public void setIncidents(Incident incidents) {
        this.incidents = incidents;
    }

   
}
