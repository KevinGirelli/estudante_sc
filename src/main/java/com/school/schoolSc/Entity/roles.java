package com.school.schoolSc.Entity;

public enum roles {
  STUDENT("STUDENT"),
  TEACHER("TEACHER"),
  ADMIN("ADMIN"),
  SCHOOL_ADMIN("SCHOOL_ADMIN");

  private String role;

  roles(String role){
    this.role = role;
  }

  public String getRole() {
    return role;
  }
}
