package by.itstep.service;
import by.itstep.models.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    User save(User user);

    User update(User user);

    void delete(User user);

    void deleteById(int id);
}
