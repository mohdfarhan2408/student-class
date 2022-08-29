package com.example.studentclass.Modules;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "STUDENTS")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private String address;

    @Enumerated(EnumType.STRING)
    private Status status;



}
