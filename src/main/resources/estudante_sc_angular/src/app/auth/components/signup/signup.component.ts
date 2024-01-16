import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})

export class SignupComponent {
  constructor(private router: Router) {}

  navigateToAluno() {
    this.router.navigate(['/register/aluno']);
  }

  navigateToProfessor() {
    this.router.navigate(['/register/professor']);
  }

  navigateToEscola() {
    this.router.navigate(['/register/escola']);
  }
}