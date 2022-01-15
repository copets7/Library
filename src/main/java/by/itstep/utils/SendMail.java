package by.itstep.utils;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class SendMail {

    private final MailSender mailSender;

    public SendMail(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String email){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setFrom("andreyarosh7@gmail.com");
        msg.setSubject("Вы просрочили книгу");
        msg.setText("Вы просрочили книгу");
        mailSender.send(msg);
    }
}
