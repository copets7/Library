package by.itstep.service.impl;

import by.itstep.models.LogRecord;
import by.itstep.repository.LogRecordRepository;
import by.itstep.service.LogRecordService;
import by.itstep.utils.SendMail;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class LogRecordServiceImpl implements LogRecordService {

    private final LogRecordRepository logRecordRepository;
    private final SendMail sendMail;


    public LogRecordServiceImpl(LogRecordRepository logRecordRepository, SendMail sendMail) {
        this.logRecordRepository = logRecordRepository;
        this.sendMail = sendMail;
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

    @Override
    public String delayDate(int id) {
        LocalDate localDate = LocalDate.now();
        String str = "  This book is out of date ";
        LogRecord rec = logRecordRepository.findById(id).get();
        if (localDate.isAfter(rec.getCloseDate())) {
            return str;
        }
        return "";
    }
}
