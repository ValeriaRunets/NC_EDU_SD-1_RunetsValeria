import { Component, OnInit } from '@angular/core';
import {RoomService} from '../room.service';
import {Room} from '../../model/Room';
import {AuthenticationService} from "../authentication.service";

@Component({
  selector: 'app-allrooms',
  templateUrl: './allrooms.component.html',
  styleUrls: ['./allrooms.component.css']
})
export class AllroomsComponent implements OnInit {
  rooms: Room[];
  isAdmin: boolean;
  constructor(private roomService: RoomService,
              private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.roomService.getAll().subscribe((data: Room[]) => this.rooms = data);
    if (this.authenticationService.currentUsersRole === 'ADMIN') {
      this.isAdmin = true;
    }
  }
  public delete(i: number) {
    this.roomService.delete(this.rooms[i].id).subscribe();
    this.rooms.splice(i, 1);
  }
}
