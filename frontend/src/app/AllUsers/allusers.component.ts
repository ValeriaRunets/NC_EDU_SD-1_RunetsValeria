import { Component, OnInit } from '@angular/core';
import {User} from '../../model/User';
import {UserService} from '../user.service';

@Component({
  selector: 'app-allusers',
  templateUrl: './allusers.component.html',
  styleUrls: ['./allusers.component.css']
})
export class AllusersComponent implements OnInit {
  users: User[];
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getAll().subscribe((data: User[]) => this.users = data);
  }
  public delete(i: number) {
    this.userService.delete(this.users[i].id).subscribe();
    this.users.splice(i, 1);
  }
}
