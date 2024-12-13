package com.codegym.c0824g1.controller;

import com.codegym.c0824g1.model.Student;
import com.codegym.c0824g1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

//    Field DI
    @Autowired
    private IStudentService studentService;

//    Constructor DI
//    private final IStudentService studentService;
//
//    public StudentController(IStudentService studentService) {
//        this.studentService = studentService;
//    }
//

    @GetMapping("")
    public ModelAndView viewAllStudent(Model model) {
//        List<Student> students = studentService.getAll();
//        model.addAttribute("students", students);
//        return "student/list";
        System.out.println("hello");
        return new ModelAndView("student/list", "students", studentService.getAll());
    }
}
