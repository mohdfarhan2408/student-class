package com.example.studentclass.Controllers;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Status;
import com.example.studentclass.Models.Student;
import com.example.studentclass.Repositories.ClassRepo;
import com.example.studentclass.Services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/classes")
public class ClassController {

    private final ClassService classService;
    private final ClassRepo classRepo;

    @Autowired
    public ClassController(ClassService classService, ClassRepo classRepo) {
        this.classService = classService;
        this.classRepo = classRepo;
    }

    //Get by Id;
    @GetMapping(path = "/{id}")
    public ResponseEntity<Class> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.classService.getClassById(id), HttpStatus.OK);
    }

    //Get all active classes;
    @GetMapping(path = "/active")
    public ResponseEntity<Class> getAllActiveClasses(Class activeClass) {
        return new ResponseEntity<>(this.classService.getAllActiveClasses(activeClass), HttpStatus.OK );
    }

    //POST a class;
    @PostMapping(path = "/post")
    public ResponseEntity<Class> createStudent(@RequestBody Class newClass){
        return new ResponseEntity<>(this.classService.createNewClass(newClass), HttpStatus.CREATED );
    }

}
