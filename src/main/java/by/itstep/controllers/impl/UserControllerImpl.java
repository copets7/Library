package by.itstep.controllers.impl;

import by.itstep.controllers.UserController;
import by.itstep.models.User;
import org.springframework.stereotype.Controller;
import by.itstep.service.impl.UserServiceImpl;

import java.util.List;

@Controller
public class UserControllerImpl implements UserController {

   private final UserServiceImpl userService;

    public UserControllerImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public User findById(int id) {
        return userService.findById(id);
    }

    @Override
    public User save(User user) {
        return userService.save(user);
    }

    @Override
    public User update(User user) {
        return userService.update(user);
    }

    @Override
    public void delete(User user) {
    userService.delete(user);
    }

    @Override
    public void deleteById(int id) {
    userService.deleteById(id);
    }
}
