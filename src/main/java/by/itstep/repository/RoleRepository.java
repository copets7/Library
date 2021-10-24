package by.itstep.repository;

import by.itstep.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findAll();

    Role save(Role role);

    void delete(Role role);
}
