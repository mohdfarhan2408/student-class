package com.example.studentclass.Controllers;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Student;
import com.example.studentclass.Repositories.ClassRepo;
import com.example.studentclass.Repositories.StudentRepo;
import com.example.studentclass.Services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student")
@Tag(name = "Student", description = "CRUD for Student domain object")
public class StudentController {

    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }

    //GET student By Id
    @GetMapping(path = "/{id}")
    @Operation(summary = "get student by id", description = "return a student by it's id", tags = {"Student"})
    @ApiResponse(
            responseCode = "200", description = "Successful get a student by id",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Student.class)
            ))
    public ResponseEntity<Student> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.studentService.getStudentById(id), HttpStatus.OK);
    }


    //Get list of all active students
    @GetMapping(path = "/active")
    @Operation(summary = "get all active Students", description = "return a list of active students", tags = {"Student"})
    @ApiResponse(
            responseCode = "200", description = "Successful get the active students",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Student.class)
            ))
    public ResponseEntity<List<Student>> getAllActiveStudents() {
        return new ResponseEntity<>(this.studentService.getActiveStudents(), HttpStatus.OK );
    }

    //POST Student
    @PostMapping(path = "/create/{classId}")
    @Operation(summary = "Post a student", description = "create a new student and assign it to respective class", tags = {"Student"})
    @ApiResponse(
            responseCode = "201", description = "Successful create a student",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Student.class)
             ))
    public ResponseEntity<Student> createStudent(@RequestBody Student newStudent, @PathVariable("classId") Long id){
        return new ResponseEntity<>(this.studentService.createNewStudent(newStudent,id), HttpStatus.CREATED);
    }

}
