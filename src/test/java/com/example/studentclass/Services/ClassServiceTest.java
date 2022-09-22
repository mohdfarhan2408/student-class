package com.example.studentclass.Services;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Repositories.ClassRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static com.example.studentclass.Models.Status.ACTIVE;
import static org.assertj.core.api.Assertions.assertThat;



@ExtendWith(MockitoExtension.class)
class ClassServiceTest {

    @Mock
    private ClassRepo classRepo;

    @InjectMocks
    private ClassService classService;

    private Class aClass;

    @BeforeEach
    public void setup(){
        aClass = Class.builder()
                .id(1L)
                .name("Bestari")
                .status(ACTIVE)
                .build();
    }

    @DisplayName("JUnit test for find class by id")
    @Test
    public void givenClassObject_whenFindById_thenReturnClassObjectForThatId(){
        //given-Pre Condition Setup;
        given(classRepo.findById(aClass.getId())).willReturn(Optional.of(aClass));

        //when-action or the behavior that we are going to test;
        Class savedClass = classService.getClassById(aClass.getId());

        //then-verify the output.
        assertThat(savedClass).isNotNull();

    }

    @DisplayName("JUnit test for create/save Class")
    @Test
    public void givenClassObject_whenSaveClass_thenReturnClassObject(){
        //given-Pre Condition Setup;
        given(classRepo.save(aClass)).willReturn(aClass);

        //when-action or the behavior that we are going to test;
        Class savedClass = classService.createNewClass(aClass);

        //then-verify the output.
        assertThat(savedClass).isNotNull();
    }

    @DisplayName("JUnit test for get ACTIVE class")
    @Test
    public void givenClassObject_whenGetActiveClass_thenReturnClassObjectThatActive(){
        //given-Pre Condition Setup;
        Class class2 = Class.builder()
                .name("Kasturi")
                .status(ACTIVE)
                .build();
        given(classRepo.findAllActiveClasses()).willReturn(Arrays.asList(aClass, class2));

        //when-action or the behavior that we are going to test;
        classService.getAllActiveClasses();

        //then-verify the output.
        assertThat(aClass.getStatus()).isEqualTo(ACTIVE);
        assertThat(class2.getStatus()).isEqualTo(ACTIVE);
    }


}