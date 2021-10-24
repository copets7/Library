package by.itstep.controllers;

import by.itstep.models.Role;

import java.util.List;

public interface RoleController {

    List<Role> findAll();

    Role findById(int id);

    Role save(Role role);

    Role update (Role role);

    void delete(Role role);

    void deleteById(int id);
}
