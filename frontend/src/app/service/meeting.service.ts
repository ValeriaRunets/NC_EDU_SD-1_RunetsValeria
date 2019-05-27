import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Meeting} from '../../model/Meeting';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MeetingService {

  constructor(private http: HttpClient) { }
  public addMeeting(meeting: Meeting): Observable<any> {
    return this.http.post('api1/meeting/', meeting);
  }
  getByDate(date): Observable<any> {
    return this.http.post('api1/meeting/date', date);
  }
  public delete(id: string) {
    return this.http.delete('api1/meeting/' + id);
  }
  public deleteForCur(meeting: Meeting, login: string) {
    return this.http.put('api1/meeting/' + login, meeting);
  }
}
