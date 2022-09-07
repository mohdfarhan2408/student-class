package com.example.studentclass.Services;

import com.example.studentclass.Repositories.ClassRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClassServiceTest {

    @Mock
    private ClassRepo classRepo;
    private ClassService underTest;

    @Test
    @Disabled
    void getClassById() {
    }

    @BeforeEach
    void setUp() {
        underTest = new ClassService(classRepo);
    }

    @Test
    void getAllActiveClasses() {
        underTest.getAllActiveClasses();
        verify(classRepo).findAllActiveClasses();
    }
    @Test
    @Disabled
    void createNewClass() {
    }

    @Test
    @Disabled
    void updateClassDetails() {
    }
}