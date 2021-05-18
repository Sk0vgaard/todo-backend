package com.skovgaard.springboot.todo;

import com.skovgaard.springboot.todo._services.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@RestController
public class TodoWebservice {

    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoHardcodedService.findAll();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public Optional<Todo> deleteTodo(
        @PathVariable String username,
        @PathVariable String id
    ) {
        return ofNullable(todoHardcodedService.deleteById(id));
    }
}
