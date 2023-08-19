package com.joy.rsp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "incident_types")
public class IncidentTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "expected_sla_in_days")
    private Integer expectedSLAInDays;

    public IncidentTypes() {
    }

    public IncidentTypes(String type, Integer expectedSLAInDays) {
        this.type = type;
        this.expectedSLAInDays = expectedSLAInDays;
    }

    // Generate getter and setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getExpectedSLAInDays() {
        return expectedSLAInDays;
    }

    public void setExpectedSLAInDays(Integer expectedSLAInDays) {
        this.expectedSLAInDays = expectedSLAInDays;
    }
}
