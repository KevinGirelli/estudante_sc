import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
  constructor(private router: Router) {}

  navigateTo(option: string): void {
    switch (option) {
      case 'aluno':
        this.router.navigate(['/register/aluno']);
        break;
      case 'professor':
        this.router.navigate(['/register/professor']);
        break;
      case 'escola':
        this.router.navigate(['/register/escola']);
        break;
    }
  }
}
