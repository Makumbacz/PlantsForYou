package com.example.plantsforyou;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.appuser.AppUserRole;
import com.example.plantsforyou.appuser.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
}
