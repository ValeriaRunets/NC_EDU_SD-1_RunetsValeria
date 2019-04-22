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
    return this.http.post('http://localhost:8081/api1/room/add', room);
  }
  public getAll(): Observable<any> {
    return this.http.get('http://localhost:8081/api1/room/all');
  }
  public delete(id: number): Observable<any> {
    return this.http.delete('http://localhost:8081/api1/room/delete/' + id);
  }
}
