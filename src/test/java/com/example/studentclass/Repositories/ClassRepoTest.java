package com.example.studentclass.Repositories;

import com.example.studentclass.Configurations.ClassConfig;
import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Status;
import com.example.studentclass.Services.ClassService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class ClassRepoTest {

   @Autowired
   ClassRepo classRepo;
    @Test
    void checkIfAllActiveClasses() {

        Class class = new Class(
                "Bestari",
                Status.ACTIVE
        );
        classRepo.save(class);
        List<Class> activeClasses = classRepo.findAllActiveClasses();
        assertThat(activeClasses).isEqualTo(Status.ACTIVE);

    }
}