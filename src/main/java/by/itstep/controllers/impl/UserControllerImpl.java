package by.itstep.controllers.impl;

import by.itstep.controllers.UserController;
import by.itstep.models.Role;
import by.itstep.models.User;
import org.springframework.stereotype.Controller;
import by.itstep.service.impl.UserServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

   private final UserServiceImpl userService;
    private RoleControllerImpl roleController;
    public UserControllerImpl(UserServiceImpl userService) {
        this.userService = userService;
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
        public String newPerson(@ModelAttribute("user") User user) {
        return "user/new";
    }

      @PostMapping()
      public String create(@ModelAttribute("user") User user,Model model) {
        List <Role> roles = roleController.findAll();
        model.addAttribute("role",roles);
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
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "user/edit";
    }

    @PostMapping("/edit")
    public String updateUser(User user){
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
