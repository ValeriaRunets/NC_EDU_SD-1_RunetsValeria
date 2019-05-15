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
    return this.http.post('http://localhost:8081/token/generate-token', user);
  }
  getToken(): string {
    return localStorage.getItem('currentUser');
  }
}
