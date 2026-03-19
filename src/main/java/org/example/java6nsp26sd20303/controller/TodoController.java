package org.example.java6nsp26sd20303.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.java6nsp26sd20303.entity.Todo;
import org.example.java6nsp26sd20303.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/todos")
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>>  getAllTodos (){

        List<Todo> todos = todoService.findAll();

        //return new ResponseEntity<>(todos, HttpStatus.OK);

        //return ResponseEntity.ok(todos);

        //return ResponseEntity.status(HttpStatus.OK).body(todos);

        return ResponseEntity
                .ok()
                .header("Custom-Header", "Custom-Value")
                .body(todos);
    }

    // api/todos/id
    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable long id) {

        Todo todo = todoService.findById(id);

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@Valid @RequestBody Todo todo) {

        Todo savedTodo = todoService.add(todo);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> updateTodo(@Valid @RequestBody Todo todo, @PathVariable long id) {

        Todo updatedTodo = todoService.update(todo, id);

        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable long id) {

        Todo deletedTodo = todoService.delete(id);

        return new ResponseEntity<>(deletedTodo, HttpStatus.OK);
    }
}
