package com.example.javacrm.pl.models;

import com.example.javacrm.dal.enums.Role;
import lombok.Builder;

@Builder
public record AuthDTO(
        String username,
        String token,
        Role role
) {
}
