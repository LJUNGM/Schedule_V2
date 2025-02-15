package com.example.schedulev2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String username;

    private final String email;

    private final String password;

    private final LocalDateTime createdAt;

    private final LocalDateTime modifiedAt;

    public UserResponseDto(Long id, String username, String email, String password,LocalDateTime createdAt,LocalDateTime modifiedAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
