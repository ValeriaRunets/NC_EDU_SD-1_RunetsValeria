import { Component, OnInit } from '@angular/core';
import {RoomService} from '../service/room.service';
import {Room} from '../../model/Room';
import {AuthenticationService} from '../service/authentication.service';
import {PageEvent} from '@angular/material';

@Component({
  selector: 'app-allrooms',
  templateUrl: './allrooms.component.html',
  styleUrls: ['./allrooms.component.css']
})
export class AllroomsComponent implements OnInit {
  rooms: Room[];
  isAdmin: boolean;
  length = 0;
  pageSize = 5;
  pageEvent: PageEvent;
  constructor(private roomService: RoomService,
              private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.roomService.count().subscribe((data: number) => this.length = data);
    this.roomService.getPage(0).subscribe((data: Room[]) => this.rooms = data);
    if (this.authenticationService.currentUsersRole === 'ADMIN') {
      this.isAdmin = true;
    }
  }
  public delete(i: number) {
    this.roomService.delete(this.rooms[i].id).subscribe();
    this.rooms.splice(i, 1);
  }
  changePage() {
    this.roomService.getPage(this.pageEvent.pageIndex).subscribe((data: Room[]) => this.rooms = data);
  }
}
