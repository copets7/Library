package by.itstep.controllers.impl;

import by.itstep.controllers.StatusController;
import by.itstep.models.Status;
import by.itstep.service.StatusService;
import by.itstep.service.impl.StatusServiceImpl;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class StatusControllerImpl implements StatusController {

    private final StatusService statusService;

    public StatusControllerImpl(StatusService statusService) {
        this.statusService = statusService;
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
