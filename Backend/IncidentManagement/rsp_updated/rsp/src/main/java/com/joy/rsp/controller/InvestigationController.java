/*package com.joy.rsp.controller;

import com.joy.rsp.repo.interfaces.*;
import com.joy.rsp.entity.DTOs.*;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@AllArgsConstructor
public class InvestigationController {
    private  IInvestigation investigation;

    @PutMapping("incidents/{id}/investigationreport")
    public ResponseEntity<String> updateIncident(@RequestBody InvestigationDTO investigationDTO) {
        investigation.updateIncident(investigationDTO);
        return ResponseEntity.ok("Success");
    }
}*/

package com.joy.rsp.controller;

import com.joy.rsp.repo.interfaces.*;
import com.joy.rsp.entity.DTOs.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*@RestController
@RequestMapping("api/")
public class InvestigationController {
    private final IInvestigation investigation;

    public InvestigationController(IInvestigation investigation) {
        this.investigation = investigation;
    }

    @PutMapping("incidents/{id}/investigationreport")
    public ResponseEntity<String> updateIncident(@RequestBody InvestigationDTO investigationDTO) {
        investigation.updateIncident(investigationDTO);
        return ResponseEntity.ok("Success");
    }
}*/
@RestController
@RequestMapping("api/")
@CrossOrigin
public class InvestigationController {
    private final IInvestigation investigation;

    public InvestigationController(IInvestigation investigation) {
        this.investigation = investigation;
    }

    @PutMapping("incidents/{id}/investigationreport")
    public ResponseEntity<String> updateIncident(@PathVariable("id") String incidentId, @RequestBody InvestigationDTO investigationDTO) {
        int result = investigation.updateIncident(incidentId, investigationDTO);
        if (result == 1) {
            return ResponseEntity.ok("Success");
        } else if (result == 0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update incident and investigation.");
        }
    }
}

