package by.itstep.utils;

import by.itstep.models.LogRecord;
import by.itstep.service.LogRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Schedule {

   private final LogRecordService logRecordService;
   private final SendMail sendMail;

    public Schedule(LogRecordService logRecordService, SendMail sendMail) {
        this.logRecordService = logRecordService;
        this.sendMail = sendMail;
    }

    @Scheduled(cron = "0 35 19 * * ?")
    public void runSchedule() throws InterruptedException {
        Logger logger = LoggerFactory.getLogger("Samplelogger");
        LocalDate localDate = LocalDate.now();
        List<LogRecord> logRecordList = logRecordService.findAll();
        for(LogRecord rec : logRecordList){
            if (localDate.isAfter(rec.getCloseDate())) {
                sendMail.sendMail(rec.getUser().getEmail());
               logger.info("Email send to  " + rec.getUser().getUserName());
            }
            Thread.sleep(1000L);
        }
    }
}
