package com.example.schedulev2.service;

import com.example.schedulev2.dto.TodoRequestDto;
import com.example.schedulev2.dto.TodoResponseDto;
import com.example.schedulev2.entity.Todo;
import com.example.schedulev2.repository.TodoRepository;
import com.example.schedulev2.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public TodoResponseDto createTodo(String username, String title,String contents) {
        Todo todo = new Todo(username, title,contents);
        todoRepository.save(todo);
        return new TodoResponseDto(todo.getId(),todo.getUsername(),todo.getTitle(),todo.getContents(),todo.getCreateAt(),todo.getModifiedAt());
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
