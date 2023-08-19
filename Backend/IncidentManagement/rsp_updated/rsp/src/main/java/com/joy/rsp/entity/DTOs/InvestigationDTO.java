package com.joy.rsp.entity.DTOs;


import com.joy.rsp.entity.Incident;
import java.time.LocalDate;
import jakarta.persistence.*;

public class InvestigationDTO {
    private String finding;
    private String suggestions;
    private LocalDate investigationDate;

    @ManyToOne
    @JoinColumn(name = "incident_id")
    private Incident incident;

    private String status;

    public String getFinding() {
        return finding;
    }

    public void setFinding(String finding) {
        this.finding = finding;
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

    public void setInvestigationDate(LocalDate investigationDate) {
        this.investigationDate = investigationDate;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

