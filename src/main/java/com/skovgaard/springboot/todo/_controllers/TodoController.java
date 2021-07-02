package com.skovgaard.springboot.todo._controllers;

import com.skovgaard.springboot.todo._models.Todo;
import com.skovgaard.springboot.todo._services.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@RestController
public class TodoController {

    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable String id) {
        return todoHardcodedService.findById(id);
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoHardcodedService.findAll();
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodo(@PathVariable String username) {
        return (Todo) todoHardcodedService.findAll();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username, @PathVariable String id) {
        return todoHardcodedService.findById(id);
    }

    @DeleteMapping("/users/todos/{id}")
    public Optional<Todo> deleteTodo(
        @PathVariable String id
    ) {
        return ofNullable(todoHardcodedService.deleteById(id));
    }
}
