package com.example.studentclass.Models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student extends EntityModel{

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private Integer age;
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    @ToString.Exclude
    private Class myClass;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Student(String name, Integer age, String address, Status status) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.status = status;
    }
}
