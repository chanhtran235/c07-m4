package com.example.demo_spring_data_jpa_c07.controller;


import com.example.demo_spring_data_jpa_c07.dto.StudentDto;
import com.example.demo_spring_data_jpa_c07.model.Student;
import com.example.demo_spring_data_jpa_c07.service.IStudentService;
import com.example.demo_spring_data_jpa_c07.validate.CustomValidate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

//    @GetMapping("")
//    public String showList(Model model){
//        List<Student> studentList = studentService.findAll();
//        model.addAttribute("studentList",studentList);
//        return "student/list";
//    }


//    @GetMapping("/search")
//    public String search(@RequestParam String searchName, Model model){
//        List<Student> studentList = studentService.seachByName(searchName);
//        model.addAttribute("studentList",studentList);
//        return "student/list";
//    }

//    @GetMapping("")
//    public String search(@PageableDefault(size = 2,sort = "name", direction = Sort.Direction.ASC) Pageable pageable,
//                         @RequestParam(required = false,defaultValue = "") String searchName,
//                         Model model){
//        Page<Student> studentPage = studentService.searchByName(searchName,pageable);
//        model.addAttribute("studentPage",studentPage);
//        model.addAttribute("searchName",searchName);
//        return "student/list";
//    }

    @GetMapping("")
    public String search(@RequestParam(required = false, defaultValue = "0") int page,
//                        @RequestParam(required = false, defaultValue = "0") int size,
                         @RequestParam(required = false,defaultValue = "") String searchName,
                         Model model){
        Sort sort = Sort.by( Sort.Direction.ASC,"name").and(Sort.by("gender"));
        Pageable pageable = PageRequest.of(page,2,sort);
        Page<Student> studentPage = studentService.searchByName(searchName,pageable);
        model.addAttribute("studentPage",studentPage);
        model.addAttribute("searchName",searchName);
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
        model.addAttribute("studentDto", new StudentDto());
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
    public String save(@Validated @ModelAttribute StudentDto studentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        Student student = new Student();
        new StudentDto().validate(studentDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "/student/create";
        }
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        redirectAttributes.addFlashAttribute("mess", "thanh cong");
        return "redirect:/students";
    }
}