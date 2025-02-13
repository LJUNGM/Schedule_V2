package com.example.schedulev2.service;

import com.example.schedulev2.dto.TodoRequestDto;
import com.example.schedulev2.dto.TodoResponseDto;
import com.example.schedulev2.entity.Todo;
import com.example.schedulev2.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public TodoResponseDto createTodo(TodoRequestDto todoRequestDto) {
        Todo todo = new Todo(todoRequestDto.getUsername(),todoRequestDto.getTitle(),todoRequestDto.getContents());
        Todo savedTodo = todoRepository.save(todo);
        return new TodoResponseDto(savedTodo.getId(),savedTodo.getUsername(),savedTodo.getTitle(),savedTodo.getContents(),savedTodo.getCreateAt(),savedTodo.getModifiedAt());
    }

    @Transactional
    public TodoResponseDto findTodoById(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow();
        return new TodoResponseDto(todo.getId(),todo.getUsername(),todo.getTitle(),todo.getContents(),todo.getCreateAt(),todo.getModifiedAt());
    }

    @Transactional
    public TodoResponseDto modifyTodo(Long id, TodoRequestDto todoRequestDto) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.modify(todoRequestDto.getUsername(),todoRequestDto.getTitle(),todoRequestDto.getContents());
        return new TodoResponseDto(todo.getId(),todo.getUsername(),todo.getTitle(),todo.getContents(),todo.getCreateAt(),todo.getModifiedAt());
    }

    @Transactional
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
