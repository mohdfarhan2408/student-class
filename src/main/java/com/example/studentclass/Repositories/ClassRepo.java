package com.example.studentclass.Repositories;

import com.example.studentclass.Modules.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepo extends JpaRepository<Class, Long> {
}
