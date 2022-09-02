package com.example.studentclass.dto;


import com.example.studentclass.Models.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;


@Getter
public class CreateStudentDto {

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("age")
    private Integer age;

    @NotNull
    @JsonProperty("address")
    private String address;

    @NotNull
    @JsonProperty("status")
    private Status status;
}
