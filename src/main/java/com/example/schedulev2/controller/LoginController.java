package com.example.schedulev2.controller;

import com.example.schedulev2.dto.LoginRequestDto;
import com.example.schedulev2.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    @RequestMapping("/check")
    private ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest httpServletRequest) {
        loginService.login(loginRequestDto.getEmail(),loginRequestDto.getPassword(),httpServletRequest);
        return ResponseEntity.ok("Login success");
    }
}
