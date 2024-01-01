package com.myportfolio.user.dtos;

import com.myportfolio.user.enums.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}

