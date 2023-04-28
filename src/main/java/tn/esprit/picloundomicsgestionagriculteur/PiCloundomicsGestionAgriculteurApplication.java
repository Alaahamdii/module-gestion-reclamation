package tn.esprit.picloundomicsgestionagriculteur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAspectJAutoProxy
@EnableSpringConfigured
@SpringBootApplication
public class PiCloundomicsGestionAgriculteurApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiCloundomicsGestionAgriculteurApplication.class, args);
    }

}
