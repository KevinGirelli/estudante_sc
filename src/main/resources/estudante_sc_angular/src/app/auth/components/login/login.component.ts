import { HttpClient } from '@angular/common/http';
import { Component} from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { AuthService } from 'src/app/auth/services/auth/auth.service';
import { StorageService } from '../../services/storage/storage.service';

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
    private authService: AuthService,
    private router: Router,
    private message: NzMessageService) {}

    ngOnInit() {
      this.loginForm = this.fb.group({
        email: [null, Validators.required],
        password: [null, Validators.required]
      })
    }

    login(){
      this.authService.login(JSON.stringify(this.loginForm.value)).subscribe((res) => {
        console.log(res);
        if(res.userId != null) {
          const user = {
            id: res.userId,
            role: res.userRole
          }
          StorageService.saveUser(user);
          StorageService.saveToken(res.jwt);
          if (StorageService.isStudentLoggedIn()) {
            this.router.navigateByUrl("/student/dashboard")
          } else if (StorageService.isTeacherLoggedIn()) {
            this.router.navigateByUrl("/teacher/dashboard")
          } else if (StorageService.isSchoolLoggedIn()) {
            this.router.navigateByUrl("/school/dashboard")
          } else if (StorageService.isAdminLoggedIn()) {
            this.router.navigateByUrl("/admin/dashboard")
          } else {
            this.message.error("Bad credentials", { nzDuration: 5000 });
          }
        }
        console.log(JSON.parse(res));
    });
  }
}
