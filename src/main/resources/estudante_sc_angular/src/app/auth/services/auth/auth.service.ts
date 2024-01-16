<<<<<<< HEAD
import { HttpClient, HttpHeaders } from "@angular/common/http";
=======
import { HttpClient } from "@angular/common/http";
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

const BASE_URL = ["http://localhost:8080"];

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  constructor(private http: HttpClient) { }

  registerAluno(signupAlunoRequest: any): Observable<any> {
<<<<<<< HEAD
    const httpOptions = {headers: new HttpHeaders({
      "Content-type": "application/json"
    })}
    return this.http.post(BASE_URL+"/student/register-submit", signupAlunoRequest, httpOptions);
  }
}
=======
    return this.http.post(BASE_URL+"/api", signupAlunoRequest);
  }
}
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
