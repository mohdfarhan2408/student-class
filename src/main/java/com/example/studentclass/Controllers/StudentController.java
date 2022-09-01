package com.example.studentclass.Controllers;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Student;
import com.example.studentclass.Repositories.ClassRepo;
import com.example.studentclass.Repositories.StudentRepo;
import com.example.studentclass.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    private final StudentService studentService;
    private final ClassRepo classRepo;
    private final StudentRepo studentRepo;

    @Autowired
    public StudentController(StudentService studentService, ClassRepo classRepo, StudentRepo studentRepo) {
        this.studentService = studentService;
        this.classRepo = classRepo;
        this.studentRepo = studentRepo;
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
    @PostMapping(path = "/create/{classId}")
    public void createStudent(@RequestBody Student newStudent, @PathVariable("classId") Long id){
        Optional<Class> className = classRepo.findById(id);
        if (!className.isPresent()){
            throw new RuntimeException("Class not found");
        }

        Student std = studentRepo.save(newStudent);
        std.setMyclass(className.get());
        System.out.println(std.toString());
        studentRepo.saveAndFlush(std);
    }



}
