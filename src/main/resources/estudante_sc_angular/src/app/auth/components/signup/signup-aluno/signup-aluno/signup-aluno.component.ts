import { HttpClient, HttpContext } from '@angular/common/http';
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

  constructor(private fb: FormBuilder,
    private authService: AuthService,
    private message: NzMessageService,
    private router: Router) {}

  ngOnInit() {
    this.signupForm = this.fb.group({
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
      
    });
  }

  register() {
    console.log(this.signupForm.value);
    this.authService.registerAluno(JSON.stringify(this.signupForm.value)).subscribe((res) => {
      console.log(res);
      if (res != null) {
        this.message.success("Signup successful", { nzDuration: 5000 });
        this.router.navigateByUrl("/login");
      } else {
        this.message.error("Something went wrong", { nzDuration: 5000 });
      }
    });
  }
}
