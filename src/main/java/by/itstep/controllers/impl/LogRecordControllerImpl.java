package by.itstep.controllers.impl;

import by.itstep.controllers.LogRecordController;
import by.itstep.models.LogRecord;
import by.itstep.service.LogRecordService;
import by.itstep.service.impl.LogRecordServiceImpl;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LogRecordControllerImpl implements LogRecordController {

    private final LogRecordService logRecordService;

    public LogRecordControllerImpl(LogRecordService logRecordService) {
        this.logRecordService = logRecordService;
    }

    @Override
    public List<LogRecord> findAll() {
        return logRecordService.findAll();
    }

    @Override
    public LogRecord findById(int id) {
        return logRecordService.findById(id);
    }

    @Override
    public LogRecord save(LogRecord logRecord) {
        return logRecordService.save(logRecord);
    }

    @Override
    public LogRecord update(LogRecord logRecord) {
        return logRecordService.update(logRecord);
    }

    @Override
    public void delete(LogRecord logRecord) {
            logRecordService.delete(logRecord);
    }

    @Override
    public void deleteById(int id) {
            logRecordService.deleteById(id);
    }
}
