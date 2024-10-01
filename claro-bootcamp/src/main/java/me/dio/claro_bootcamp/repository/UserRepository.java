package me.dio.claro_bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.claro_bootcamp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
