package edu.desafiofinal.bootcampclaro.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import edu.desafiofinal.bootcampclaro.model.Todo;
import edu.desafiofinal.bootcampclaro.repository.TodoRepository;
import edu.desafiofinal.bootcampclaro.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl (TodoRepository todoRepository) {
        this.todoRepository = todoRepository;        
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Todo create(Todo todoToCreate) {
        return todoRepository.save(todoToCreate);
    }

    @Override
    public void delete(Long id) {
        var todo = todoRepository.findById(id).orElseThrow(NoSuchElementException::new);
        todoRepository.delete(todo);
    }

    @Override
    public Todo changeDone(Long id) {
        Todo todoToChange = todoRepository.findById(id).orElseThrow(NoSuchElementException::new);
        todoToChange.setDone(!todoToChange.getDone());
        todoRepository.save(todoToChange);
        return todoToChange;
    }
    
}
