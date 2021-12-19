package by.itstep.controllers;

import by.itstep.exception.UserNotFoundException;
import by.itstep.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserController {

    List<User> findAll();

    User findById(int id) throws UserNotFoundException;

    User save(User user);

    User update(User user);

    void delete(User user);

    void deleteById(int id);
}
