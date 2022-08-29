package com.example.studentclass.Controllers;

import com.example.studentclass.Modules.Class;
import com.example.studentclass.Services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/classes")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    //Get by Id;
    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    Class getClassById(@PathVariable("id") Long id){
        return classService.getClassById(id);

    }

    //Get all active classes;

    //POST a class;
}
