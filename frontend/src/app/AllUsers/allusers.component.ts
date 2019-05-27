import { Component, OnInit } from '@angular/core';
import {User} from '../../model/User';
import {PageEvent} from '@angular/material';
import {UserService} from '../service/user.service';
import {AuthenticationService} from '../service/authentication.service';

@Component({
  selector: 'app-allusers',
  templateUrl: './allusers.component.html',
  styleUrls: ['./allusers.component.css']
})
export class AllusersComponent implements OnInit {
  users: User[];
  length = 0;
  pageSize = 5;
  pageEvent: PageEvent;
  isAdmin: boolean;
  constructor(private userService: UserService,
              private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.userService.count().subscribe((data: number) => this.length = data);
    this.userService.getAll(0).subscribe((data: User[]) => this.users = data);
    if (this.authenticationService.currentUsersRole === 'ADMIN') {
      this.isAdmin = true;
    }
  }
  public delete(i: number) {
    this.userService.delete(this.users[i].id).subscribe();
    this.users.splice(i, 1);
    length--;
  }
  change() {
    this.userService.getAll(this.pageEvent.pageIndex).subscribe((data: User[]) => this.users = data);
  }
}
