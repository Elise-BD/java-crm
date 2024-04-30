package com.example.javacrm.pl.models;

import com.example.javacrm.dal.enums.Role;

public record RegisterForm(
        Role role,
        String username,
        String password
) {
}
