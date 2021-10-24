package by.itstep.service;

import by.itstep.models.Status;

import java.util.List;

public interface StatusService {

    List<Status> findAll();

    Status findById(int id);

    Status save(Status status);

    Status update(Status status);

    void delete(Status status);

    void deleteById(int id);
}
