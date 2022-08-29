package com.example.studentclass.Models;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class EntityModel {

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
