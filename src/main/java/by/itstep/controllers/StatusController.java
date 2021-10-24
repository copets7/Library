package by.itstep.controllers;

import by.itstep.models.Status;

import java.util.List;

public interface StatusController {

    List<Status> findAll();

    Status findById(int id);

    Status save(Status status);

    Status update(Status status);

    void delete(Status status);

    void deleteById(int id);
}
