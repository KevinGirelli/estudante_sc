import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupProfessorComponent } from './signup-professor.component';

describe('SignupProfessorComponent', () => {
  let component: SignupProfessorComponent;
  let fixture: ComponentFixture<SignupProfessorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SignupProfessorComponent]
    });
    fixture = TestBed.createComponent(SignupProfessorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
