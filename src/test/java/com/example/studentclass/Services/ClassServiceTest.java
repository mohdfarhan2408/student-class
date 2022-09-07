package com.example.studentclass.Services;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Status;
import com.example.studentclass.Repositories.ClassRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClassServiceTest {

    @Mock
    private ClassRepo classRepo;
    private ClassService underTest;
//    private Class newClass;
//    private Long id;

    @BeforeEach
    void setUp() {
        underTest = new ClassService(classRepo);
    }
    @Test
    @Disabled
    void getClassById() {
//        //when
//        underTest.getClassById(id);
//        //then
//        verify(classRepo).findById(id);
    }
    @Test
    void getAllActiveClasses() {
        //when
        underTest.getAllActiveClasses();
        //then
        verify(classRepo).findAllActiveClasses();
    }
    @Test
    void createNewClass() {
        //given
        Class newClass = new Class(
                "Bestari",
                Status.ACTIVE
        );
        //when
        underTest.createNewClass(newClass);
        //then
        verify(classRepo).save(newClass);
    }

    @Test
    @Disabled
    void updateClassDetails() {
    }

}