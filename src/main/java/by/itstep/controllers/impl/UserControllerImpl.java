package by.itstep.controllers.impl;

import by.itstep.controllers.UserController;
import by.itstep.models.Role;
import by.itstep.models.User;
import by.itstep.service.RoleService;
import by.itstep.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

  private final UserService userService;
  private final RoleService roleService;

    public UserControllerImpl(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping()
        public String index(Model model) {
            model.addAttribute("users", userService.findAll());
            return "user/index";
        }

        @GetMapping("/{id}")
        public String show(@PathVariable("id") int id, Model model) {
            model.addAttribute("user", userService.findById(id));
            return "user/show";
        }

        @GetMapping("/new")
        public String newUser( @ModelAttribute("user") User user,  Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "user/new";
    }

      @PostMapping()
      public String create(@ModelAttribute("user") User user,@RequestParam("id") int id) {
        user.setRole(roleService.findById(id));
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id")int id){
        userService.deleteById(id);
        return "redirect:/user";
    }

    @GetMapping("edit/{id}")
    public String updateUserForm(@PathVariable("id") int id ,Model model){
        model.addAttribute("roles", roleService.findAll());
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "user/edit";
    }

    @PostMapping("/edit")
    public String updateUser(User user,@RequestParam("role.id") int roleId){
        user.setRole(roleService.findById(roleId));
        userService.save(user);
        return "redirect:/user";
    }


    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public User findById(int id) {
        return userService.findById(id);
    }

    @Override
    public User save(User user) {
        return userService.save(user);
    }

    @Override
    public User update(User user) {
        return userService.update(user);
    }

    @Override
    public void delete(User user) {
    userService.delete(user);
    }

    @Override
    public void deleteById(int id) {
    userService.deleteById(id);
    }
}
