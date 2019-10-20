package com.weedoctor.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yuequan.jpa.soft.delete.repository.EnableJpaSoftDeleteRepositories;

@SpringBootApplication
@EnableJpaSoftDeleteRepositories
public class Applications {
    public static void main(String[] args) {
        SpringApplication.run(Applications.class, args);
    }
}
