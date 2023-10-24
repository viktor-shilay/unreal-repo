package com.shilay.unrealrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class UnrealRepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnrealRepoApplication.class, args);
    }

}
