package edu.desafiofinal.bootcampclaro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.desafiofinal.bootcampclaro.model.Todo;
import edu.desafiofinal.bootcampclaro.service.TodoService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> todos = todoService.findAll();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(Long id) {
        Todo todo = todoService.findById(id);
        return ResponseEntity.ok(todo);
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo){
        var todoCreated = todoService.create(todo);
        return ResponseEntity.ok(todoCreated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        todoService.delete(id);
        // return ResponseEntity.ok("Deletado");
    }   

    @PutMapping("/{id}")
    public ResponseEntity<Todo> changeDoneTodo(@PathVariable Long id) {
        Todo todo = todoService.changeDone(id);
        return ResponseEntity.ok(todo);
    }
    
}
