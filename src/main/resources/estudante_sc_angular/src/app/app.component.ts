import { Component } from '@angular/core';
import { StorageService } from './auth/services/storage/storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'estudante_sc_angular';

  isAdminLoggedIn:boolean=StorageService.isAdminLoggedIn();
  isStudentLoggedIn:boolean=StorageService.isStudentLoggedIn();
  isSchoolLoggedIn:boolean=StorageService.isSchoolLoggedIn();
  isTeacherLoggedIn:boolean=StorageService.isTeacherLoggedIn();

  constructor(private router: Router) { }

  ngOnInit() {
    this.router.events.subscribe(event => {
      if(event.constructor.name === "NavigationEnd"){
        this.isAdminLoggedIn = StorageService.isAdminLoggedIn();
        this.isStudentLoggedIn = StorageService.isStudentLoggedIn();
        this.isSchoolLoggedIn = StorageService.isSchoolLoggedIn();
        this.isTeacherLoggedIn = StorageService.isTeacherLoggedIn();
      }
    })
  }

  logout() {
    StorageService.logout();
    this.router.navigateByUrl("/login")
  }
}
