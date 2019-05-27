import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }
  public get currentUsersRole(): string {
    const helper = new JwtHelperService();
    const decodedToken = helper.decodeToken(localStorage.getItem('currentUser').toString());
    return decodedToken.scopes.substring(5);
  }
  public get currentUserName(): string {
    const helper = new JwtHelperService();
    const decodedToken = helper.decodeToken(localStorage.getItem('currentUser').toString());
    return decodedToken.sub;
  }
}
