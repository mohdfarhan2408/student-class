package com.example.studentclass.Services;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Status;
import com.example.studentclass.Models.Student;
import com.example.studentclass.Repositories.ClassRepo;
import com.example.studentclass.Repositories.StudentRepo;
import com.sun.istack.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.lang.Nullable;

import java.util.Optional;

import static org.mockito.Mockito.verify;

class StudentServiceTest {

    @Mock
    private StudentRepo studentRepo;
    @Mock
    private ClassRepo classRepo;
    private StudentService underTest;

    @BeforeEach
    void setUp() {

        underTest = new StudentService(studentRepo, classRepo);
    }
    @Test
    @Disabled
    void getStudentById() {
    }

    @Test
    void getActiveStudents() {
        //when
        underTest.getActiveStudents();
        //then
        verify(studentRepo).findAllActiveStudents();
    }

    @Test
    void createNewStudent(Student student, Long id) {
        //given
        Student newStudent = new Student();
        Optional<Class> classId = classRepo.findById(id);
        //when
        newStudent = studentRepo.save(student);
        newStudent.setMyClass(classId.get());
        underTest.createNewStudent(newStudent);
        //then
        verify(studentRepo).save(newStudent);}
}