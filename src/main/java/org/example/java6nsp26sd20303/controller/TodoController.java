package org.example.java6nsp26sd20303.controller;

import lombok.RequiredArgsConstructor;
import org.example.java6nsp26sd20303.entity.Todo;
import org.example.java6nsp26sd20303.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
