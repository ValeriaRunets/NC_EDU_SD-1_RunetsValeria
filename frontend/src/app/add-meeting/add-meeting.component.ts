import { Component, OnInit } from '@angular/core';
import {MeetingService} from '../meeting.service';
import {Meeting} from '../../model/Meeting';
import {User} from '../../model/User';
import {UserService} from '../user.service';
import {RoomService} from '../room.service';
import {Room} from '../../model/Room';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthenticationService} from "../authentication.service";

@Component({
  selector: 'app-add-meeting',
  templateUrl: './add-meeting.component.html',
  styleUrls: ['./add-meeting.component.css']
})
export class AddMeetingComponent implements OnInit {
  private meeting: Meeting = new Meeting();
  users: User[];
  rooms: Room[];
  id: string;
  page = 1;
  count = 0;
  members = new Array();
  val = 0;
  firstGroup: FormGroup[] = [];
  curName: string;
  constructor(private meetingService: MeetingService,
              private userService: UserService,
              private roomService: RoomService,
              private  fb: FormBuilder,
              private auth: AuthenticationService) { }

  ngOnInit() {
    this.curName = this.auth.currentUserName;
    this.userService.getAll().subscribe((data: User[]) => this.users = data);
    // this.roomService.getAll().subscribe((data: Room[]) => this.rooms = data);
    this.initForm();
  }
  initForm() {
    this.firstGroup[0] = this.fb.group({
      theme: ['', Validators.required],
      date: ['', Validators.required],
      time1: ['', Validators.required],
      time2: ['', Validators.required]
    });
    this.firstGroup[1] = this.fb.group({
      contr: ['', Validators.required]
    });
    this.firstGroup[2] = this.fb.group({
      check: ['', Validators.max(1)]
    });
  }
  addMeeting() {
    this.meeting.theme = this.firstGroup[0].controls.theme.value;
    const date = this.firstGroup[0].controls.date.value;
    this.meeting.dateOfTheBeginning = date + 'T' + this.firstGroup[0].controls.time1.value;
    this.meeting.dateOfEnd = date + 'T' + this.firstGroup[0].controls.time2.value;
    this.meeting.idRoom = this.firstGroup[1].controls.contr.value;
    for (let i = 0; i < this.members.length; i++) {
      this.meeting.membersId.push(this.members[i]);
    }
    this.meetingService.addMeeting(this.meeting).subscribe();
  }
  plusPage() {
    if (this.page === 1) {
      const date = this.firstGroup[0].controls.date.value;
      const buf1 = new Date(date + 'T' + this.firstGroup[0].controls.time1.value);
      const buf2 = new Date(date + 'T' + this.firstGroup[0].controls.time2.value);
      this.roomService.getFree(buf1, buf2).subscribe((data: Room[]) => this.rooms = data);
    }
    this.page++;
  }
  change(event) {
    if (event.target.checked) {
      this.count++;
      this.members.push(event.target.value);
    } else {
      this.count--;
      this.members.splice(this.members.indexOf(event.target.value), 1);
    }
  }
  chRoom(room) {
    this.val = room.amount;
  }
}
