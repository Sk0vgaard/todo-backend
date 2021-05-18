package com.skovgaard.springboot.todo._services;

import com.skovgaard.springboot.todo.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(UUID.randomUUID().toString(), "Skovgaard", "Finish this course", new Date(), false));
        todos.add(new Todo(UUID.randomUUID().toString(), "Rikke", "Cleaning", new Date(), false));
        todos.add(new Todo(UUID.randomUUID().toString(), "Leonora", "Walk the dog", new Date(), false));
        todos.add(new Todo(UUID.randomUUID().toString(), "Elvira", "Change diaper", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos;
    }

}
