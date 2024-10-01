package me.dio.claro_bootcamp.service;

import me.dio.claro_bootcamp.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
