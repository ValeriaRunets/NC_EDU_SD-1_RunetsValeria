import { Component, OnInit } from '@angular/core';
import {User} from '../../model/User';
import {UserService} from '../user.service';
import {AuthenticationService} from '../authentication.service';

@Component({
  selector: 'app-allusers',
  templateUrl: './allusers.component.html',
  styleUrls: ['./allusers.component.css']
})
export class AllusersComponent implements OnInit {
  users: User[];
  isAdmin: boolean;
  constructor(private userService: UserService,
              private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.userService.getAll().subscribe((data: User[]) => this.users = data);
    if (this.authenticationService.currentUsersRole === 'ADMIN') {
      this.isAdmin = true;
    }
  }
  public delete(i: number) {
    this.userService.delete(this.users[i].id).subscribe();
    this.users.splice(i, 1);
  }
}
