package by.itstep.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;

@PropertySource("classpath:mail.properties")
@ComponentScan("by.itstep")
@Configuration
public class MailSenderConfig {

    @Value("${mail.setHost}")
    private String mailSetHost;
    @Value("${mail.setPort}")
    private int mailSetPort;
    @Value("${mail.setUsername}")
    private String mailSetUsername;
    @Value("${mail.setPassword}")
    private String mailSetPassword;


    @Bean
    public MailSender mailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailSetHost);
        mailSender.setPort(mailSetPort);
        mailSender.setUsername(mailSetUsername);
        mailSender.setPassword(mailSetPassword);

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth" , "true");
        properties.put("mail.smtp.starttls.enable" , "true");
        properties.put("mail.debug" , "true");

        mailSender.setJavaMailProperties(properties);

        return  mailSender;
    }
}
