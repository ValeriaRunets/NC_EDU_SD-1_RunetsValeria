import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef} from '@angular/material';
import {UserService} from '../service/user.service';
import {AuthenticationService} from '../service/authentication.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent {

  form: FormGroup;
  password = '';
  password1 = ' ';
  constructor(private dialogRef: MatDialogRef<DialogComponent>,
              private userService: UserService,
              private auth: AuthenticationService,
              private  fb: FormBuilder) {
    this.form = this.fb.group({
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
    dialogRef.disableClose = true;
    this.dialogRef.afterClosed().subscribe(result => {
      this.userService.changePassword(result).subscribe();
    });
  }

  openDialog(): void {
    this.dialogRef.afterClosed().subscribe(result => {
      this.userService.changePassword(result).subscribe();
    });
  }
}
