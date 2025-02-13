package com.example.schedulev2.controller;

import com.example.schedulev2.dto.UserRequestDto;
import com.example.schedulev2.dto.UserResponseDto;
import com.example.schedulev2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        UserResponseDto userRequestDto = userService.createUser(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());
        return new ResponseEntity<>(userRequestDto, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserResponseDto> findUserByID(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findUserById(id);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<UserResponseDto> modifyUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.modifiedUser(id, userRequestDto));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
