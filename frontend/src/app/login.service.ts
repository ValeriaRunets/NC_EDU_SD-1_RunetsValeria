import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../model/User';
import {AuthToken} from '../model/AuthToken';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  public currentUser: Observable<User>;
  constructor(private http: HttpClient) { }
  login(user: User) {
    const param = JSON.stringify(user);
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post('http://localhost:8081/token/generate-token', param, {headers});
  }
}
