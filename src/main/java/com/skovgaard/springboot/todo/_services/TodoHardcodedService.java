package com.skovgaard.springboot.todo._services;

import com.skovgaard.springboot.todo._models.Todo;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.skovgaard.springboot.todo._models.TodoStatus.*;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(UUID.randomUUID().toString(), "Skovgaard", "Finish this course", new Date(), false, AVAILABLE));
        todos.add(new Todo(UUID.randomUUID().toString(), "Rikke", "Cleaning", new Date(System.currentTimeMillis() / 1000), true, NOT_AVAILABLE));
        todos.add(new Todo(UUID.randomUUID().toString(), "Leonora", "Walk the dog", new Date(System.currentTimeMillis() / 500), false, CURRENTLY_DOING));
        todos.add(new Todo(UUID.randomUUID().toString(), "Elvira", "Change diaper", new Date(System.currentTimeMillis() / 200), true, READY));
    }

    public List<Todo> findAll() {
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
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
