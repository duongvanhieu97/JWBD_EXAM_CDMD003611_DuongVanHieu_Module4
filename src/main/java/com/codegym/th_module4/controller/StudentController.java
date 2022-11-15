package com.codegym.th_module4.controller;

import com.codegym.th_module4.model.Classroom;
import com.codegym.th_module4.model.Student;
import com.codegym.th_module4.service.Class.IClassService;
import com.codegym.th_module4.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassService classService;
    @ModelAttribute("classrooms")
    public Iterable<Classroom> categories() {
        return classService.findAll();
    }
    @GetMapping("/list")
    public ModelAndView listStudent() {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students",studentService.findAll());
        return modelAndView;
    }
    @GetMapping("/showFormCreate")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("students", new Student());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("message", "New student created successfully");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Student> product = studentService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/student/edit");
            modelAndView.addObject("student", product.get());
            return modelAndView;
        } else {
            return new ModelAndView("student/error404");
        }
    }
    @PostMapping("/edit")
    public ModelAndView updateStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("/student/edit");
        modelAndView.addObject("student", student);
        modelAndView.addObject("message", "Student updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/student/delete");
            modelAndView.addObject("student", student.get());
            return modelAndView;

        } else {
            return new ModelAndView("/student/error404");
        }
    }
    @PostMapping("/delete")
    public String deleteStudent(@ModelAttribute("student") Student student) {
        studentService.remove(student.getId());
        return "redirect:student";
    }
}
