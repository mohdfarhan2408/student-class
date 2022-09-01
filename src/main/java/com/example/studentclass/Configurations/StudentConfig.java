package com.example.studentclass.Configurations;


import com.example.studentclass.Models.Status;
import com.example.studentclass.Models.Student;
import com.example.studentclass.Repositories.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner2(StudentRepo repo){
    return args -> {

        Student student1 = new Student(
                "Afiq",
                17,
                "Melaka",
                Status.ACTIVE
        );

        repo.save(student1);

    };


}}
