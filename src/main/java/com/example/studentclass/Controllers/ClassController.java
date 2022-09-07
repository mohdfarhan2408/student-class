package com.example.studentclass.Controllers;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Services.ClassService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/class")
@Tag(name = "Class", description = "CRUD for Class domain object")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    //Get class by Id;
    @GetMapping(path = "/{id}")
    @Operation(summary = "get Class By Id", description = "return a class based on id", tags = {"Class"})
    public ResponseEntity<Class> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.classService.getClassById(id), HttpStatus.OK);
    }

    //Get all active classes;
    @GetMapping(path = "/active")
    @Operation(summary = "get all active Classes", description = "return a list of active classes", tags = {"Class"})
    public ResponseEntity<List<Class>> getActiveClasses() {
        return new ResponseEntity<>(this.classService.getAllActiveClasses(), HttpStatus.OK );
    }

    //POST a class;
    @PostMapping(path = "/create")
    @Operation(summary = "Post a class", description = "Create a class", tags = {"Class"})
    public ResponseEntity<Class> createClass(@RequestBody Class newClass){
        return new ResponseEntity<>(this.classService.createNewClass(newClass), HttpStatus.CREATED );
    }

}
