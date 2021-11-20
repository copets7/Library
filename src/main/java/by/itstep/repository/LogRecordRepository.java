package by.itstep.repository;

import by.itstep.models.LogRecord;
import by.itstep.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRecordRepository extends JpaRepository<LogRecord, Integer> {
    List<LogRecord> findAll();

    LogRecord save(LogRecord logRecord);

    void delete(LogRecord logRecord);
}
