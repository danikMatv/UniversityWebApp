package com.foxmided.univerweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.foxmided.univerweb.Repository")
@EntityScan("com.foxmided.univerweb.Models")
@SpringBootApplication
public class UniverWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(UniverWebApplication.class,args);
    }
    
}
