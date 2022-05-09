package com.example.plantsforyou;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.appuser.AppUserRole;
import com.example.plantsforyou.appuser.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class PlantsForYouApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantsForYouApplication.class, args);
    }
    @Bean
    CommandLineRunner run(AppUserService userService){
        return args -> {
            AppUser user = new AppUser("Jan", "Kowalski", "jan.kowalski@gmail.com", "1234", AppUserRole.USER);
            userService.signUpUser(user);
            userService.enableAppUser("jan.kowalski@gmail.com");
            user = new AppUser("Michal", "Nowak", "michal.nowak@gmail.com", "1234", AppUserRole.USER);
            userService.signUpUser(user);
            userService.enableAppUser("michal.nowak@gmail.com");
            user = new AppUser("Anna", "Byczek", "anna.byczek@gmail.com", "1234", AppUserRole.USER);
            userService.signUpUser(user);
            userService.enableAppUser("anna.byczek@gmail.com");
        };
    }
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(System.getenv().get("SMTP_USERNAME"));
        mailSender.setPassword(System.getenv().get("SMTP_PASSWORD"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
