package com.example.studentclass.Controllers;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/classes")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    //Get class by Id;
    @GetMapping(path = "/{id}")
    public ResponseEntity<Class> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.classService.getClassById(id), HttpStatus.OK);
    }

    //Get all active classes;
    @GetMapping(path = "/active")
    public ResponseEntity<List<Class>> getActiveClasses() {
        return new ResponseEntity<>(this.classService.getAllActiveClasses(), HttpStatus.OK );
    }

    //POST a class;
    @PostMapping(path = "/create")
    public ResponseEntity<Class> createClass(@RequestBody Class newClass){
        return new ResponseEntity<>(this.classService.createNewClass(newClass), HttpStatus.CREATED );
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Class> updateClass(@RequestBody Class newClass, @PathVariable("id") Long id) {
        return new ResponseEntity<>(this.classService.updateClassDetails(newClass, id), HttpStatus.ACCEPTED);
    }

}
