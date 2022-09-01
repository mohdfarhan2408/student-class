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

public class Class extends EntityModel {


    @Id
    @SequenceGenerator(
            name = "class_sequence",
            sequenceName = "class_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "class_sequence"
    )
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "myClass")
    @ToString.Exclude
    private Set<Student> student;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Class(String name, Status status) {
        this.name = name;
        this.status = status;
    }
}


