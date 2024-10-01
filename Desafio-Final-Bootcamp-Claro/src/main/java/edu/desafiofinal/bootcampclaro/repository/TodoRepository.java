package edu.desafiofinal.bootcampclaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.desafiofinal.bootcampclaro.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
