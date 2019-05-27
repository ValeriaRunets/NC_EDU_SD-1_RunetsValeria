import {Component, OnDestroy, OnInit} from '@angular/core';
import {User} from '../../model/User';
import {LoginService} from '../service/login.service';
import {Router} from '@angular/router';
import {DialogComponent} from '../dialog/dialog.component';
import {UserService} from '../service/user.service';
import {MatDialog} from '@angular/material';
import {AuthenticationService} from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {
  user: User = new User();
  isAuthorized = false;
  flag = true;
  err;
  constructor(private loginService: LoginService, private router: Router,
              private userService: UserService,
              private dialog: MatDialog,
              private auth: AuthenticationService) { }

  ngOnInit() {
    if (localStorage.getItem('currentUser') != null) {
      this.isAuthorized = true;
    }
  }
  ngOnDestroy() {
    localStorage.removeItem('currentUser');
  }
  setLogin(str: string) {
    this.user.login = str;
  }
  setPassword(str: string) {
    this.user.password = str;
  }
  login(): void {
      this.loginService.login(this.user).subscribe(dat => {this.saveToken(dat); },
      error => {this.err = error; this.flag = false; this.isAuthorized = false; return; });
  }
  saveToken(token: any) {
      window.localStorage.setItem('currentUser', token.token);
      this.isAuthorized = true;
      this.userService.isFirst().subscribe((data: boolean) => this.openDialog(data));
  }
  openDialog(data) {
    if (data) {
      this.dialog.open(DialogComponent, {});
    }
  }
}
