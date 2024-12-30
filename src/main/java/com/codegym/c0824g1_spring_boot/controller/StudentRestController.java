package com.codegym.c0824g1_spring_boot.controller;

import com.codegym.c0824g1_spring_boot.model.Student;
import com.codegym.c0824g1_spring_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class StudentRestController {

    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ResponseEntity<Page<Student>> getAll(@RequestParam(defaultValue = "")String name) {
        return new ResponseEntity<>(studentService.findByName(name, 0), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
