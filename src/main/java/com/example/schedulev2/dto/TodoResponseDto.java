package com.example.schedulev2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {

    private final Long id;
    private final String username;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoResponseDto(Long id,String username,String title,String contents,LocalDateTime createdAt,LocalDateTime modifiedAt) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
