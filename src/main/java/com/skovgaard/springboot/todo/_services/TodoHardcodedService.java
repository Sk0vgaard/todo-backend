package com.skovgaard.springboot.todo._services;

import com.skovgaard.springboot.todo.Todo;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Todo deleteById(String id) {
        Todo todo = findById(id);

        if (todo != null) {
            todos.remove(todo);
            return todo;
        } else {
            return null;
        }
    }

    public Todo findById(String id) {
        for(Todo todo: todos) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

}
