package com.example.studentclass.Models;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class EntityModel {


    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;


    @PrePersist
    public void generateCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void generateUpdateAt() {
        this.updatedAt = LocalDateTime.now();
    }
}
