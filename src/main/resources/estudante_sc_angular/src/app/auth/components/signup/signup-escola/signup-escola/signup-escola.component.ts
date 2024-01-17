import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup-escola',
  templateUrl: './signup-escola.component.html',
  styleUrls: ['./signup-escola.component.scss']
})
export class SignupEscolaComponent {

  isSpinning: boolean = false;
  signupForm!: FormGroup;
  selectedDate: string = '';

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.signupForm = this.fb.group({
      schoolName: [null, [Validators.required]],
      email: [null, [Validators.required]],
      password: [null, [Validators.required]],
      phoneNumber: [null, [Validators.required]],
      directorsName: [null, [Validators.required]],
      directorsCPF: [null, [Validators.required]],
      directorsPhoneNumber: [null, [Validators.required]]
    })
  }

  register() {
    console.log(this.signupForm.value);
  }
}