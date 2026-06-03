package com.floriano.com.floriano.tcc_tracker_api.domain.user;

public record RegisterDto(String email, String password, UserRole role) {
}
