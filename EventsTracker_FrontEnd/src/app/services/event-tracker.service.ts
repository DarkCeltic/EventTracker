import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Events } from '../models/events';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
}

@Injectable({
  providedIn: 'root'
})
export class EventTrackerService {
  eventsUrl: string = 'http://localhost:8080/EventTracker/events';
  constructor(private http: HttpClient) { }

  getAllEvents(): Observable<Events[]>{
    return this.http.get<Events[]>(this.eventsUrl);
  }
}
