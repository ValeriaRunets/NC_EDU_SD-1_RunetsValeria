import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Meeting} from '../model/Meeting';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MeetingService {

  constructor(private http: HttpClient) { }
  public addMeeting(meeting: Meeting): Observable<Meeting> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post<Meeting>('http://localhost:8081/api1/meeting', meeting);
  }
  getAll(): Observable<any> {
    return this.http.get('http://localhost:8081/api1/meeting/all');
  }
}
