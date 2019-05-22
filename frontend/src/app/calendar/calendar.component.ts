import { Component, OnInit } from '@angular/core';
import {Meeting} from '../../model/Meeting';
import {MeetingService} from '../meeting.service';
import {RoomService} from '../room.service';
import {Room} from '../../model/Room';
import {AuthenticationService} from '../authentication.service';
import {User} from '../../model/User';
import {UserService} from '../user.service';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {
  private curDate: Date = new Date();
  private day = this.curDate.getDay();
  private date = new Date();
  private meetings: Meeting[][] = [];
  private rooms: string[][] = [];
  private members: User[][][] = [];
  private length = 0;
  private fakeArr ;
  constructor(private meetingService: MeetingService,
              private  roomService: RoomService,
              private auth: AuthenticationService,
              private  userService: UserService) { }

  ngOnInit() {
    console.log(this.curDate);
    if (this.day === 0) {
      this.curDate.setDate(this.curDate.getDate() - 7 + 1);
    } else {
      this.curDate.setDate(this.curDate.getDate() - this.day + 1);
    }
    for (let i = 0; i < 7; i++) {
      this.meetings[i] = [];
      this.meetingService.getByDate(this.date.setDate(this.curDate.getDate() + i)).subscribe((data: Meeting[]) => this.change(data, i));
    }
  }
  change(data, i) {
    this.meetings[i] = data;
    this.rooms[i] = new Array(data.length);
    this.members[i] = new Array(data.length);
    for (let j = 0; j < data.length; j++) {
      this.roomService.getById(this.meetings[i][j].idRoom).subscribe((item: Room) => this.rooms[i][j] = item.adress);
      this.members[i][j] = new Array(this.meetings[i][j].membersId.length);
      for (let k = 0; k < this.meetings[i][j].membersId.length; k++) {
        this.userService.getById(this.meetings[i][j].membersId[k]).subscribe((it: User) => this.members[i][j][k] = it);
      }
    }
    if (this.length < data.length) {
      this.length = data.length;
      this.fakeArr = new Array(this.length);
    }
  }
  deleteUser(meeting: Meeting, name: string) {
    this.meetingService.deleteForCur(meeting, name).subscribe();
  }
  delete(meeting: Meeting) {
    this.meetingService.delete(meeting.id, meeting.creator).subscribe();
    window.location.reload();
  }
}
