package com.example.studentclass.Configurations;

import com.example.studentclass.Modules.Class;
import com.example.studentclass.Modules.Status;
import com.example.studentclass.Repositories.ClassRepo;
import com.example.studentclass.Repositories.StudentRepo;
import lombok.var;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassConfig {


    @Bean
    CommandLineRunner commandLineRunner(ClassRepo repo){
        return args -> {

            var myclass = Class.builder()
                    .name("Bestari")
                    .status(Status.ACTIVE)
                    .build();

            repo.save(myclass);

        };
    }
}
