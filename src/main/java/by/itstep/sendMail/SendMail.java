package by.itstep.sendMail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@PropertySource("classpath:mail.properties")
@Component
public class SendMail {

    private final Logger logger = LoggerFactory.getLogger(SendMail.class);

    @Value("${msg.setFrom}")
    private String msgSetFrom;
    @Value("${msg.setSubject}")
    private String msgSetSubject;
    @Value("${msg.setText}")
    private String msgSetText;

    private final MailSender mailSender;

    public SendMail(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String email){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setFrom(msgSetFrom);
        msg.setSubject(msgSetSubject);
        msg.setText(msgSetText);
        mailSender.send(msg);
        logger.info(msg + " send to  - " + email );
    }
}
