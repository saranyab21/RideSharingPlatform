package com.joy.rsp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.joy.rsp.repo.IncidentRepository;
import com.joy.rsp.service.IncidentService;
import com.joy.rsp.entity.DTOs.*;
import com.joy.rsp.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IncidentServiceTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private IncidentRepository incidentRepository;

    @InjectMocks
    private IncidentService incidentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPendingIncidents() {
        // Arrange
        List<Incident> pendingIncidents = new ArrayList<>();
        when(incidentRepository.getAllPendingIncidents()).thenReturn(pendingIncidents);

        // Act
        List<Incident> result = incidentService.getAllPendingIncidents();

        // Assert
        assertSame(pendingIncidents, result);
        verify(incidentRepository, times(1)).getAllPendingIncidents();
    }

    @Test
    void testGetIncidentTypesById() {
        // Arrange
        String id = "123";
        Incident incident = new Incident();
        when(incidentRepository.getIncidentTypesById(id)).thenReturn(incident);

        // Act
        Incident result = incidentService.getIncidentTypesById(id);

        // Assert
        assertSame(incident, result);
        verify(incidentRepository, times(1)).getIncidentTypesById(id);
    }

    @Test
    void testUpdateIncident() {
        // Arrange
        String id = "123";
        String incidentReport = "Test report";
        when(incidentRepository.updateIncident(id, incidentReport)).thenReturn(1);

        // Act
        int result = incidentService.updateIncident(id, incidentReport);

        // Assert
        assertEquals(1, result);
        verify(incidentRepository, times(1)).updateIncident(id, incidentReport);
    }

    @Test
    void testGetUniqueIncidentId() {
        // Act
        String result = incidentService.getUniqueIncidentId();

        // Assert
        assertNotNull(result);
        assertEquals(4, result.length());
        assertTrue(result.matches("\\d+"));
    }
}
