package com.example.studentclass.Services;

import com.example.studentclass.Repositories.ClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    private final ClassRepo classRepo;

    @Autowired
    public ClassService(ClassRepo classRepo) {
        this.classRepo = classRepo;
    }

    //Get a class based on Id;

    //Get a list of all active classes;

    //Create a class;
}