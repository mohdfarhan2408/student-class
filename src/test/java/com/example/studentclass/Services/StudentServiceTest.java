package com.example.studentclass.Services;

import com.example.studentclass.Repositories.ClassRepo;
import com.example.studentclass.Repositories.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

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
    @Disabled
    void createNewStudent() {
        //given
        //when
        //then
    }
}