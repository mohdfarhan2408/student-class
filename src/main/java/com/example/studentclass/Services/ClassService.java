package com.example.studentclass.Services;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Repositories.ClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    private final ClassRepo classRepo;

    @Autowired
    public ClassService(ClassRepo classRepo) {
        this.classRepo = classRepo;
    }


    public Class getClassById(Long id) {
        return classRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Class with id " +  id + " doesnt exist"));
    }


    public List<Class> getAllActiveClasses() {
        return classRepo.findAllActiveClasses();
    }

    public Class createNewClass(Class newClass) {
        return classRepo.save(newClass);
    }

    public Class updateClassDetails(Class classDetails, Long id) {

        Class updatedClass = classRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("Class with id " + id + " doesn't exist"));

            updatedClass.setName(classDetails.getName());
            updatedClass.setStatus(classDetails.getStatus());

            classRepo.save((updatedClass));
            return updatedClass;
    }
}