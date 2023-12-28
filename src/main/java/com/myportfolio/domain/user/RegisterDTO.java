package com.myportfolio.domain.user;

public record RegisterDTO(String email, String password, UserRole role) {
}

