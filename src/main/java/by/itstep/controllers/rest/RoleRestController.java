package by.itstep.controllers.rest;

import by.itstep.models.Role;
import by.itstep.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@Api(value = "/roles")
public class RoleRestController {

    private final RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @ApiOperation(value = "Метод находит все роли")
    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    public ResponseEntity<List<Role>> findAllRole() {
        List<Role> roleList = roleService.findAll();

        return roleList != null &&  !roleList.isEmpty()
                ? new ResponseEntity<>(roleList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод добавляет новую роль")
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> saveRole(@RequestBody Role role) {
        roleService.save(role);
        return  role!= null
                ? new ResponseEntity<>(role , HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ApiOperation(value = "Метод находит одну роль")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Role> getOneRole(@PathVariable("id") int roleId) {
        final Role role = this.roleService.findById(roleId);
        return role != null
                ? new ResponseEntity<>(role, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод редактирует роль")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Role> updateRole(@RequestBody Role role){
        roleService.save(role);
        return role != null
                ? new ResponseEntity<>(role , HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод удаляет роль")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Role> deleteRole(@PathVariable int id){
        final Role role = this.roleService.findById(id);
        roleService.delete(role);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
