package com.example.studentclass.Services;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Status;
import com.example.studentclass.Models.Student;
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


    public Class getClassById(Long id) {
        return classRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Class with id" + id + "doesnt exist"));
    }


    public Student getAllActiveClasses(Status status) {
        return null;

        /*
         * Check the table where class_status = Active.
         *
         *  */
    }

    public Class createNewClass(Class newClass) {
        return classRepo.save(newClass);
    }
}