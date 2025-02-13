package com.example.schedulev2.service;

import com.example.schedulev2.dto.UserRequestDto;
import com.example.schedulev2.dto.UserResponseDto;
import com.example.schedulev2.entity.User;
import com.example.schedulev2.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto createUser(String username, String email, String password) {
        User user = new User(username,email,password);
        User savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser.getId(),savedUser.getUsername(),savedUser.getEmail(),savedUser.getPassword(),savedUser.getCreateAt(),savedUser.getModifiedAt());
    }

    @Transactional
    public UserResponseDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return new UserResponseDto(user.getId(),user.getUsername(),user.getEmail(),user.getPassword(),user.getCreateAt(),user.getModifiedAt());
    }

    @Transactional
    public UserResponseDto modifiedUser(Long id, UserRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow();
        user.modify(requestDto.getUsername(),requestDto.getEmail(),requestDto.getPassword());
        return new UserResponseDto(user.getId(),user.getUsername(),user.getEmail(),user.getPassword(),user.getCreateAt(),user.getModifiedAt());
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
