import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Meeting} from '../model/Meeting';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MeetingService {

  constructor(private http: HttpClient) { }
  public addMeeting(meeting: Meeting): Observable<any> {
    return this.http.post('http://localhost:8081/api1/meeting/add', meeting);
  }
}
