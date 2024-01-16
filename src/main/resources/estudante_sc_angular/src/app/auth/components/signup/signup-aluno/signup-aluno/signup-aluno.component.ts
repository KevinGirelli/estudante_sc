<<<<<<< HEAD
import { HttpClient, HttpContext } from '@angular/common/http';
=======
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { AuthService } from 'src/app/auth/services/auth/auth.service';

@Component({
  selector: 'app-signup-aluno',
  templateUrl: './signup-aluno.component.html',
  styleUrls: ['./signup-aluno.component.scss']
})
export class SignupAlunoComponent implements OnInit {

  isSpinning: boolean = false;
  signupForm!: FormGroup;
  selectedDate: string = '';

<<<<<<< HEAD
  constructor(private fb: FormBuilder,
=======
  constructor(private fb: FormBuilder, 
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
              private authService: AuthService,
              private message: NzMessageService,
              private router: Router) {}

  ngOnInit() {
    this.signupForm = this.fb.group({
<<<<<<< HEAD
      state: [null, [Validators.required]],
      city: [null, [Validators.required]],
      zipCode: [null, [Validators.required]],
      complement: [null, [Validators.required]],
      number: [null, [Validators.required]],
      // Aluno
      email: [null, [Validators.required]],
      password: [null, [Validators.required]],
      fullName: [null, [Validators.required]],
      cpf: [null, [Validators.required]],
      age: [null, [Validators.required]],
      parentName: [null, [Validators.required]],
      parentCPF: [null, [Validators.required]],
      parentPhoneNumber: [null, [Validators.required]],
      
=======
      nome: [null, [Validators.required]],
      email: [null, [Validators.required]],
      cpf: [null, [Validators.required]],
      dataNasc: [null, [Validators.required]],
      password: [null, [Validators.required]],
      // Responsável
      nomePai: [null, [Validators.required]],
      cpfPai: [null, [Validators.required]],
      phonePai: [null, [Validators.required]],
      // Endereço
      estado: [null, [Validators.required]],
      cidade: [null, [Validators.required]],
      cep: [null, [Validators.required]],
      numeroResidencial: [null, [Validators.required]],
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
    });
  }

  register() {
    console.log(this.signupForm.value);
<<<<<<< HEAD
    this.authService.registerAluno(JSON.stringify(this.signupForm.value)).subscribe((res) => {
      console.log(res);
      if (res != null) {
=======
    this.authService.registerAluno(this.signupForm.value).subscribe((res) => {
      console.log(res);
      if (res.id != null) {
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
        this.message.success("Signup successful", { nzDuration: 5000 });
        this.router.navigateByUrl("/login");
      } else {
        this.message.error("Something went wrong", { nzDuration: 5000 });
      }
    });
  }
}
