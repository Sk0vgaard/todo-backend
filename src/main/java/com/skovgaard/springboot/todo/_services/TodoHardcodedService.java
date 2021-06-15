package com.skovgaard.springboot.todo._services;

import com.skovgaard.springboot.todo._models.TodoModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoHardcodedService {

    private static List<TodoModel> todos = new ArrayList<>();

    static {
        todos.add(new TodoModel(UUID.randomUUID().toString(), "Skovgaard", "Finish this course", new Date(), false));
        todos.add(new TodoModel(UUID.randomUUID().toString(), "Rikke", "Cleaning", new Date(System.currentTimeMillis() / 1000), true));
        todos.add(new TodoModel(UUID.randomUUID().toString(), "Leonora", "Walk the dog", new Date(System.currentTimeMillis() / 500), false));
        todos.add(new TodoModel(UUID.randomUUID().toString(), "Elvira", "Change diaper", new Date(System.currentTimeMillis() / 200), true));
    }

    public List<TodoModel> findAll() {
        return todos;
    }

    public TodoModel deleteById(String id) {
        TodoModel todo = findById(id);

        if (todo != null) {
            todos.remove(todo);
            return todo;
        } else {
            return null;
        }
    }

    public TodoModel findById(String id) {
        for(TodoModel todo: todos) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

}
