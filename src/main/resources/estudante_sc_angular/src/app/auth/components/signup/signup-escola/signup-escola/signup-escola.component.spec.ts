import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupEscolaComponent } from './signup-escola.component';

describe('SignupEscolaComponent', () => {
  let component: SignupEscolaComponent;
  let fixture: ComponentFixture<SignupEscolaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SignupEscolaComponent]
    });
    fixture = TestBed.createComponent(SignupEscolaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
