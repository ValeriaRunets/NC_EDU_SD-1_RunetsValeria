import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticationService} from '../service/authentication.service';

@Component({
  selector: 'app-menu-user',
  templateUrl: './menu-user.component.html',
  styleUrls: ['./menu-user.component.css']
})
export class MenuUserComponent implements OnInit {
  private isAdmin: boolean;
  constructor(private router: Router,
              private authenticationService: AuthenticationService) {
  }
  ngOnInit() {
    if (this.authenticationService.currentUsersRole === 'ADMIN') {
      this.isAdmin = true;
    }
  }
  goToPage(adress: string): void {
    this.router.navigate([adress]);
  }
  exit() {
    localStorage.removeItem('currentUser');
    window.location.reload();
  }
}

