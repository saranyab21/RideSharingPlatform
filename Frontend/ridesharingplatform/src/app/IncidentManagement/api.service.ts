import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Incident } from './model/incident.model';




@Injectable({

    providedIn: 'root'

})

export class IncidentService {

    private apiUrl = 'http://localhost:8082/api';




    constructor(private http: HttpClient) { }




    // submitIncident(type: string, details: string): Observable<string> {

    //     const body = { type, details };




    //     return this.http.post<string>(this.apiUrl, body);

    // }

    submitIncident(type: string, details: string): Observable<string> {
        const body = { type, details };
        const headers = { 'Content-Type': 'application/json' };
    
        return this.http.post<string>(this.apiUrl, body, { headers });
    }

    // addIncident(){

    //   return this.http.post<any>(`${this.apiUrl}/incidents/report`);

    // }

    getIncidents(): Observable<Incident[]> {

        return this.http.get<Incident[]>(this.apiUrl + '/incidents');

    }

    getIncidentType(): Observable<any> {

        return this.http.get<any>(`${this.apiUrl}/incidents/types`);

    }

    getIncident(incidentID: string): Observable<Incident> {

        return this.http.get<Incident>(`${this.apiUrl}/incidents/${incidentID}`);

    }

    updateStatus(incidentID: string, status: string, finding: string, suggestions: string, investigationDate: any): Observable<any> {

        return this.http.put<any>(`${this.apiUrl}/incidents/${incidentID}/investigationreport`, { incidentID, status, finding, suggestions, investigationDate });

    }

    addIncident(incidentForm: any): Observable<any> {

        return this.http.post<any>(`${this.apiUrl}/incidents/report`, incidentForm);

    }

}
