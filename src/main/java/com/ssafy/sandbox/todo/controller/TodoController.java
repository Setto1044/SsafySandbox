package com.ssafy.sandbox.todo.controller;

import com.ssafy.sandbox.todo.response.GetResponseEntity;
import com.ssafy.sandbox.todo.response.PostResponseEntity;
import com.ssafy.sandbox.todo.domain.Todo;
import com.ssafy.sandbox.todo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public ResponseEntity<GetResponseEntity> selectAll() {
        GetResponseEntity responseEntity = new GetResponseEntity(service.findAll());
        logger.info(">> Serialized Response: {}", responseEntity);
        return ResponseEntity.ok(responseEntity);
    }

    @PostMapping("/todos")
    public ResponseEntity<PostResponseEntity> insertTodo(@RequestBody Todo todoVo) {
        Todo todo = service.insertTodo(todoVo);
        return ResponseEntity.ok(new PostResponseEntity(todo.getId(), todo.isCompleted()));
    }

    @DeleteMapping("/todos/{todoId}")
    public ResponseEntity<Void> delete(@PathVariable int todoId) {
        service.deleteById(todoId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/todos/{todoId}")
    public ResponseEntity<Void> fetch(@PathVariable int todoId) {
        service.updateTodo(todoId);
        return ResponseEntity.noContent().build();
    }
}