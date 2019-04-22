import { Component, OnInit } from '@angular/core';
import {Room} from '../../model/Room';
import {RoomService} from '../room.service';

@Component({
  selector: 'app-add-room',
  templateUrl: './add-room.component.html',
  styleUrls: ['./add-room.component.css']
})
export class AddRoomComponent implements OnInit {
  private room: Room = new Room();
  constructor(private roomService: RoomService) { }

  ngOnInit() {
  }
  public setAdress(adress: string) {
    this.room.adress = adress;
  }
  public setAmount(amount: number) {
    this.room.amount = amount;
  }
  public addRoom() {
    this.roomService.addRoom(this.room).subscribe();
  }
}
