package com.teefactory.demo.dto;

import com.teefactory.demo.roles.UserRole;

public record RegisterRequestDTO(String login, String password, UserRole role) {
}
