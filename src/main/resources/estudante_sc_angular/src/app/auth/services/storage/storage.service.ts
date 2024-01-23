import { Injectable } from '@angular/core';

const TOKEN = "token";
const USER = "user";


@Injectable({
  providedIn: 'root'
})
export class StorageService {
  static logout() {
    throw new Error('Method not implemented.');
  }

  constructor() { }

  static saveToken(token: string): void {
    window.localStorage.removeItem(TOKEN);
    window.localStorage.setItem(TOKEN, token);
  }

  static saveUser(user: any): void {
    window.localStorage.removeItem(USER);
    window.localStorage.setItem(USER, JSON.stringify(USER));
  }

  static getToken(){
    return window.localStorage.getItem(TOKEN);
  }

  static getUser(){
    const userString = window.localStorage.getItem(USER);
    return userString ? JSON.parse(userString) : null;
  }

  static getUserRole(): string {
    const user = this.getUser();
    if(user == null) return "";
    return user.role;
  }
  
  static isStudentLoggedIn(): boolean{
    if(this.getToken() == null) return false;
    const role: String = this.getUserRole();
    return role == "ALUNO";
  }
  
  static isTeacherLoggedIn(): boolean{
    if(this.getToken() == null) return false;
    const role: String = this.getUserRole();
    return role == "PROFESSOR";
  }

  static isSchoolLoggedIn(): boolean{
    if(this.getToken() == null) return false;
    const role: String = this.getUserRole();
    return role == "ESCOLA";
  }

  static isAdminLoggedIn(): boolean{
    if(this.getToken() == null) return false;
    const role: String = this.getUserRole();
    return role == "ADMIN";
  }
}
