import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-menu-user',
  templateUrl: './menu-user.component.html',
  styleUrls: ['./menu-user.component.css']
})
export class MenuUserComponent implements OnInit {
  constructor(private router: Router) {
  }
  ngOnInit() {
  }
  goToPage(adress: string): void {
    this.router.navigate([adress]);
  }
}

