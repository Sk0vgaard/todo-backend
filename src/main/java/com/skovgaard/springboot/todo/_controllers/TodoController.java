package com.skovgaard.springboot.todo._controllers;

import com.skovgaard.springboot.todo._models.TodoModel;
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
    public TodoModel getTodo(@PathVariable String username, @PathVariable String id) {
        return todoHardcodedService.findById(id);
    }

    @GetMapping("/users/{username}/todos")
    public List<TodoModel> getAllTodos(@PathVariable String username) {
        return todoHardcodedService.findAll();
    }

    @PutMapping("/users/{username}/todos")
    public TodoModel createTodo(@PathVariable String username) {
        return (TodoModel) todoHardcodedService.findAll();
    }

    @PostMapping("/users/{username}/todos/{id}")
    public TodoModel updateTodo(@PathVariable String username, @PathVariable String id) {
        return todoHardcodedService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public Optional<TodoModel> deleteTodo(
        @PathVariable String username,
        @PathVariable String id
    ) {
        return ofNullable(todoHardcodedService.deleteById(id));
    }
}
