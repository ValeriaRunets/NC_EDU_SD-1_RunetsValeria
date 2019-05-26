import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Room} from '../model/Room';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private http: HttpClient) { }
  public addRoom(room: Room): Observable<any> {
    return this.http.post('api1/room/', room);
  }
  public getAll(): Observable<any> {
    return this.http.get('api1/room/all');
  }
  public delete(id: string): Observable<any> {
    return this.http.delete('api1/room/' + id);
  }
  public getById(id: string): Observable<any> {
    return this.http.get('api1/room/' + id);
  }
  public getFree(date1, date2) {
    const dates = [date1, date2];
    return this.http.post('api1/room/free', dates);
  }
}
