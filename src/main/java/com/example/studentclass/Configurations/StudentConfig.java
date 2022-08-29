//package com.example.studentclass.Configurations;
//
//
//import com.example.studentclass.Modules.Class;
//import com.example.studentclass.Modules.Status;
//import com.example.studentclass.Modules.Student;
//import com.example.studentclass.Repositories.ClassRepo;
//import com.example.studentclass.Repositories.StudentRepo;
//import lombok.var;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class StudentConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepo repo){
//    return args -> {
//
//        var myStudent = Student.builder()
//                .name("Farhan")
//                .age(24)
//                .address("Cheras")
//                .myclass()
//                .status(Status.ACTIVE)
//                .build();
//
//        repo.save(myStudent);
//
//    };
//
//
//}}
