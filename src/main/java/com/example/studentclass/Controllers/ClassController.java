package com.example.studentclass.Controllers;

import com.example.studentclass.Models.Class;
import com.example.studentclass.Repositories.ClassRepo;
import com.example.studentclass.Services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
//    @GetMapping(path = "{id}")
//    @ResponseStatus(HttpStatus.OK)
//    Class getClassById(@PathVariable("id") Long id){
//        return classService.getClassById(id);
//
//    }

    @GetMapping()
    public String getClassById(){
        return "test";

    }

    @PostMapping("create")
    public String createClass(@RequestBody Class newclass){
        classRepo.save(newclass);
        return "test";
    }


    //Get all active classes;

    //POST a class;
}
