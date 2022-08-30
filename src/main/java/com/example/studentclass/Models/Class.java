package com.example.studentclass.Models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "class")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Class {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "myclass")
    @ToString.Exclude
    private Set<Student> students;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Class(String name, Status status) {
        this.name = name;
        this.status = status;
    }
}


