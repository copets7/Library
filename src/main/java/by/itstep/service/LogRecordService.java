package by.itstep.service;

import by.itstep.models.LogRecord;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LogRecordService {

    List<LogRecord> findAll();

    LogRecord findById(int id);

    LogRecord save(LogRecord logRecord);

    LogRecord update(LogRecord logRecord);

    void delete(LogRecord logRecord);

    void deleteById(int id);

     boolean delayDate();

}
