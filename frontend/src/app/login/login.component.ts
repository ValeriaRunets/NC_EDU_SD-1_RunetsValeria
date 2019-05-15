import { Component, OnInit } from '@angular/core';
import {User} from '../../model/User';
import {LoginService} from '../login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();
  isAuthorized = false;
  flag = true;
  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }
  setLogin(str: string) {
    this.user.login = str;
  }
  setPassword(str: string) {
    this.user.password = str;
  }
  login(): void {
      this.loginService.login(this.user).subscribe(dat => {this.saveToken(dat); },
      error => {this.flag = false; this.isAuthorized = false; });
  }
  saveToken(token: any) {
      window.localStorage.setItem('currentUser', token.token);
      this.isAuthorized = true;
  }
}
