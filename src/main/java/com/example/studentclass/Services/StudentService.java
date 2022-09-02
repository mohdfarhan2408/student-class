package com.example.studentclass.Services;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Student;
import com.example.studentclass.Repositories.ClassRepo;
import com.example.studentclass.Repositories.StudentRepo;
import com.example.studentclass.dto.CreateStudentDto;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;
    private final ClassRepo classRepo;


    @Autowired
    public StudentService(StudentRepo studentRepo, ClassRepo classRepo) {
        this.studentRepo = studentRepo;
        this.classRepo = classRepo;
    }


    public Student getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student wit id: " + id + " doesn't exist"));
    }


    public List<Student> getActiveStudents() {
        return studentRepo.findAllActiveStudents();
    }

    public Student createNewStudent(CreateStudentDto dto, Long id) {

        Optional<Class> classId = classRepo.findById(id);
        if (!classId.isPresent()) {
            throw new RuntimeException("Class with id " + classId + " couldn't be found");
        }

//        Student newStudent = studentRepo.save(student);
//        newStudent.setMyClass(classId.get());
//        studentRepo.save(newStudent);
//        return newStudent;

        var student = Student.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .address(dto.getAddress())
                .status(dto.getStatus())
                ;

        Student newStudent = studentRepo.save(student);
        return newStudent;
    }
}
