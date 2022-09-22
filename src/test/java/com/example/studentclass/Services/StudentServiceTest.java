package com.example.studentclass.Services;


import com.example.studentclass.Exceptions.NoRecordFoundException;
import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Student;
import com.example.studentclass.Repositories.ClassRepo;
import com.example.studentclass.Repositories.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static com.example.studentclass.Models.Status.ACTIVE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepo studentRepo;

    @Mock
    private ClassRepo classRepo;

    @InjectMocks
    private StudentService studentService;

    private Student student;
    private Class aClass;

    @BeforeEach
    public void setUp(){
        student = Student.builder()
                .id(1L)
                .name("Farhan")
                .status(ACTIVE)
                .address("Cheras")
                .age(24)
                .build();

        aClass = Class.builder()
                .id(1L)
                .name("Bestari")
                .status(ACTIVE)
                .build();
    }

    @DisplayName("JUnit test for find student by id")
    @Test
    public void givenStudentObject_whenFindById_thenReturnStudentObjectForThatId(){
        //given-Pre Condition Setup;
        given(studentRepo.findById(student.getId())).willReturn(Optional.of(student));

        //when-action or the behavior that we are going to test;
        Student savedStudent = studentService.getStudentById(student.getId());

        //then-verify the output.
        assertThat(savedStudent).isNotNull();

    }

    @DisplayName("JUnit test for find student by id which throws exception")
    @Test
    public void givenStudentObject_whenFindById_thenThrowsException(){
        //given-Pre Condition Setup;
        given(studentRepo.findById(student.getId())).willReturn(Optional.ofNullable(null));

        //when-action or the behavior that we are going to test;
        assertThrows(NoRecordFoundException.class, () -> {
            studentService.getStudentById(student.getId());
        });

        //then-verify the output.
        verify(studentRepo).findById(student.getId());

    }

    @DisplayName("JUnit test for create/save Student and assign it to which class")
    @Test
    public void givenStudentObject_whenSaveStudentAndAssignItToClassId_thenReturnStudentObject(){
        //given-Pre Condition Setup;
        given(studentRepo.save(student)).willReturn(student);
        given(classRepo.findById(aClass.getId())).willReturn(Optional.of(aClass));

        //when-action or the behavior that we are going to test;
        Student newStudent = studentService.createNewStudent(student, aClass.getId());

        //then-verify the output.
        assertThat(newStudent).isNotNull();
    }

    @DisplayName("JUnit test for get ACTIVE students")
    @Test
    public void givenStudentObject_whenGetActiveStudents_thenReturnStudentObjectThatActive(){
        //given-Pre Condition Setup;
        Student student1 = Student.builder()
                .id(1L)
                .name("Akmal")
                .status(ACTIVE)
                .address("Bangsar")
                .age(23)
                .build();

        given(studentRepo.findAllActiveStudents()).willReturn(Arrays.asList(student, student1));

        //when-action or the behavior that we are going to test;
        studentService.getActiveStudents();

        //then-verify the output.
        assertThat(student.getStatus()).isEqualTo(ACTIVE);
        assertThat(student1.getStatus()).isEqualTo(ACTIVE);
    }

}