package com.example.schedulev2.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private final Long id;

    public LoginResponseDto(Long id){
        this.id = id;
    }
}
