package by.itstep.service;
import by.itstep.dto.UserDto;
import by.itstep.exception.UserAlreadyExistException;
import by.itstep.exception.UserNotFoundException;
import by.itstep.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    User findById(int id) throws UserNotFoundException;

   UserDetails loadUserByUsername(String userName);

    User save(User user) ;

    boolean saveDto(UserDto userDto);

    User update(User user);

    void delete(User user);

    void deleteById(int id);

    UserDto userToDto(User user);

}
