package by.itstep.service.impl;

import by.itstep.models.LogRecord;
import by.itstep.repository.BookRepository;
import by.itstep.repository.LogRecordRepository;
import by.itstep.service.LogRecordService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class LogRecordServiceImpl implements LogRecordService {

    private final LogRecordRepository logRecordRepository;


    public LogRecordServiceImpl(LogRecordRepository logRecordRepository) {
        this.logRecordRepository = logRecordRepository;
    }

    public boolean stringToDate(String dateToParse, String dateToParse2) throws ParseException {
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse(dateToParse);
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateToParse2);
        date.before(date1);
        return true;
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
