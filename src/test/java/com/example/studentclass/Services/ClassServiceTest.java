package com.example.studentclass.Services;

import com.example.studentclass.Exceptions.ClassNotFoundException;
import com.example.studentclass.Models.Class;
import com.example.studentclass.Repositories.ClassRepo;
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
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ClassServiceTest {

    @Mock
    private ClassRepo classRepo;

    @InjectMocks
    private ClassService classService;

    private Class class1;


    @BeforeEach
    public void setup(){
        class1 = Class.builder()
                .id(1L)
                .name("Bestari")
                .status(ACTIVE)
                .build();
    }

    @DisplayName("JUnit test for find class by id")
    @Test
    public void givenClassObject_whenFindById_thenReturnClassObjectForThatId(){
        //given-Pre Condition Setup;
        given(classRepo.findById(class1.getId())).willReturn(Optional.of(class1));

        //when-action or the behavior that we are going to test;
        Class savedClass = classService.getClassById(class1.getId());

        //then-verify the output.
        assertThat(savedClass).isNotNull();

    }

    @DisplayName("JUnit test for find class by id which throws exception")
    @Test
    public void givenClassObject_whenFindById_thenThrowsException(){
        //given-Pre Condition Setup;
        given(classRepo.findById(class1.getId())).willReturn(Optional.ofNullable(null));

        //when-action or the behavior that we are going to test;
        assertThrows(ClassNotFoundException.class, () -> {
            classService.getClassById(class1.getId());
        });

        //then-verify the output.
        verify(classRepo).findById(class1.getId());

    }

    @DisplayName("JUnit test for create/save Class")
    @Test
    public void givenClassObject_whenSaveClass_thenReturnClassObject(){
        //given-Pre Condition Setup;
        given(classRepo.save(class1)).willReturn(class1);

        //when-action or the behavior that we are going to test;
        Class savedClass = classService.createNewClass(class1);

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
        given(classRepo.findAllActiveClasses()).willReturn(Arrays.asList(class1, class2));

        //when-action or the behavior that we are going to test;
        classService.getAllActiveClasses();

        //then-verify the output.
        assertThat(class1.getStatus()).isEqualTo(ACTIVE);
        assertThat(class2.getStatus()).isEqualTo(ACTIVE);
    }


}