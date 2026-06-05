package com.floriano.com.floriano.tcc_tracker_api.dto;

import com.floriano.com.floriano.tcc_tracker_api.model.user.UserRole;

public record RegisterDto(String email, String password, UserRole role) {
}
