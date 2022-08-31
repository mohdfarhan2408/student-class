package com.example.studentclass.Controllers;

import com.example.studentclass.Models.Student;
import com.example.studentclass.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //GET student By Id
    @GetMapping(path = "{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.studentService.getStudentById(id), HttpStatus.OK);
    }


    //Get list of all active students
    @GetMapping(path = "/active")
    public ResponseEntity<List<Student>> getAllActiveStudents() {
        return new ResponseEntity<>(this.studentService.getActiveStudents(), HttpStatus.OK );
    }

    //POST Student
    @PostMapping(path = "/post")
    public ResponseEntity<Student> createStudent(@RequestBody Student newStudent){
        return new ResponseEntity<>(this.studentService.createNewStudent(newStudent), HttpStatus.CREATED );
    }


}
