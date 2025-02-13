package com.example.schedulev2.service;

import com.example.schedulev2.entity.User;
import com.example.schedulev2.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private UserRepository userRepository;

    public void login(String email, String password, HttpServletRequest httpServletRequest) {
        User user = userRepository.findUserByEmail(email);
        HttpSession session = httpServletRequest.getSession();
        httpServletRequest.setAttribute("userId", user.getId());
    }
}
