package com.floriano.com.floriano.tcc_tracker_api.model.user;

public enum UserRole {
    ADMIN("admin"),
    PROFESSOR("professor"),
    STUDENT("student");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
