package by.itstep.controllers.rest;


import by.itstep.dto.UserDto;
import by.itstep.models.User;
import by.itstep.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Метод находит всех пользователей")
    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    public ResponseEntity <List<User>> findAllUsers() {
        List<User> users = userService.findAll();

        return users != null &&  !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод добавляет нового пользователя")
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity saveUser(@RequestBody  User user) {
        userService.save(user);
        return  user!= null
                ? new ResponseEntity<>(user , HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ApiOperation(value = "Метод находит одного пользователя")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getOneUser(@PathVariable("id") int userId) {
        final User user = this.userService.findById(userId);
        UserDto userDto = userService.userToDto(user);
        return userDto != null
                ? new ResponseEntity<>(userDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод редактирует пользователя")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userService.save(user);
        return user != null
                ? new ResponseEntity<>(user , HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод удаляет пользователя")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable int id){
        final User user = this.userService.findById(id);
        userService.delete(user);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
