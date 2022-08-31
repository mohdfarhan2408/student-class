package com.example.studentclass.Repositories;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query(value = "SELECT s FROM Student s WHERE s.status='ACTIVE' ")
    List<Student> findAllActiveStudents();
}
