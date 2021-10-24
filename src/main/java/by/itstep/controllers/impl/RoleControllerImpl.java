package by.itstep.controllers.impl;

import by.itstep.controllers.RoleController;
import by.itstep.models.Role;
import by.itstep.service.impl.RoleServiceImpl;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RoleControllerImpl implements RoleController {

    private final RoleServiceImpl roleService;

    public RoleControllerImpl(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @Override
    public List<Role> findAll() {
        return roleService.findAll();
    }
    @Override
    public Role findById(int id) {
        Role role = roleService.findById(id);
        return role;
    }

    @Override
    public Role save(Role role) {
        return roleService.save(role);
    }

    @Override
    public Role update(Role role) {
        return roleService.update(role);
    }

    @Override
    public void delete(Role role) {
        roleService.delete(role);
    }

    @Override
    public void deleteById(int id) {
        roleService.deleteById(id);
    }
}
