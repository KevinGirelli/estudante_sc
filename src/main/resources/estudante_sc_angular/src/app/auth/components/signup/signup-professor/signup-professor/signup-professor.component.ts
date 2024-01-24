import { HttpClient, HttpContext } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { AuthService } from 'src/app/auth/services/auth/auth.service';

@Component({
  selector: 'app-signup-professor',
  templateUrl: './signup-professor.component.html',
  styleUrls: ['./signup-professor.component.scss']
})
export class SignupProfessorComponent implements OnInit{

  isSpinning: boolean = false;
  signupForm!: FormGroup;
  selectedDate: string = '';

  constructor(private fb: FormBuilder,
    private authService: AuthService,
    private message: NzMessageService,
    private router: Router) {}


  ngOnInit() {
    this.signupForm = this.fb.group({
      email: [null, [Validators.required]],
      password: [null, [Validators.required]],
      fullName: [null, [Validators.required]],
      cpf: [null, [Validators.required]],
      age: [null, [Validators.required]],

      //Endereço
      zipCode: [null, [Validators.required]],
      number: [null, [Validators.required]],
      city: [null, [Validators.required]],
      state: [null, [Validators.required]],
      complement: [null,[Validators.required]]
    })
  }

  register() {
    console.log(this.signupForm.value);
    this.authService.registerProfessor(JSON.stringify(this.signupForm.value)).subscribe((res) => {
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
