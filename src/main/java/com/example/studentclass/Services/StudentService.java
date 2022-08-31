package com.example.studentclass.Services;

import com.example.studentclass.Models.Student;
import com.example.studentclass.Repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public Student getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student wit id:" + id + "doesn't exist"));
    }


    public List<Student> getActiveStudents() {
        return studentRepo.findAllActiveStudents();
    }

    public Student createNewStudent(Student newStudent) {
        return studentRepo.save(newStudent);
    }
}
