import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './auth/components/signup/signup.component';
import { LoginComponent } from './auth/components/login/login.component';
import { SignupAlunoComponent } from './auth/components/signup/signup-aluno/signup-aluno/signup-aluno.component';
import { SignupProfessorComponent } from './auth/components/signup/signup-professor/signup-professor/signup-professor.component';
import { SignupEscolaComponent } from './auth/components/signup/signup-escola/signup-escola/signup-escola.component';

const routes: Routes = [
  { path: "register", component: SignupComponent },
  { path: "login", component: LoginComponent },
  { path: 'register/aluno', component: SignupAlunoComponent },
  { path: 'register/professor', component: SignupProfessorComponent },
  { path: 'register/escola', component: SignupEscolaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
