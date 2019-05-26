import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CalendarComponent } from './calendar/calendar.component';
import { MenuUserComponent } from './menu-user/menu-user.component';
import { RouterModule} from '@angular/router';
import { AddMeetingComponent } from './add-meeting/add-meeting.component';
import { AddUserComponent } from './add-user/add-user.component';
import {UserService} from './user.service';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { AllusersComponent } from './allusers/allusers.component';
import {AllroomsComponent} from './allrooms/allrooms.component';
import {AddRoomComponent} from './add-room/add-room.component';
import {TokenInterceptor} from './api.interceptor';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatDialogModule} from "@angular/material";

const routes = [
  {path: 'log', component: LoginComponent},
  {path: 'addUser', component: AddUserComponent},
  {path: 'calendar', component: CalendarComponent},
  {path: 'allUsers', component: AllusersComponent},
  {path: 'allRooms', component: AllroomsComponent},
  {path: 'addRoom', component: AddRoomComponent},
  {path: 'addMeeting', component: AddMeetingComponent},
  {path: 'menu', component: MenuUserComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CalendarComponent,
    MenuUserComponent,
    AddMeetingComponent,
    AddUserComponent,
    AllusersComponent,
    AllroomsComponent,
    AddRoomComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    MatDialogModule
  ],
  providers: [
    UserService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
