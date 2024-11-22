package com.example.demo_spring_data_jpa_c07.controller;


import com.example.demo_spring_data_jpa_c07.dto.StudentDto;
import com.example.demo_spring_data_jpa_c07.model.Student;
import com.example.demo_spring_data_jpa_c07.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class RestStudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public ResponseEntity<List<Student>> getList() {
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);//200
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404
        }
        return new ResponseEntity<>(student, HttpStatus.OK);//200
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody StudentDto studentDto) {
        //  validate =>
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        return new ResponseEntity<>("Add success", HttpStatus.CREATED);//201
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404
        }
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
    }

}
