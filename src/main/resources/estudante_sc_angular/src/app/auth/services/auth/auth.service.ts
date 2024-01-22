import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { FormGroup } from "@angular/forms";
import { Observable } from "rxjs";

const BASE_URL = ["http://localhost:8080"];

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  constructor(private http: HttpClient) { }

  registerAluno(signupAlunoRequest: any): Observable<any> {
    const httpOptions = {headers: new HttpHeaders({
      "Content-type": "application/json"
    })}
    return this.http.post(BASE_URL+"/student/register-submit", signupAlunoRequest, httpOptions);
  }

  registerProfessor(signupProfessorRequest: any): Observable<any> {
    const httpOptions = {headers: new HttpHeaders({
      "Content-type": "application/json"
    })}
    return this.http.post(BASE_URL+"professor url", signupProfessorRequest, httpOptions);
  }

  registerEscola(signupEscolaRequest: any): Observable<any> {
    const httpOptions = {headers: new HttpHeaders({
      "Content-type": "application/json"
    })}
    return this.http.post(BASE_URL+"escola url", signupEscolaRequest, httpOptions);
  }

  login(loginRequest: String): Observable<any> {
    const httpOptions = {headers: new HttpHeaders({
      "Content-type": "application/json"
    })}

    return this.http.post(BASE_URL+"/login/login-submit", loginRequest, httpOptions);
  }
}
