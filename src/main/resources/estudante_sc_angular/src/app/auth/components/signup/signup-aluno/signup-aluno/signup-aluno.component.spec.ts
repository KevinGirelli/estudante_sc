import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupAlunoComponent } from './signup-aluno.component';

describe('SignupAlunoComponent', () => {
  let component: SignupAlunoComponent;
  let fixture: ComponentFixture<SignupAlunoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SignupAlunoComponent]
    });
    fixture = TestBed.createComponent(SignupAlunoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
