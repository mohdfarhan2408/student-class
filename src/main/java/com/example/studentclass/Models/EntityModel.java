package com.example.studentclass.Models;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
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

    @PostUpdate
    public void generateUpdateAt() {
        this.updatedAt = LocalDateTime.now();
    }
}
