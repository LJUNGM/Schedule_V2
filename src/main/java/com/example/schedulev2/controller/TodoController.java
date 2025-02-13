package com.example.schedulev2.controller;

import com.example.schedulev2.dto.TodoRequestDto;
import com.example.schedulev2.dto.TodoResponseDto;
import com.example.schedulev2.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        TodoResponseDto todoResponseDto = todoService.createTodo(todoRequestDto.getUsername(), todoRequestDto.getTitle(), todoRequestDto.getContents());
        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TodoResponseDto>findTodoById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.findTodoById(id));
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<TodoResponseDto> modifyTodo(@PathVariable Long id,@RequestBody TodoRequestDto todoRequestDto) {
        return ResponseEntity.ok(todoService.modifyTodo(id,todoRequestDto));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }
}
