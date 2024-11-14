package com.example.demo_spring_mvc.service;

import com.example.demo_spring_mvc.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    Student findById(int id);

}
