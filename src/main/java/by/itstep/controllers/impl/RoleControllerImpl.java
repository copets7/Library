package by.itstep.controllers.impl;

import by.itstep.controllers.RoleController;
import by.itstep.models.Role;
import by.itstep.models.User;
import by.itstep.service.impl.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleControllerImpl implements RoleController {

    private final RoleServiceImpl roleService;

    public RoleControllerImpl(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }



    @GetMapping()
    public String index(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "role/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("role", roleService.findById(id));
        return "role/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("role") Role role) {
        return "role/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("role") Role role) {
        roleService.save(role);
        return "redirect:/role";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id")int id){
        roleService.deleteById(id);
        return "redirect:/role";
    }

    @GetMapping("edit/{id}")
    public String updateUserForm(@PathVariable("id") int id ,Model model){
        Role role = roleService.findById(id);
        model.addAttribute("role",role);
        return "role/edit";
    }

    @PostMapping("/edit")
    public String updateUser(Role role){
        roleService.save(role);
        return "redirect:/role";
    }


    @Override
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleService.findById(id);
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
