package by.itstep.controllers.impl;

import by.itstep.controllers.StatusController;
import by.itstep.models.Role;
import by.itstep.models.Status;
import by.itstep.service.StatusService;
import by.itstep.service.impl.StatusServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/status")
public class StatusControllerImpl implements StatusController {

    private final StatusService statusService;

    public StatusControllerImpl(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("status", statusService.findAll());
        return "status/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("status", statusService.findById(id));
        return "status/show";
    }

    @GetMapping("/new")
    public String newStatus(@ModelAttribute("status") Status status) {
        return "status/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("status") Status status) {
        statusService.save(status);
        return "redirect:/status";
    }

    @GetMapping("delete/{id}")
    public String deleteStatus(@PathVariable("id") int id) {
        statusService.deleteById(id);
        return "redirect:/status";
    }

    @GetMapping("edit/{id}")
    public String updateStatusForm(@PathVariable("id") int id, Model model) {
        Status status = statusService.findById(id);
        model.addAttribute("status", status);
        return "status/edit";
    }

    @PostMapping("/edit")
    public String updateStatus(Status status) {
        statusService.save(status);
        return "redirect:/status";
    }

    @Override
    public List<Status> findAll() {
        return statusService.findAll();
    }

    @Override
    public Status findById(int id) {
        return statusService.findById(id);
    }

    @Override
    public Status save(Status status) {
        return statusService.save(status);
    }

    @Override
    public Status update(Status status) {
        return statusService.update(status);
    }

    @Override
    public void delete(Status status) {
        statusService.delete(status);
    }

    @Override
    public void deleteById(int id) {
        statusService.deleteById(id);
    }
}
