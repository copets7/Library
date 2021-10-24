package by.itstep.repository;

import by.itstep.models.LogRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRecordRepository extends JpaRepository<LogRecord, Integer> {
}
