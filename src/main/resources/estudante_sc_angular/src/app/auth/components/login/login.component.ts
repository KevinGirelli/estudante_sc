import { HttpClient } from '@angular/common/http';
import { Component} from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { AuthService } from 'src/app/auth/services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  isSpinning: boolean = false;
  loginForm!: FormGroup;
  selectedDate: string = '';

  constructor(private fb: FormBuilder,
    private authService: AuthService) {}

    ngOnInit() {
      this.loginForm = this.fb.group({
        email: [null, Validators.required],
        password: [null, Validators.required]
      })
    }

    login(){
      console.log(this.loginForm.value);
      this.authService.login(JSON.stringify(this.loginForm.value)).subscribe((res) => {
        console.log(JSON.parse(res));
    });
  }
}
