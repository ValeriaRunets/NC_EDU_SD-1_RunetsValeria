import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Meeting} from '../model/Meeting';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MeetingService {

  constructor(private http: HttpClient) { }
  public addMeeting(meeting: Meeting): Observable<any> {
    // const headers = {Authorization: localStorage.getItem('currentUser')};
    console.log('srdtfyguh');
    const str = localStorage.getItem('currentUser');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + str);
    headers.set('Content-Type', 'application/json');
    console.log(str);
    return this.http.post('http://localhost:8081/api1/meeting', JSON.stringify(meeting), {headers});
  }
  getAll(): Observable<any> {
    return this.http.get('http://localhost:8081/api1/meeting/all');
  }
}
