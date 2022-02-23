package by.itstep.scheduleSendMail;

import by.itstep.models.LogRecord;
import by.itstep.service.LogRecordService;
import by.itstep.sendMail.SendMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * Class Schedule для отправки писем пользователям о просрочке книги по расписанию
 * @author Andrey Yarosh "andreyarosh7@gmail.com"
 * @version 1.0
 * @see LogRecordService
 * @see SendMail
 */

@PropertySource("classpath:schedule.properties")
@Component
public class Schedule {

   private final LogRecordService logRecordService;
   private final SendMail sendMail;
   private final Logger logger = LoggerFactory.getLogger(Schedule.class);

    public Schedule(LogRecordService logRecordService, SendMail sendMail) {
        this.logRecordService = logRecordService;
        this.sendMail = sendMail;
    }

    /** Метод проверяет все записи выданных книг и если книга просроченна отправляет письмо */
    @Scheduled(cron = "${schedule.cron}")
    public void runSchedule() throws InterruptedException {
        LocalDate localDate = LocalDate.now();
        List<LogRecord> logRecordList = logRecordService.findAll();
        for(LogRecord rec : logRecordList){
            if (localDate.isAfter(rec.getCloseDate())) {
                sendMail.sendMail(rec.getUser().getEmail());
               logger.info("Email send to  " + rec.getUser().getUserName() + " to email - " + rec.getUser().getEmail());
            }
            Thread.sleep(1000L);
        }
    }
}
