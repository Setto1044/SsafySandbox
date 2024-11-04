package com.ssafy.sandbox.todo.service;

import com.ssafy.sandbox.todo.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TodoService {
    public List<Todo> findAll();
    public Optional<Todo> findById(int id);
    public Todo insertTodo(Todo todo);
    public boolean deleteById(int id);
    public Todo updateTodo(int id);
}
