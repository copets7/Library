package by.itstep.service;
import by.itstep.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    User save(User user);

    User update(User user);

    void delete(User user);

    void deleteById(int id);

}
