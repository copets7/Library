package by.itstep.service;

import by.itstep.models.Role;
import by.itstep.models.User;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findById(int id);

    Role save(Role role);

    Role update (Role role);

    void delete(Role role);

    void deleteById(int id);
}
