package by.itstep.service.impl;

import by.itstep.models.Role;
import by.itstep.repository.RoleRepository;
import by.itstep.service.RoleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

   private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
    @Override
    public Role findById(int id){
       return roleRepository.findById(id).get();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }
}
