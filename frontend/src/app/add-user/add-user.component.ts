import { Component, OnInit } from '@angular/core';
import {User} from '../../model/User';
import {UserService} from '../service/user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  private user: User = new User();
  private flag = false;
  constructor(private userService: UserService) { }

  ngOnInit() {
  }
  public setName(name: string) {
    this.user.name = name;
  }
  public setLogin(login: string) {
    this.user.login = login;
  }
  public setPassword(password: string) {
    this.user.password = password;
  }
  public addUser() {
    this.userService.isExist(this.user.login).subscribe((val: any) => this.checkLogin(val));
  }
  public checkLogin(val) {
    this.flag = val;
    if (!this.flag) {
      this.userService.addUser(this.user).subscribe();
    }
  }
}
