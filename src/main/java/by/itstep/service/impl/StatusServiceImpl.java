package by.itstep.service.impl;

import by.itstep.models.Status;
import by.itstep.repository.StatusRepository;
import by.itstep.service.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(int id) {
        return statusRepository.findById(id).get();
    }

    @Override
    public Status save(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public Status update(Status status) {
        return statusRepository.saveAndFlush(status);
    }

    @Override
    public void delete(Status status) {
        statusRepository.delete(status);
    }

    @Override
    public void deleteById(int id) {
        statusRepository.deleteById(id);
    }
}
