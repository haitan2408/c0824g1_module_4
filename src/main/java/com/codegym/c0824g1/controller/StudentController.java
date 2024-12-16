package com.codegym.c0824g1.controller;

import com.codegym.c0824g1.model.Student;
import com.codegym.c0824g1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/create")
    public String viewAddStudent() {
        return "student/add";
    }

    @PostMapping("/create")
    public String addStudent(@RequestParam(name = "name") String nameStudent,
                             @RequestParam String email,
                             @RequestParam Float point,
                             @RequestParam String dob,
                             @RequestParam String idClass,
                             RedirectAttributes redirectAttributes) {
        Student student = new Student(nameStudent, email, point, dob, idClass);
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "Create student successfully!");
        return "redirect:/student";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable(name = "id") int id,
                                RedirectAttributes redirectAttributes) {
        studentService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete student successfully");
        return "redirect:/student";
    }
}
