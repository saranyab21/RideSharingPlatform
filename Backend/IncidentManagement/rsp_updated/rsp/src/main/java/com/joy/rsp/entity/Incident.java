package com.joy.rsp.entity;


import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incident_id")
    private String incidentID;

    @Column(name = "incident_date")
    private LocalDate incidentDate;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "incident_reported_by_user_id")
    private Long incidentReportedByUserId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incident_type_id")
    private IncidentTypes incidentType;

    @Column(name = "resolution_eta")
    private LocalDate resolutionETA;

    @Column(name = "investigated_by_user_id")
    private Long investigatedByUserId;

    @Column(name = "incident_summary")
    private String incidentSummary;

    @Column(name = "incident_details")
    private String incidentDetails;

    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "status")
    private String status;

    public Incident() {
        this.status = "Pending"; // Default value for status
    }

    // Generate constructors

    public Incident(LocalDate incidentDate, LocalDate reportDate, Long incidentReportedByUserId,
                     IncidentTypes incidentType, LocalDate resolutionETA, Long investigatedByUserId,
                     String incidentSummary, String incidentDetails, Long bookingId) {
        this.incidentDate = incidentDate;
        this.reportDate = reportDate;
        this.incidentReportedByUserId = incidentReportedByUserId;
        this.incidentType = incidentType;
        this.resolutionETA = resolutionETA;
        this.investigatedByUserId = investigatedByUserId;
        this.incidentSummary = incidentSummary;
        this.incidentDetails = incidentDetails;
        this.bookingId = bookingId;
        this.status = "Pending"; // Default value for status
    }

    // Generate getter and setter methods

    public String getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(String incidentID) {
        this.incidentID = incidentID;
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

    public Long getIncidentReportedByUserId() {
        return incidentReportedByUserId;
    }

    public void setIncidentReportedByUserId(Long incidentReportedByUserId) {
        this.incidentReportedByUserId = incidentReportedByUserId;
    }

    public IncidentTypes getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(IncidentTypes incidentType) {
        this.incidentType = incidentType;
    }

    public LocalDate getResolutionETA() {
        return resolutionETA;
    }

    public void setResolutionETA(LocalDate resolutionETA) {
        this.resolutionETA = resolutionETA;
    }

    public Long getInvestigatedByUserId() {
        return investigatedByUserId;
    }

    public void setInvestigatedByUserId(Long investigatedByUserId) {
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

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Long getIncidentTypeId() {
        return incidentType.getId();
    }
}