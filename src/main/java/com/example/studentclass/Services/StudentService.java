package com.example.studentclass.Services;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Student;
import com.example.studentclass.Repositories.ClassRepo;
import com.example.studentclass.Repositories.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {

    private final StudentRepo studentRepo;
    private final ClassRepo classRepo;

    private final Logger LOG = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    public StudentService(StudentRepo studentRepo, ClassRepo classRepo) {
        this.studentRepo = studentRepo;
        this.classRepo = classRepo;
    }


    public Student getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with id: " + id + " doesn't exist"));
    }


    public List<Student> getActiveStudents() {
        return studentRepo.findAllActiveStudents();
    }

    public Student createNewStudent(Student student, Long id) {

        LOG.debug("Get the Student");
        Optional<Class> classId = classRepo.findById(id);
        if (!classId.isPresent()){
            throw new RuntimeException("Student with id " + classId + " doesn't exist");
        }

        Student newStudent = studentRepo.save(student);
        newStudent.setMyClass(classId.get());
        studentRepo.save(newStudent);
        return newStudent;
    }

}
