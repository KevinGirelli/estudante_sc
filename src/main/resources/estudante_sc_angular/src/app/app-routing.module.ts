import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './auth/components/signup/signup.component';
import { LoginComponent } from './auth/components/login/login.component';
import { SignupAlunoComponent } from './auth/components/signup/signup-aluno/signup-aluno/signup-aluno.component';
import { SignupProfessorComponent } from './auth/components/signup/signup-professor/signup-professor/signup-professor.component';
import { SignupEscolaComponent } from './auth/components/signup/signup-escola/signup-escola/signup-escola.component';

const routes: Routes = [
  { path: 'register', component: SignupComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register/aluno', component: SignupAlunoComponent },
  { path: 'register/professor', component: SignupProfessorComponent },
  { path: 'register/escola', component: SignupEscolaComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'student', loadChildren: () => import("./modules/student/student.module").then(m => m.StudentModule) },
  { path: 'teacher', loadChildren: () => import("./modules/teacher/teacher.module").then(m => m.TeacherModule) },
  { path: 'school', loadChildren: () => import("./modules/school/school.module").then(m => m.SchoolModule) },
  { path: 'admin', loadChildren: () => import("./modules/admin/admin.module").then(m => m.AdminModule) },

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
