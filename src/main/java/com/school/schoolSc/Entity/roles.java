package com.school.schoolSc.Entity;

public enum roles {
  student("STUDENT"),
  teacher("TEACHER"),
  admin("ADMIN");

  private String role;

  roles(String role){
    this.role = role;
  }

  public String getRole() {
    return role;
  }
}
