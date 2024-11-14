package com.example.demo_thymeleaf.repository;

import com.example.demo_thymeleaf.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void save(Student student);
    Student findById(int id);
}
