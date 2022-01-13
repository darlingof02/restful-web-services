package com.darlingof02.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {
    private static List<Todo> todos = new ArrayList<>();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(idCounter++, "darlingof02", "Learn React", new Date(), false));
        todos.add(new Todo(idCounter++, "darlingof02", "Learn Microservices" +
                "", new Date(), false));
        todos.add(new Todo(idCounter++, "darlingof02", "Learn Spring", new Date(), false));


    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1) {
            todo.setId(idCounter++);
            todos.add(todo);
        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if (todo == null)
            return null;
        if (todos.remove(todo))
            return todo;
        return null;
    }

    public Todo findById(long id) {
        for (Todo todo: todos)
            if (todo.getId() == id)
                return todo;
        return null;
    }
}
