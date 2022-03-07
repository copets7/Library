package by.itstep.service;

import by.itstep.models.User;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class UserServiceTest {

    UserService userService = Mockito.mock(UserService.class);

    @Test
    public void findUserById(){
       List<User> userList = userService.findAll();
       assertTrue(userList.isEmpty());
    }
}
