package com.example.studentclass.Configurations;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Status;
import com.example.studentclass.Repositories.ClassRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassConfig {


    @Bean
    CommandLineRunner commandLineRunner(ClassRepo repo){
        return args -> {

            Class class1 = new Class(
                    "Bestari",
                    Status.ACTIVE
            );

            Class class2 = new Class (
                    "Gemilang",
                    Status.INACTIVE
            );

            repo.save(class1);
            repo.save(class2);

        };


    }
}
