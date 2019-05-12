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
    return this.http.post('http://localhost:8081/api1/user/', user);
  }
  public getAll(): Observable<any> {
    return this.http.get('http://localhost:8081/api1/user/all');
  }
  public delete(id: number): Observable<any> {
    return this.http.delete('http://localhost:8081/api1/user/' + id);
  }
  public getByLogin(login: string): Observable<any> {
    return this.http.get('http://localhost:8081/api1/user/login/' + login);
  }
}
