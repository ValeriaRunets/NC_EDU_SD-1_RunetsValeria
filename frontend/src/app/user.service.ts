import { Injectable } from '@angular/core';
import {User} from '../model/User';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
  public addUser(user: User): Observable<any> {
    return this.http.post('api1/user/', user);
  }
  public getAll(): Observable<any> {
    return this.http.get('api1/user/all');
  }
  public delete(id: string): Observable<any> {
    return this.http.delete('api1/user/' + id);
  }
  public isExist(login: string): Observable<any> {
    return this.http.get('api1/user/check/' + login);
  }
  public getById(id: string): Observable<any> {
    return this.http.get('api1/user/' + id);
  }
}
