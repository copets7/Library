package by.itstep.service;
import by.itstep.dto.UserDto;
import by.itstep.models.User;
import java.util.List;


public interface UserService  {

    List<User> findAll();

    User findById(int id) ;

    User save(User user) ;

    boolean saveDto(UserDto userDto);

    User update(User user);

    void delete(User user);

    void deleteById(int id);

    UserDto userToDto(User user);

}
