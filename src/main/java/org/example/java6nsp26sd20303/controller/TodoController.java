package org.example.java6nsp26sd20303.controller;

import lombok.RequiredArgsConstructor;
import org.example.java6nsp26sd20303.entity.Todo;
import org.example.java6nsp26sd20303.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/todos")
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos (){

        return todoService.findAll();
    }

    // api/todos/id
    @GetMapping("{id}")
    public Todo getTodo(@PathVariable long id) {

        return todoService.findById(id);
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {

        return todoService.add(todo);
    }

    @PutMapping("{id}")
    public Todo updateTodo(@RequestBody Todo todo, @PathVariable long id) {

        return todoService.update(todo, id);
    }

    @DeleteMapping("{id}")
    public Todo deleteTodo(@PathVariable long id) {

        return todoService.delete(id);
    }
}
