package edu.desafiofinal.bootcampclaro.service;

import java.util.List;

import edu.desafiofinal.bootcampclaro.model.Todo;

public interface TodoService {
    
    List<Todo> findAll();

    Todo findById(Long id);

    Todo create(Todo todoToCreate);

    void delete(Long id);

    Todo changeDone(Long id);
}
