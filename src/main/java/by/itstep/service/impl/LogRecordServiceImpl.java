package by.itstep.service.impl;

import by.itstep.models.LogRecord;
import by.itstep.repository.LogRecordRepository;
import by.itstep.service.LogRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogRecordServiceImpl implements LogRecordService {

    private final LogRecordRepository logRecordRepository;

    public LogRecordServiceImpl(LogRecordRepository logRecordRepository) {
        this.logRecordRepository = logRecordRepository;
    }

    @Override
    public List<LogRecord> findAll() {
        return logRecordRepository.findAll();
    }

    @Override
    public LogRecord findById(int id) {
        return logRecordRepository.findById(id).get();
    }

    @Override
    public LogRecord save(LogRecord logRecord) {
        return logRecordRepository.save(logRecord);
    }

    @Override
    public LogRecord update(LogRecord logRecord) {
        return logRecordRepository.saveAndFlush(logRecord);
    }

    @Override
    public void delete(LogRecord logRecord) {
    logRecordRepository.delete(logRecord);
    }

    @Override
    public void deleteById(int id) {
    logRecordRepository.deleteById(id);
    }
}
