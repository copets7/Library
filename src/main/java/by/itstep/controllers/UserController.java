package by.itstep.controllers;

import by.itstep.models.User;

import java.util.List;
import java.util.Optional;

public interface UserController {
    List<User> findAll();

    User findById(int id);

    User save(User user);

    User update(User user);

    void delete(User user);

    void deleteById(int id);
}
