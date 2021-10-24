package by.itstep.controllers;

import by.itstep.models.LogRecord;

import java.util.List;

public interface LogRecordController {

    List<LogRecord> findAll();

    LogRecord findById(int id);

    LogRecord save(LogRecord logRecord);

    LogRecord update(LogRecord logRecord);

    void delete(LogRecord logRecord);

    void deleteById(int id);
}
