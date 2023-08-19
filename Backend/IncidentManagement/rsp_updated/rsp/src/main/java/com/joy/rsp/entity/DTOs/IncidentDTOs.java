package com.joy.rsp.entity.DTOs;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

public class IncidentDTOs {

    private Long id;

    @Past
    private LocalDate incidentDate;

    @Future
    private LocalDate reportDate;

    private int incidentReportedByUserId;

    private LocalDate resolutionETA;

    private int investigatedByUserId;

    private String incidentSummary;

    private String incidentDetails;

    private int bookingId;

    private String status;

    private int incidentTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public int getIncidentReportedByUserId() {
        return incidentReportedByUserId;
    }

    public void setIncidentReportedByUserId(int incidentReportedByUserId) {
        this.incidentReportedByUserId = incidentReportedByUserId;
    }

    public LocalDate getResolutionETA() {
        return resolutionETA;
    }

    public void setResolutionETA(LocalDate resolutionETA) {
        this.resolutionETA = resolutionETA;
    }

    public int getInvestigatedByUserId() {
        return investigatedByUserId;
    }

    public void setInvestigatedByUserId(int investigatedByUserId) {
        this.investigatedByUserId = investigatedByUserId;
    }

    public String getIncidentSummary() {
        return incidentSummary;
    }

    public void setIncidentSummary(String incidentSummary) {
        this.incidentSummary = incidentSummary;
    }

    public String getIncidentDetails() {
        return incidentDetails;
    }

    public void setIncidentDetails(String incidentDetails) {
        this.incidentDetails = incidentDetails;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIncidentTypeId() {
        return incidentTypeId;
    }

    public void setIncidentTypeId(int incidentTypeId) {
        this.incidentTypeId = incidentTypeId;
    }
}
