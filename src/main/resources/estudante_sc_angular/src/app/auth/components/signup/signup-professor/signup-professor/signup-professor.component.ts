import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup-professor',
  templateUrl: './signup-professor.component.html',
  styleUrls: ['./signup-professor.component.scss']
})
export class SignupProfessorComponent {

  isSpinning: boolean = false;
  signupForm!: FormGroup;
  selectedDate: string = '';

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.signupForm = this.fb.group({
      nome: [null, [Validators.required]],
      email: [null, [Validators.required]],
      cpf: [null, [Validators.required]],
      dataNasc: [null, [Validators.required]],
      password: [null, [Validators.required]],

      //Endereço
      estado: [null, [Validators.required]],
      cidade: [null, [Validators.required]],
      cep: [null, [Validators.required]],
      numeroResidencial: [null, [Validators.required]],
    })
  }

  register() {
    console.log(this.signupForm.value);
  }
}
