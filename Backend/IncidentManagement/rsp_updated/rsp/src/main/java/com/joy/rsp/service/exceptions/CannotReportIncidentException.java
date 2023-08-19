package com.joy.rsp.service.exceptions;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CannotReportIncidentException extends Exception {
    public CannotReportIncidentException(String message) {
        super(message);
    }
}
