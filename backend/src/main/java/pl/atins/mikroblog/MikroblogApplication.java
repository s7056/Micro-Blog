package pl.atins.mikroblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class MikroblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MikroblogApplication.class, args);
    }

}