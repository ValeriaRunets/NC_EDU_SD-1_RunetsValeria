import { Component, OnInit } from '@angular/core';
import {RoomService} from '../room.service';
import {Room} from '../../model/Room';

@Component({
  selector: 'app-allrooms',
  templateUrl: './allrooms.component.html',
  styleUrls: ['./allrooms.component.css']
})
export class AllroomsComponent implements OnInit {
  rooms: Room[];
  constructor(private roomService: RoomService) { }

  ngOnInit() {
    this.roomService.getAll().subscribe((data: Room[]) => this.rooms = data);
  }
  public delete(i: number) {
    this.roomService.delete(this.rooms[i].id).subscribe();
    this.rooms.splice(i, 1);
  }
}
