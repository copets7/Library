package by.itstep.repository;

import by.itstep.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    User findFirstByUserName (String name);

    User save(User user);

    void delete(User user);



}
