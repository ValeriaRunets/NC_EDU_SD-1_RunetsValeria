import { Component, OnInit } from '@angular/core';
import {Meeting} from '../../model/Meeting';
import {MeetingService} from '../meeting.service';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {
  private day: number;
  private  date: Date;
  private meetings: Meeting[];
  constructor(private meetingService: MeetingService) { }

  ngOnInit() {
    this.date = new Date();
    this.day = this.date.getDay();
    this.meetingService.getAll().subscribe((data: Meeting[]) => this.meetings = data);
  }
}
