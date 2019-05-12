import { Component, OnInit } from '@angular/core';
import {User} from '../../model/User';
import {LoginService} from '../login.service';
import {Router} from '@angular/router';
import {AuthToken} from '../../model/AuthToken';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();
  token: string;
  isAuthorized = false;
  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    if (localStorage.getItem('currentUser') != null) {
      this.isAuthorized = true;
    }
  }
  setLogin(str: string) {
    this.user.login = str;
  }
  setPassword(str: string) {
    this.user.password = str;
  }
  login(): void {
    this.loginService.login(this.user).subscribe(data => {this.saveToken(data); });
    this.isAuthorized = true;
  }
  saveToken(token: any) {
    window.localStorage.setItem('currentUser', token.token);
  }
}
