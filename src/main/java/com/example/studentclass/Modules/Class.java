package com.example.studentclass.Modules;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Class {

    @Id
    private Long id;
    private String name;


}
