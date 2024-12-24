package com.codegym.c0824g1_spring_boot.controller;

import com.codegym.c0824g1_spring_boot.model.Student;
import com.codegym.c0824g1_spring_boot.service.IClassroomService;
import com.codegym.c0824g1_spring_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {

    //    Field DI
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassroomService classroomService;

//    Constructor DI
//    private final IStudentService studentService;
//
//    public StudentController(IStudentService studentService) {
//        this.studentService = studentService;
//    }
//

    @GetMapping("")
    public ModelAndView viewAllStudent(Model model, @RequestParam(defaultValue = "") String name, @RequestParam(name = "page", defaultValue = "0")Integer page) {
        model.addAttribute("name", name);
        return new ModelAndView("student/list", "students", studentService.findByName(name, page));
    }

    @GetMapping("/create")
    public String viewAddStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classrooms", classroomService.getAll());
        return "student/add";
    }

    @PostMapping("/create")
    public String addStudent(@Validated @ModelAttribute("student") Student student,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("classrooms", classroomService.getAll());
            return "student/add";
        }
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
