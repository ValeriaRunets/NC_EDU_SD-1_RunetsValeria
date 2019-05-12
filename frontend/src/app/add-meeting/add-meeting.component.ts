import { Component, OnInit } from '@angular/core';
import {MeetingService} from '../meeting.service';
import {Meeting} from '../../model/Meeting';
import {User} from '../../model/User';
import {UserService} from '../user.service';
import {RoomService} from '../room.service';
import {Room} from '../../model/Room';

@Component({
  selector: 'app-add-meeting',
  templateUrl: './add-meeting.component.html',
  styleUrls: ['./add-meeting.component.css']
})
export class AddMeetingComponent implements OnInit {
  private meeting: Meeting = new Meeting();
  users: User[];
  rooms: Room[];
  constructor(private meetingService: MeetingService,
              private userService: UserService,
              private roomService: RoomService) { }

  ngOnInit() {
    this.userService.getAll().subscribe((data: User[]) => this.users = data);
    this.roomService.getAll().subscribe((data: Room[]) => this.rooms = data);
  }
  setTheme(theme: string) {
    this.meeting.theme = theme;
  }
  setDateOfTheBeginning(date: string) {
    this.meeting.dateOfTheBeginning = date;
  }
  setDateOfTheEnd(date: string) {
    this.meeting.dateOfEnd = date;
  }
  setTimeOfNotification(num: number) {
    this.meeting.timeOfNotification = num;
  }
  setRoom(id: Room) {
    this.meeting.room = id;
  }
  addMeeting() {
    this.meetingService.addMeeting(this.meeting).subscribe();
  }
}
