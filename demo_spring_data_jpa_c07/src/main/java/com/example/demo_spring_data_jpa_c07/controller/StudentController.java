package com.example.demo_spring_data_jpa_c07.controller;


import com.example.demo_spring_data_jpa_c07.model.Student;
import com.example.demo_spring_data_jpa_c07.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @ModelAttribute("languages")
    public String[] getListLanguage (){
        System.out.println("--------------ok----------------------");
        return new String[]{"Java","PHP","JS"};

    }

    @GetMapping("")
    public String showList(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "student/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam String searchName, Model model){
        List<Student> studentList = studentService.seachByName(searchName);
        model.addAttribute("studentList",studentList);
        return "student/list";
    }
//    @GetMapping("/students")
//    public ModelAndView showList(){
//        List<Student> studentList = studentService.findAll();
////        ModelAndView modelAndView = new ModelAndView("student/list","studentList",studentList);
//        ModelAndView modelAndView = new ModelAndView("student/list");
//        modelAndView.addObject("studentList",studentList);
//        return modelAndView;
//    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("student", new Student());
        return "/student/create";
    }
    @GetMapping("/detail")
    public String detail1(@RequestParam int id,Model model){
        model.addAttribute("student", studentService.findById(id));
        return "/student/detail";
    }

    @GetMapping("/detail/{id}")
    public String detail2(@PathVariable int id,Model model){
        model.addAttribute("student", studentService.findById(id));
        return "/student/detail";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Student student,RedirectAttributes redirectAttributes){
        studentService.save(student);
        redirectAttributes.addFlashAttribute("mess", "thanh cong");
        return "redirect:/students";
    }
}