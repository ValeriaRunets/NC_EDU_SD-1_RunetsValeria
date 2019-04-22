import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllroomsComponent } from './allrooms.component';

describe('AllroomsComponent', () => {
  let component: AllroomsComponent;
  let fixture: ComponentFixture<AllroomsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllroomsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllroomsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
