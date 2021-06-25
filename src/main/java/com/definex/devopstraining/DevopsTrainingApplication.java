package com.definex.devopstraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.definex.devopstraining.data.dao")
@EntityScan("com.definex.devopstraining.data.model")
@SpringBootApplication
public class DevopsTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevopsTrainingApplication.class, args);
    }

}
